<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="statics/css/login.css" />
</head>
<body>
     <div id="login">
     </div>
     <div class="con">
           <h1>登&nbsp;&nbsp;&nbsp;&nbsp;录</h1>
            <hr/>
            <form action="UserServlet?flag=login" method="post" >
               <table>
                  <tr class="one">
                     <td style="padding-right: 10px;">用户名</td>
                     <td><input size="15" style="width:250px;height: 30px;border: 0px;background-color: white;opacity: 0.7;padding-left: 10px;" name="userName" id="userName" placeholder="请输入用户名" required="required" /></td>
                  </tr>
                   <tr class="two">
                     <td style="padding-right: 10px;">密&nbsp;&nbsp;&nbsp;码</td>
                     <td><input type="password" size="15" style="width:250px;height: 30px;border: 0px;background-color: white;opacity: 0.7;padding-left: 10px;"  name="password" id="password" placeholder="请输入密码" required="required" /> </td>
                   
                  </tr>
                  <tr class="three">
                     <td colspan="2" >
                        <input name="role" type="radio" value="1" />管理员
                        <input name="role" type="radio" value="2" />校长
                        <input name="role" type="radio" value="3" />教员
                        <input name="role" type="radio" value="4" />班主任
                        <input name="role" type="radio" value="5" />教务
                        <input name="role" type="radio" value="6" />学生<br>
                        <c:if test="${mess!=null}"><br/><span style="color: red;font-size: 14px;">${mess}</span></c:if>
                     </td>
                  </tr>
                  <tr class="four">
                     <td colspan="2" >
                     <input style="padding-right:8px;margin-right:60px;background-color: white;opacity: 0.7;text-align:center;font-size:18px;width:90px;height: 30px;border: 0px;padding-left: 10px;" type="submit" value="登&nbsp;&nbsp;录" />
                     <input style="padding-right:8px;background-color: white;opacity: 0.7;text-align:center;font-size:18px;width:90px;height: 30px;border: 0px;padding-left: 10px;" type="reset" value="取&nbsp;&nbsp;消" />
                     </td>
                  </tr>
                  <tr class="five">
                    <td colspan="2"><a href="#">忘记密码?</a></td>
                  </tr>
               </table>
            </form>
       </div>
       
</body>
</html>