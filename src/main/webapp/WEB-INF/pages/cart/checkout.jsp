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
    <title>checkout</title>
    <%@ include file="../html_header.jsp" %>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@ include file="../genres.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">to checkout fill next filds</h1>
            <div class="table-responsive">
                <form action="/checkout" method="post">
                    <table class="table table-striped">
                        <tbody>
                        <tr>
                            <th>full name</th>
                            <th><input type="text" name="name"></th>
                        </tr>
                        <tr>
                            <th>city</th>
                            <th><input type="text" name="city"></th>
                        </tr>
                        <tr>
                            <th>address</th>
                            <th><input type="text" name="address"></th>
                        </tr>
                        <tr>
                            <th>gift warp</th>
                            <th><input type="checkbox" name="giftWrap" value="true"></th>
                        </tr>
                        <tr>
                            <th colspan="2">
                                <button class="btn btn-primary" type="submit">send</button>
                            </th>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
