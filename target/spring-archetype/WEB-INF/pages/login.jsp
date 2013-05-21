<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Spring security hibernate sample application</title>
</head>
<body>
<div id="login-error" style="color: red;">${error}</div>
<div id="login-msg" style="color: green;">${msg}</div>
<form id="loginForm" method="post" action="<%=request.getContextPath()%>/j_spring_security_check" name="login">
<table>
  <tr>
    <td>Username</td>
    <td>:</td>
    <td align="right"><input type="text" name="j_username"/></td>
  </tr>
  <tr>
    <td>Password</td>
    <td>:</td>
    <td align="right"><input type="password" name="j_password"/></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="right"><input type="submit" value="Login" /></td>
  </tr>
</table>
</form>
</body>
</html>
