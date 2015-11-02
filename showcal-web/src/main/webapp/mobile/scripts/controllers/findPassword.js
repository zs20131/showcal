$(function () {
    $.validator.setDefaults({
        errorElement: 'label'
    });
    jQuery.validator.addMethod("ismobile", function (value, element) {
        var mobile = /^1[3|4|5|7|8]\d{9}$/;
        return this.optional(element) || (mobile.test(value));
    }, "手机格式不对");
    $("#step1").validate({
        rules: {
            code: {required: true,
                remote: {
                    type: "POST",
                    url: "/base/api.do",             //servlet
                    data: { method: 'api.base.code.velidate', data: function () {
                        var mobilePhone = $('#mobilePhone').val();
                        var code = $('#code').val();
                        return "{'mobilePhone':'" + mobilePhone + "','code':'" + code + "'}"
                    }
                    }
                }
            },
            mobilePhone:{required: true,ismobile:true,remote: {
                type: "POST",
                url: "/base/api.do",             //servlet
                data: { method: 'api.base.mobileexist.velidate', data: function () {
                    var mobilePhone = $('#mobilePhone').val();
                    return "{'mobilePhone':'" + mobilePhone + "'}"
                }
                }
            }},
            isAgree :{required: true}
        },messages:{
            mobilePhone:{
                required: "请填写手机号码",
                ismobile: "手机号码不正确，请检查",
                remote:'该手机号码未注册,请检查手机号码'
            },
            code:{
                remote :"验证码验证失败,请检查手机号码与验证码",
                required:"请填写验证码"
            },
            isAgree:{
                required:"请同意云地网服务协议"
            }
        },
        errorLabelContainer:"#messageBox"
    });

    $("#agreeCbx").hide();
    $("#getVerifiyCode").click(function () {

        //验证通过后 的js代码写在这里
        // 验证手机号码是否已填写
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
            $('#messageBox').children(":first").html('手机号码格式不正确');
            return;
        }
        //获取验证码
        // 设置当前值为disable
        // $("#getVerifiyCode").html("10秒");
        time($("#getVerifiyCode"))
        $.ajax({ url: "/base/api.do", data: {method: "api.base.mobileexistcode.get", data: '{mobilePhone:' + mobilePhone + '}'}, type: 'POST', dataType: 'json', success: function (data) {
            if(data.errors.length>0){
                wait = 0;
            }
        }});
    })
    $("#isAgree").val(true);
    $(".statistic tr:even").css("background", "#f7f7f7");
});
var wait = 60;//时间
function time(o) {//o为按钮的对象，p为可选，这里是60秒过后，提示文字的改变
    if (wait == 0) {
        o.removeAttr("disabled");
        o.html("免费获取验证码");//改变按钮中value的值
        //p.html("如果您在1分钟内没有收到验证码，请检查您填写的手机号码是否正确或重新发送");
        wait = 60;
    } else {
        o.attr("disabled", true);//倒计时过程中禁止点击按钮
        o.html(wait + "秒后重新获取");//改变按钮中value的值
        wait--;
        setTimeout(function () {
                time(o);//循环调用
            },
            1000)
    }
}