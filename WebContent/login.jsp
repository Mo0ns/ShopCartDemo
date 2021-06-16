<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录login</title>
</head>
<body>
<h1>用户登录</h1>
<h6 style="color: red;">用户名：admin  密码：admin</h6>
   <hr/>
   <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
   <table>
   	<tr>
   		<td>用户名:</td>
   		<td>
   			<input type="text" name="username">
   		</td>
   	</tr>
   	<tr>
   		<td>密 码:</td>
   		<td>
   			<input type="password" name="password">
   		</td>
   	</tr>
   </table>
   <input type="submit" value="登录">
   </form>
   <h1 style="color: red;"><%=msg!=null?msg:"" %></h1>
</body>
</html>