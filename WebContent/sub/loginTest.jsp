<%@page import="com.naver.s1.member.MemberDTO"%>
<%@page import="com.naver.s1.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
String id = request.getParameter("id");
String pw = request.getParameter("pw");

MemberDAO memberDAO = new MemberDAO();
MemberDTO memberDTO = new MemberDTO();
memberDTO.setID(id);
memberDTO.setPW(pw);
memberDTO=memberDAO.logIn(memberDTO);

String result="로그인실패";

if(memberDTO !=null){
	result ="로그인성공";
	
}

%>

<h1><%=id %></h1>
<h1><%=pw %></h1>
<h1><%=result %></h1>

</body>
</html>