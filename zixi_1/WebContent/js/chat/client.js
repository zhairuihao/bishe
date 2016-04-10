(function() {
	var d = document, w = window, p = parseInt, dd = d.documentElement, db = d.body,
	// CSS1Compat-->标准兼容模式
	dc = d.compatMode == 'CSS1Compat', dx = dc ? dd : db, ec = encodeURIComponent,
	// 登录时间
	linedate = "",
	// 消息数量
	mesgcount = 0;
	w.CHAT = {
		msgObj : d.getElementById("message"),
		msgObjc : d.getElementById("chat"),
		screenheight : w.innerHeight ? w.innerHeight : dx.clientHeight,
		username : null,
		userid : null,
		socket : null,
		// 让浏览器滚动条保持在最低部
		scrollToBottom : function() {
			var scroll = this.msgObj.offsetHeight - this.msgObjc.clientHeight;
			// w.scrollTo(0, this.msgObj.clientHeight);
			this.msgObjc.scrollTop = scroll;
		},
		// 退出，本例只是一个简单的刷新
		logout : function() {
			// this.socket.disconnect();
			// location.reload();
			$('.modal').modal('hide');
		},
		// 提交聊天消息内容
		submit : function() {
			var content = d.getElementById("content").value;
			if (content != '') {
				var obj = {
					userid : this.userid,
					username : this.username,
					content : content
				};
				this.socket.emit('message', obj);
				d.getElementById("content").value = '';
			}
			return false;
		},
		// 随机生成的id
		genUid : function() {
			return new Date().getTime() + ""
					+ Math.floor(Math.random() * 899 + 100);
		},
		// 更新系统消息，本例中在用户加入、退出的时候调用
		updateSysMsg : function(o, action) {
			// 当前在线用户列表
			var onlineUsers = o.onlineUsers;
			// 当前在线人数
			var onlineCount = o.onlineCount;
			// 新加入用户的信息
			var user = o.user;

			// 更新在线人数
			var userhtml = '<div class="ui relaxed divided list">';
			// var separator = '';
			for (key in onlineUsers) {
				if (onlineUsers.hasOwnProperty(key)) {
					userhtml += '<div class="item"> <i class = "large github middle aligned icon"> </i> <div class = "content">'
							+ '<a class = "header"> '
							+ onlineUsers[key]
							+ ' </a> <div class = "description">'
							+ linedate.toLocaleTimeString()
							+ '</div> </div> </div>';
					// separator = ',';
				}

			}
			d.getElementById("onlinecount").innerHTML = '<h3 class="ui center aligned icon header">在线列表( '
					+ onlineCount + ')</h3>' + userhtml + '</div>';

			// 添加系统消息
			var html = '';
			html += '<div class="msg-system">';
			html += user.username;
			html += (action == 'login') ? ' 加入了聊天室' : ' 退出了聊天室';
			html += '</div>';
			var section = d.createElement('section');
			section.className = 'system J-mjrlinkWrap J-cutMsg';
			if (o.userid != CHAT.userid) {
				section.innerHTML = html;
			}
			this.msgObj.appendChild(section);
			this.scrollToBottom();
		},
		// 第一个界面用户提交用户名
		usernameSubmit : function() {
			var username = d.getElementById("username").value;
			if (username != "") {
				d.getElementById("loginbox").style.display = 'none';
				d.getElementById("chatbox").style.display = 'block';
				this.init(username);
				// $('.modal').modal('hide');
			}
			return false;
		},
		init : function(username) {
			/*
			 * 客户端根据时间和随机数生成uid,这样使得聊天室用户名称可以重复。
			 * 实际项目中，如果是需要用户登录，那么直接采用用户的uid来做标识就可以
			 */
			// this.userid = this.genUid();
			this.username = username;

			d.getElementById("showusername").innerHTML = this.username;
			this.msgObj.style.minHeight = (this.screenheight - db.clientHeight + this.msgObj.clientHeight)
					+ "px";
			this.scrollToBottom();

			// 连接websocket后端服务器
			this.socket = io.connect('ws://localhost:3000');

			// 告诉服务器端有用户登录
			this.socket.emit('login', {
				userid : this.userid,
				username : this.username
			});

			/**
             * [监听聊天室产生了多少消息]
             * @param  {[type]} mesgcount) {} [消息总数量]
             * @return {[type]}            [description]
             */
            this.socket.on('mesgcount', function(count) {

            });

			// 监听新用户登录
			this.socket.on('login', function(o) {
				CHAT.updateSysMsg(o, 'login');
			});

			// 监听用户退出
			this.socket.on('logout', function(o) {
				CHAT.updateSysMsg(o, 'logout');
			});

			// 监听消息发送
			this.socket.on('message', function(obj) {
				var isme = (obj.userid == CHAT.userid) ? true : false;
				var contentDiv = '<div>' + obj.content + '</div>';
				var usernameDiv = '<span>' + obj.username + '</span>';

				var section = d.createElement('section');
				if (isme) {
					section.className = 'user';
					section.innerHTML = contentDiv + usernameDiv;
				} else {
					section.className = 'service';
					section.innerHTML = usernameDiv + contentDiv;
					mesgcount++;
                    $('.mesgcount').html('CHAT <div class = "floating ui red label mesgcount">' + mesgcount + '</div>');
				}
				CHAT.msgObj.appendChild(section);
				CHAT.scrollToBottom();
			});
		}
	};
	// 初始化弹出层
	$('.mesgcount').click(function(event) {
		$('.modal.chat').modal('setting', 'closable', false).modal('show');
        //点击制空消息提示
        $('.mesgcount').html('CHAT');
        mesgcount = 0;
		CHAT.init(username);
		linedate = new Date();
	});
	// 通过“回车”提交信息
	d.getElementById("content").onkeydown = function(e) {
		e = e || event;
		if (e.keyCode === 13) {
			CHAT.submit();
		}
	};
})();
