   //页面加载时运行

    $(document).ready(function() {
        var pwd = null;
        /*onblur*/
        $('#pwdtw').blur(function() {
            pwd = $('#pwd').val();
        });
        /*初始化表单验证*/
        $('.ui.form').form({
            username: {
                identifier: 'username',
                rules: [{
                    type: 'empty',
                    prompt: '用户名必填！'
                }, {
                    type: 'regExp[/^[a-z0-9_-]{4,16}$/]',
                    prompt: '用户名必须是4-16位的数字或字母'
                }]
            },
            password: {
                identifier: 'password',
                rules: [{
                    type: 'length[3]',
                    prompt: '密码最少3位！'
                }]
            },
           /* passwordtw: {
                identifier: 'passwordtw',
                rules: [{
                    type: 'exactly[pwd]',
                    prompt: '{ruleValue}！'
                }]
            },*/
            age: {
                identifier: 'age',
                rules: [{
                    type: 'number',
                    prompt: '年龄必须是数字'
                }, {
                    type: 'empty',
                    prompt: '年龄必填！'
                }]
            },
            birthd: {
                identifier: 'birthd',
                rules: [{
                    type: 'empty',
                    prompt: '出生日期必填！'
                }]
            }
        }, {
            inline: true,
            on: 'blur'
        });
        /*初始化日历控件*/
        $('.date_picker').date_input();
        /*初始化折叠菜单*/
        $('.ui.accordion').accordion();
        /*点击弹窗*/
        $('.info').click(function() {
            //alert("message");
            $('.ui .modal').show();
        });
        $().click(function() {
            $('.ui .modal').hide();
        });
    });