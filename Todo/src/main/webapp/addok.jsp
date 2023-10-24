<%@page import="com.test.todo.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//addok.jsp
	
	//1. 데이터 가져오기
	//2. DB 연결 > insert 작업
	//3. 피드백 > list.jsp 이동
	
	
	//1.
	request.setCharacterEncoding("UTF-8");
	
	String todo = request.getParameter("todo");
	
	//2.
	Connection conn = null;
	PreparedStatement stat = null;
	int result = 0;
	
	try {
		
		conn = DBUtil.open();
		
		String sql =  "insert into tblTodo (seq, todo, state, regdate) values (seqTodo.nextVal, ?, DEFAULT, DEFAULT)";
		
		stat = conn.prepareStatement(sql);
		stat.setString(1, todo);
		
		result = stat.executeUpdate();
		
		stat.close();
		conn.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	//java.lang.ClassNotFoundException: oracle.jdbc.driver.OracleDriver

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="inc/asset.jsp" %>
<style>

</style>
</head>
<body class="narrow">
	<!-- templete.jsp > addok.jsp -->
	<%@ include file="inc/header.jsp" %>
	
	<div><%= result %></div>
	
	<% if (result == 1) { %>
	<div class="message">
		할일이 등록되었습니다.
		<div><a href="list.jsp">목록보기</a></div>
	</div>
	<% } else { %>
	<div class="message">
		할일 등록을 실패했습니다.
		<div><a href="add.jsp">돌아가기</a></div>
	</div>
	<% } %>
	
	<script>	
		
		<% if (result == 1) { %>
		//alert('할일 등록 성공');
		location.href = 'list.jsp';
		<% } else { %>
		alert('할일 등록 실패');
		location.href = 'add.jsp';
		<% } %>
	
	</script>

</body>
</html>