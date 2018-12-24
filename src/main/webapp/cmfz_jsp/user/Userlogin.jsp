<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
	<script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
            $("#captchaImage").click(function(){//点击更换验证码
                $("#captchaImage").attr("src","${pageContext.request.contextPath}/codeController/code?date="+new Date().getTime());
            });
			//点击验证验证码
			$("#enCode").blur(function(){
			    var code = $("#enCode").val();
			    var span=$("#span")
			   $.post("${pageContext.request.contextPath}/codeController/fir",{"code":code},function(result){
					if(result.success){
					    span.html(result.message);
					}else{
					    span.html("<font id='font' style='color: deeppink'>"+result.message+"</font>");
					}
			   },"JSON")
			});
			//  form 表单提交
			$("#loginForm").bind("submit",function(){
			    var t=$("#font").text();
			    var code=$("#enCode").val();
			    if(t!="验证码错误" && code!=""){
                    return true;
                }else{
			        return false;
				}
            });
		});

	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/user/login" method="post" >
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="${pageContext.request.contextPath}/img/header_logo.gif" />
							</td>
							<th>
								手机号:
							</th>
							<td>
								<input type="text"  name="phone" class="text" value="" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="password" class="text" value="" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="code" class="text captcha" maxlength="4" autocomplete="off"/>

								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/codeController/code" title="点击更换验证码"/>
								<h4 id="span"></h4>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>

					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<h5 style="color: deeppink">${requestScope.error}</h5>
							<input type="button" class="homeButton" value="" onclick="location.href=''"><input type="submit" class="loginButton" value="登录">
							<input type="button"  value="注册》》" onclick="location.href='${pageContext.request.contextPath}/cmfz_jsp/user/add.jsp'">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>