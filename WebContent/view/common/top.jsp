<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顶部</title>
<link rel="stylesheet" type="text/css" href="../../statics/css/top.css" />
</head>
<body>
   <div id="top">
       <p>欢迎您:${user.userName}&nbsp;&nbsp;&nbsp;<a style="text-decoration: none;" href="../../UserServlet?flag=logout" target="_blank">退出</a></p>
  </div>
</body>
</html>