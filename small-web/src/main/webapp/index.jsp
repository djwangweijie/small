<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored ="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加删除修改查询</title>
</head>
<body>
		<form action="add" method="post">
			<input type="text"  name="sname"/>
			<input type="text"  name="bir"/>
			<input type="submit"  value="增加"/>
		</form>
		
		<form action="update" method="post">
			<input type="text"  name="sid"/>
			<input type="text"  name="sname"/>
			<input type="text"  name="bir"/>
			<input type="submit"  value="修改"/>
		</form>
		<form action="delete" method="post">
			<input type="text"  name="sid"/>
			<input type="submit"  value="删除"/>
		</form>
		<a href="select">查找</a>
		<a href="select1">分页查找</a>
		<a href="tx">事务</a>
		<p>以下内容是关于redis操作</p>
		<a href="selectRedis1">查找(数据一致性不高)</a>
		<a href="selectRedis2">查找无参(数据一致性高)</a>
		<a href="selectRedis3">查找有参(数据一致性高)</a>
		<a href="insertRedis1">插入数据更改缓存</a>
</body>
</html>