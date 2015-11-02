$(function () {
    $.validator.setDefaults({
        errorElement: 'label'
    });
    jQuery.validator.addMethod("ismobile", function (value, element) {
        var mobile = /^1[3|4|5|7|8]\d{9}$/;
        return this.optional(element) || (mobile.test(value));
    }, "手机格式不对");
    $("#register").validate({
        rules: {
            validatecode: {
                required: true,
                remote: {
                    type: "POST",
                    url: "/mobile/api.do?method=api.mobile.code.velidate",
                    data: {mobilePhone: function () {
                        return $('#mobilePhone').val()
                    }}
                }
            },
            mobilePhone: {
                required: true, ismobile: true, remote: {
                    type: "POST",
                    url: "/mobile/api.do?method=api.mobile.mobile.velidate"
                }
            },
            password: {required: true}
        }, messages: {
            mobilePhone: {
                required: "请填写手机号码",
                ismobile: "手机号码不正确，请检查",
                remote: '手机号码已注册,请使用其他手机号码'
            },
            validatecode: {
                remote: "验证码验证失败,请检查手机号码与验证码",
                required: " 请填写验证码"
            },
            password: {
                required: " 请输入密码"
            }
        },
        /*errorPlacement: function (error, element) {
         error.appendTo(element.parent().next());
         }*/
        debug: true,
        errorLabelContainer: "#messageBox"
    });

    $("#agreeCbx").hide();
    $("#getVerifiyCode").click(function () {
        if(wait!=60&&wait!=0){
            return;
        }
        wait = 60;
        //验证通过后 的js代码写在这里
        // 验证手机号码是否已填写
        $('#validatecode').val('');
        var mobilePhone = $('#mobilePhone').val();
        var mobile = /^1[3|4|5|7|8]\d{9}$/;
        if (!mobilePhone) {
            if ($('#messageBox').children().length > 0) {
                $('#messageBox').children(":first").html('请先填写手机号码');
            } else {
                $('#messageBox').append("<label for='mobilePhone' class='error'>请先填写手机号码</label>");
            }
            return;
        }
        if (!mobile.test(mobilePhone)) {
            $('#messageBox').children(":first").html('手机号码格式不正确 ');
            return;
        }
        //获取验证码
        // 设置当前值为disable
        // $("#getVerifiyCode").html("10秒");
        time($("#getVerifiyCode"))
        $.ajax({
            url: "/mobile/api.do?method=api.mobile.verfiycode.get",
            data: '{"mobilePhone":"' + mobilePhone + '"}',
            contentType: "application/json",
            type: 'POST',
            dataType: 'json',
            success: function (data) {
//                wait = 0;
            }
        });
    });
    $('#regbutton').click(function () {
        //注册用户数据
        if ($("#register").valid()) {
            var mobilePhone = $('#mobilePhone').val();
            var password = $("#password").val();
            $.ajax({
                url: "/mobile/api.do?method=api.mobile.user.register",
                data: "{\"account\":\"" + mobilePhone + "\",\"mobilePhone\":" + mobilePhone + ",\"password\":\"" + password + "\"}",
                contentType: "application/json",
                type: 'POST',
                dataType: 'json',
                success: function (msg) {
                    if (msg.errors.length > 0) {
                        var errors = [];
                        for (var i = 0; i < msg.errors.length; i++) {
                            errors.push(msg.errors[i].message);
                        }
                    } else {
                        window.location.href = "../login";
                    }
                }});
        }
    });
    $("#mobilePhone,#password,#validatecode").bind('input propertychange', function () {
        if ($('#validatecode').val()) {
            wait = 0;
        }
        if ($("#register").valid()) {
            $(".login-button-default").removeAttr("disabled");
            $(".login-button-default").addClass("login-button-pink");
        } else {
            $(".login-button-default").attr("disabled", "disabled");
            $(".login-button-default").removeClass("login-button-pink");
        }
    });
});

var wait = 60;//时间
function time(o) {//o为按钮的对象，p为可选，这里是60秒过后，提示文字的改变
    if (wait == 0) {
        o.removeAttr("disabled");
        o.html("获取验证码");//改变按钮中value的值
        //p.html("如果您在1分钟内没有收到验证码，请检查您填写的手机号码是否正确或重新发送");
        wait = 60;
    } else {
        o.attr("disabled", true);//倒计时过程中禁止点击按钮
        o.html(wait + "秒后重发");//改变按钮中value的值
        wait--;
        setTimeout(function () {
                time(o);//循环调用
            },
            1000)
    }
}