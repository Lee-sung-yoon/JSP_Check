<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-16
  Time: 오전 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.jsp_check.Rq"%>

<% // %를 쓰면 자바 사용 가능!
    Rq rq = new Rq(request, response);
    int dan = rq.getIntParam("dan", 9);
    int limit = rq.getIntParam("limit", 9);
%>

<h1><%=dan%>단</h1>
<% for (int i = 1; i <= limit; i++) { %>
    <div><%=dan%> * <%=i%> = <%=dan * i%></div>
<% } %>

