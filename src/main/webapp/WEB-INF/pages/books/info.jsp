<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 06.11.2017
  Time: 23:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>book full info</title>
    <%@ include file="../html_header.jsp" %>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@ include file="../genres.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">edit book</h1>
            <div class="table-responsive">
                <input type="hidden" name="id" value="${book.id}">
                    <table class="table table-striped">
                        <tbody>
                        <tr>
                            <td rowspan="6">
                                <img src="/books/images/${book.id}" width="200">
                            </td>
                        </tr>
                        <tr>
                            <th>title</th>
                            <th>${book.bookTitle}</th>
                        </tr>
                        <tr>
                            <th>author</th>
                            <th>${book.bookAuthor}</th>
                        </tr>
                        <tr>
                            <th>description</th>
                            <th></th>
                        </tr>
                        <tr>
                            <th>price</th>
                            <th>${book.price}</th>
                        </tr>
                        <tr>
                            <th colspan="2">
                                <a class="btn btn-primary"
                                   href="<c:url value='/cart/add/${book.id}'/>">add</a><br>
                            </th>
                        </tr>
                        </tbody>
                    </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
