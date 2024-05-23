<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%!
    String str1 = "JSP";
    String str2 = "안녕하세요";
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>처음 만들어보는 <%= str1 %></h2>
    <p>
        <%
            out.println (str2 + str1 + "입니다. 열공하농");
        %>
    </p>
</body>
</html>
<%--주석
<%@ %> : 지시를 위한 코드 블록
<%  %> : 스크립트릿(자바코드)
<%! %> : 선언부(변수선언, 함수선언)
<%= %> : 표현식(출력)
--%>