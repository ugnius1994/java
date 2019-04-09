<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019-03-21
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Roboto+Mono" rel="stylesheet">
    <title>localhost:8080/paleidimas/</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"></head>
<body>
<h1>index.jsp</h1>

<h4>STORE WEB</h4>
<h5><a href="web_product_list.html">web app: STORE spausdinti produktus >></a></h5>
<h5><a href="other-files/web_shopping_cart.html">web app: shoppingcart.html >></a></h5>
<%--<h5><a href="files/web_login.html">web app: STORE login >></a></h5>--%>
<h4>STORE</h4>
<h5><a href="api/json-cart-product?id=1">2018-04-07 Cart turi grąžinti json cart + preke]</a></h5>
<h5><a href="api/storeservletai/InvoicesServlet?id=1">2018-03-22 InvoicesServlet [ObjectMapper response grąžinimas kaip json]</a></h5>
<h5><a href="api/storeservletai/ProductServlet">2018-03-22 ProductServlet [ObjectMapper response grąžinimas kaip json]</a></h5>

<h4>BANDOMASIS TRIUŠIS</h4>
<h5><a href="ServletBt0Pagrindinis">2018-03-26 BandomasisTriušis.ServletBt0Pagrindinis</a></h5>

<h4>PIRMIEJI SERVLETAI</h4>
<h5><a href="pirmas">2018-03-22 Servlet1First.java, turi du adresus:["/pirmas", "/antras2/*"] iškviečiamas:[/pirmas]</a></h5>
<h5><a href="antras2/">2018-03-22 Servlet1First.java, turi du adresus:["/pirmas", "/antras2/*"] iškviečiamas:[antras2/]</a></h5>
<h5><a href="Servlet2Second">Servlet2Second.java</a></h5>
<h5><a href="ServletFundamental">ServletFundamental</a></h5>
<h5><a href="pahtServletCount">ServletCount.java count++</a></h5>

<br>
<h5><a href="index.jsp">[šis index.jsp puslapis] LT raidės: čęėįšųūž</a></h5>
<h4>Data ir laikas: <%= new java.util.Date() %></h4>
<br>

<%--$END$--%>
</body>
</html>
