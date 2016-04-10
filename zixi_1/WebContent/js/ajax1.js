
var XMLHttp=null ;
//创建对象
function createXMLHttpRequest(){
	   if(window.XMLHttpRequest){
		   XMLHttp= new XMLHttpRequest();
	   }else if(window.ActiveXObject){
	   var aVersions=["MSXML2.XMLHttp.6.0",
	      "MSXML2.XMLHttp.5.0", "MSXML2.XMLHttp.4.0",
	      "MSXML2.XMLHttp.3.0", "MSXML2.XMLHttp","Microsoft.XMLHttp"];
	      for(var i=0; i<aVersions.length; i++){
	         try{
	        	 XMLHttp=new ActiveXObject(aVersions[i]);
	            }catch(oError){
	            //Do nothing
	         }
	      }
	   }
	   
	}


	
	function check(){		
		//var name=document.getElementById("username").value;				
		//doAjax(name);	
		alert("check");
		doAjax();
	}
	
	
	function doAjax(){		
		alert("doAjax");
		createXMLHttpRequest();//第一步：创建XMLHttpRequest对象
		var popedom =  document.getElementById('popedom').value;
		alert(popedom);
		if(XMLHttp!=null){
			//第二步  建立与服务器的连接,向服务器发送请求
			XMLHttp.open("POST","ajaxuser.action?popedom="+popedom ,true);
			//第三步  设置请求的头信息
			XMLHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");
			//第四步  指定回调函数
			XMLHttp.onreadystatechange=processRequest;
			XMLHttp.send(null);
			XMLHttp.setRequestHeader("Cache-Control","no-cache");						
		}else{
			alert("不能创建XMLHttpRequest对象实例");
		}
	}
	
/*用途：给String对象添加去除左右空格方法*/ 
String.prototype.trim = function() {
var m = this.match(/^\s*(\S+(\s+\S+)*)\s*$/);
return (m == null) ? "" : m[1];
}
function processRequest(){
	if(XMLHttp.readyState==4){
	   if(XMLHttp.status==200){	   
		   var str= XMLHttp.responseText;
		   var ss = eval(str);
		   var dd = document.getElementById("dd");		  
		   
			/*	   for(var i=1;i<table.rows.length;i++){ 
						
					 var pro = table.rows[i].cells[5].innerText
				   }*/
		   
		   for(var i = 0 ; i < ss.length;i++){
		      alert(ss[i].username);//在这里就组装值，最后innerHTML到相应的id中
		      var t=document.createElement("table");
		      var tr=document.createElement("table");
		      alert("success");
		   }
	   }
	   else
		   { 
		   alert("操作失败，请检查您所输入的参数");}
	} 
}

  function ajax(){
	  
	  alert("我是ajax");
  }
