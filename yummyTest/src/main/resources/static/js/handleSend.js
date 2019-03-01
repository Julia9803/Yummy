var InterValObj; //timer变量，控制时间
var count = 30; //间隔函数，1秒执行
var curCount;//当前剩余秒数
const baseAddress = "http://localhost:8081/";

function sendEmail() {
    var isSuccess = false;
    $.ajax({
        url: baseAddress + "/email?email=" + $('input[name=email]').val().trim(),
        complete: function (msg) {
            var code = msg.status;
            if (code === 200) {
                curCount = count;
                //设置button效果，开始计时
                $("#btnSendCode").attr("disabled", "true");
                document.getElementById("btnSendCode").innerText = curCount + "秒后可重新发送";
                InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
                isSuccess = true;
            } else {
                alert("发送失败，请确认邮箱是否正确");
            }
        }
    });
    return isSuccess;

}

//timer处理函数
function SetRemainTime() {
    if (curCount === 0) {
        window.clearInterval(InterValObj);//停止计时器
        $("#btnSendCode").removeAttr("disabled");//启用按钮
        document.getElementById("btnSendCode").innerText = "重新发送验证码";
    }
    else {
        curCount--;
        document.getElementById("btnSendCode").innerText = curCount + "秒后可重新发送";
    }
}