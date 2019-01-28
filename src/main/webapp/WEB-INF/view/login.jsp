<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/24
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">--%>
    <%--<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/static/jquery-1.11.3.min.js" type="text/javascript"></script>
</head>
<body>
这是登录页面
<form id="inputForm" method="post" action="">
    <div>
        <label>用户名</label>
        <input type="text" name="username">
    </div>
    <div>
        <label>密码</label>
        <input type="password" name="password">
    </div>
   <div>
       <input id="btnSave" name ="btnRegister" type="button" value="注册" onclick="register();">
       <input  id="btnSubmit" name ="btnLogin" type="button" value="登录" onclick="login();" >

   </div>

</form>
</body>

</html>
