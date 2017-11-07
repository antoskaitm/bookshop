<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 06.11.2017
  Time: 23:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>cart</title>
    <%@ include file="../html_header.jsp" %>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@ include file="../genres.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">your cart</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>title</th>
                        <th>quantity</th>
                        <th>book price</th>
                        <th>total price</th>
                        <th></th>
                    </tr>
                    </thead>
                    <c:if test="${null != cart.cartLines}">
                        <tbody>
                        <c:forEach items="${cart.cartLines}" var="line">
                            <tr>
                                <td>
                                    <a href="/books/data/${line.book.id}" class="title">
                                            ${line.book.bookTitle}
                                    </a>
                                </td>
                                <td>${line.quantity} </td>
                                <td>${line.book.price}</td>
                                <td>${line.price}</td>
                                <td>
                                    <a class="btn btn-primary" href="/cart/remove/${line.book.id}">remove</a><br>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="3">total</td>
                            <td>${cart.totalPrice}</td>
                        </tr>
                        <tr>
                            <td colspan="4"><a href="/checkout" class="btn btn-primary">checkout</a></td>
                        </tr>
                        </tfoot>
                    </c:if>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>