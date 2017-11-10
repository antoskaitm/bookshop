<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 06.11.2017
  Time: 23:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/books">Books</a>
        </div>
        <div class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" action="/security/login" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="text" name="username" class="form-control" placeholder="login...">
                <input type="password"  name="password" class="form-control" placeholder="password...">

                <button type="submit" value="log in" class="btn btn-primary"> log in </button>
                <a href="/security/signup" class="btn btn-primary">sign up</a>
                <a href="/cart" class="btn btn-primary">${cart.totalQuantity} books in cart</a>
            </form>
        </div>
    </div>
</div>

