<%-- 
    Document   : HomePage
    Created on : Sep 17, 2020, 8:59:06 PM
    Author     : Mai Minh Hieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- load du lieu tu database -->
        <jsp:useBean id="t" class="dao.DigitalDao" scope="request"/> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="preheader"></div>
            <div class="header">
                <h3>My digital news</h3>
            </div>
            <div class="menu">
                <a href="#">New</a>
            </div>
            <div class="main">
                <div class="left">
                    <div class="title">
                        ${t.top1.title}
                    </div>
                    <div class="image">
                        <img src="images/${t.top1.image}" alt=""/>
                    </div>
                    <div class="description">
                        ${t.top1.description}
                    </div>
                    <div class="information">
                        By ${t.top1.author}|${t.top1.timePost}
                    </div>

                </div>
                <div class="right">
                    <div class="newR">Digital News</div>
                    <div class="shortDes">
                        ${t.top1.shortDes}
                    </div>
                    <div class="newR">Search</div>
                    <div class="search">
                        <input class="inputTxt" type="text" name="txtSearch">
                        <input class="submit" type="submit" value="Go">
                    </div>
                    <div class="newR">Last Article</div>
                    <div class="list">
                        <c:forEach items="${t.top5}" var="x">
                            <a href="">${x.title}</a>
                        </c:forEach>
                    </div>

                </div>
            </div>
            <div class="footer"></div>

        </div>

    </body>
</html>
