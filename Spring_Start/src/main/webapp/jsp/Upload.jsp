<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: hero_
  Date: 2022/3/21
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>

</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick18" method="post" enctype="multipart/form-data">
        文件：<input type="file" name="uploadFile"><br>
             <input type="submit" value="提交">
    </form>
</body>
</html>
