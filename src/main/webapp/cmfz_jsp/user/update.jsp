<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<h1>用户修改</h1>
</head>

<body>

<div class="login">
			<form id="updateForm" action="${pageContext.request.contextPath}/user/updateUser" method="post" enctype="multipart/form-data">
				<input type="hidden" name="userId" value="${param.userId}">
				昵称:<input type="text"  name="name" maxlength="20"/><br>
				法名:<input type="text"  name="dharmaName" maxlength="20"/><br>
				性别:男<input type="radio"  name="sex" maxlength="20"/>
					 女:<input type="radio"  name="sex"  maxlength="20"/><br>
				手机号:<input type="text"  name="phone"  maxlength="20"/><br>
				省:<input type="text"  name="province"  maxlength="20"/><br>
				photo:<input type="file" name="file"   maxlength="20" autocomplete="off"/><br>
				密码:<input type="text" name="password"   maxlength="20" autocomplete="off"/><br>
				签名:<input type="text" name="autogroaph"   maxlength="20" autocomplete="off"/><br>
				市/区:<input type="text" name="city"   maxlength="20" autocomplete="off"/><br>
				<input type="submit" value="修改">
			</form>
		</div>
</body>
</html>