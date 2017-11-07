<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 06.11.2017
  Time: 23:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>books</title>
    <%@ include file="../html_header.jsp" %>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@ include file="../genres.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">books list</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>title</th>
                        <th>authors</th>
                        <th>description</th>
                        <th>price</th>
                        <th></th>
                    </tr>
                    </thead>
                    <c:if test="${!empty books}">
                        <tbody>
                        <c:forEach items="${books}" var="book">
                            <tr>
                                <td>
                                    <a href="/books/data/${book.id}" class="title">
                                            ${book.bookTitle}<br>
                                        <img src="/books/images/${book.id}" width="100"/>
                                    </a>
                                </td>
                                <td>${book.bookAuthor}</td>
                                <td></td>
                                <td>${book.price}</td>
                                <td>
                                    <a class="btn btn-primary"
                                       href="/books/remove/${book.id}">remove</a><br>
                                    <a class="btn btn-primary"
                                       href="/books/edit/${book.id}">edit</a><br>
                                    <a class="btn btn-primary"
                                       href="/cart/add/${book.id}">add</a><br>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </c:if>
                </table>
                <a class="btn btn-primary"
                   href="/books/create">create new</a><br>
                <div>
                    <c:forEach begin="1" end="${pagesCount}" step="1" var="number">
                        <a class="btn btn-primary" href="/books/${number-1}">${number}</a>
                    </c:forEach>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
