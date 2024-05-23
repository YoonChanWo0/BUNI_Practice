<%--
  Created by IntelliJ IDEA.
  User: PKNU
  Date: 2024-05-23
  Time: 오후 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int i=0;
        int result = 0;
        for (i=0; i<=100; i++){
            result += i;
        }
        System.out.println("결과 값은 : " + result);
    %>
    <h2>1부터 100까지 더한 값 :</h2>
    <%=result%>
</body>
</html>
