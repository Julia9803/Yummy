<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Amaze UI Admin index Examples</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
  <script src="js/handleSend.js"></script>
  <link rel="stylesheet" href="css/amazeui.min.css" />
  <link rel="stylesheet" href="css/admin.css">
  <link rel="stylesheet" href="css/app.css">
</head>

<body data-type="login">

  <div class="am-g myapp-login">
	<div class="myapp-login-logo-block  tpl-login-max">
		<div class="myapp-login-logo-text">
			<div class="myapp-login-logo-text">
				Yummy!<span> SignUp</span> <i class="am-icon-skyatlas"></i>
				
			</div>
		</div>

		<div class="am-u-sm-10 login-am-center">
			<form class="am-form" action="/user" method="post">
				<fieldset>
					<div class="am-form-group">
						<input type="email" class="" name="email" id="doc-ipt-email-1" placeholder="输入电子邮件" required>
					</div>
                    <button type="button" id="btnSendCode" name="btnSendCode" style="margin-bottom: 5px;"
                            class="myapp-login-button am-btn am-btn-secondary"
                            onclick="sendEmail()">发送验证码
                    </button>
                    <div class="am-form-group">
                        <input type="text" class="" id="code" name="code" placeholder="验证码" required>
                        <script type="text/javascript">
                            document.getElementById("code").addEventListener("oninput",function () {
                                const codeTrue = "<%=session.getAttribute("code")%>";
                                alert(codeTrue);
                                const code = document.getElementById("code").value;
                                if(code !== codeTrue) {
                                    document.getElementById("submit").style = "disabled";
                                } else {
                                    document.getElementById("submit").style = "";
                                }
                            },false)
                        </script>
                    </div>
                    <div class="am-form-group">
                        <input type="text" class="" name="phoneNumber" id="doc-vld-name" placeholder="输入手机号码" required>
                    </div>
                    <div class="am-form-group">
                        <input type="text" class="" name="name" id="doc-vld-name" placeholder="输入用户名" required>
                    </div>
                    <div class="am-form-group">
                        <input type="text" class="" name="bankAccount" id="doc-vld-name" placeholder="输入银行账户" required>
                    </div>
					<div class="am-form-group">
						<input type="password" class="" name="password" id="doc-ipt-pwd-1" placeholder="设置个密码吧" required>
					</div>
					<p><button type="submit" id="submit" class="am-btn am-btn-default">注册</button></p>
				</fieldset>
			</form>
		</div>
	</div>
</div>

  <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.min.js"></script>
  <script src="js/promise.min.js"></script>
  <script src="js/app.js"></script>
</body>

</html>