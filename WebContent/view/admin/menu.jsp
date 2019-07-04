<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
<link rel="stylesheet" type="text/css" href="../../statics/css/menu.css" />
</head>
<body>
        <!-- 循环显示菜单 -->
  		<ul>
  		   <c:forEach items="${menuList}" var="menu">
              <li onclick="showSubMenu('showsubMenu',${menu.id},this)"><a href="javascript:void(0)" >${menu.name}</a>&nbsp;<img id="sys" alt="" src="../../statics/images/menu.jpg" width="15" height="15"></li>
           </c:forEach>
  		</ul>
  		
  		
  		
  		<script type="text/javascript" src="../../statics/js/jquery-1.8.3.min.js"></script>
  		<script type="text/javascript">
  		   $(function(){
  			  
  		   });
  		   function showSubMenu( flag, id,dom){
  			   var dom=$(dom);
  			   var index=dom.index();
  			   $("li:gt("+index+")").remove();
  			   $.post("../../MenuServlet",{"flag":flag,"parentId":id},function(data){
  				   
  				 for(var i=0;i<data.length;i++){
  					dom.append("<li class='two'><a target='frmright' href='../../ShowAllUserServlet?menuId="+data[i].id+"'>"+data[i].name+"</a></li>") 
  				 }
  			   },"json");
  		   }
  		   
  		  
  		   
  		   
  		
  		</script>
</body>
</html>