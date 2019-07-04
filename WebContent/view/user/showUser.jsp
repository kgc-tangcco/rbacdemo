<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户</title>
<link rel="stylesheet" type="text/css" href="statics/css/showUser.css" />
</head>
<body>

  <div id="con">
    <h1>用户管理</h1>
    <hr><br><br>
     <div class="userlist">
         <table  cellpadding="0" cellspacing="0">
         	<tr>
         	   <th>用户名</th>
         	   <th>密码</th>
         	   <th>用户昵称</th>
         	   <th>电话</th>
         	   <th>邮箱</th>
         	   <th>添加时间</th>
         	   <th>修改时间</th>
         	   <th>账户状态</th>
         	   <th>是否为超级管理员</th>
         	   <th>操作</th>
         	</tr>
             <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.userName}</td>
                    <td>${user.password}</td>
                    <td>${user.nickName}</td>
                    <td>${user.telephone}</td>
                    <td>${user.email}</td>
                    <td>${user.createTime}</td>
                    <td>${user.updateTime}</td>
                    <td>${user.accountStatus}</td>
                    <td>${user.status}</td>
                    <td>
                    <a href="javascript:void(0)" onclick="showgrant(this,${user.id})">授权</a>
                      <div class="roleid">
                         <%-- <c:forEach items="${roleList}" var="role">
                           <c:if test="${role.id==1}"><input name="role" class="role" type="checkbox" value="1" />管理员</c:if>
                           <c:if test="${role.id==2}"><input name="role" class="role" type="checkbox" value="2" />校长</c:if>
                           <c:if test="${role.id==3}"><input name="role" class="role" type="checkbox" value="3" />教员</c:if>
							<c:if test="${role.id==4}"><input name="role" class="role" type="checkbox" value="4" />班主任</c:if>
							<c:if test="${role.id==5}"><input name="role" class="role" type="checkbox" value="5" />教务</c:if>
                           <c:if test="${role.id==6}"><input name="role" class="role" type="checkbox" value="6" />学生</c:if>
                         </c:forEach> --%>
                         <input  type="button" value="确定" onclick="grant(${user.id})" />
                      </div>
                      
                    </td>
                </tr>
             </c:forEach>
         
         </table>
     
     </div>
  </div>
<script type="text/javascript" src="statics/js/jquery-1.8.3.min.js"></script>  
<script type="text/javascript">
   function showgrant(dom,id){
	  
	    $.post("RoleServlet","id="+id,function(data){
	    	for(var i=0;i<data.length;i++){
		    	$(dom).next().prepend("<input name='role' class='role' type='checkbox' value='"+data[i].id+"' />"+data[i].name);
	    	}
	    },"json");
	  $(dom).next().css("display","block");
   
   }
   function grant(id){
	   var roles=$(".role");
	  
	   var rolearray=new Array();
	   var j=0;
	   for(var i=0;i<roles.length;i++){
		   if (roles[i].checked) {
			rolearray[j]=$(roles[i]).val();
			j++;
		}
	   }
	  
	  location.href="MenuServlet?userId="+id+"&flag=addUserRole&roles="+rolearray;
   }
</script>
  
</body>
</html>