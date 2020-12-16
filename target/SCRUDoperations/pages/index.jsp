<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <link href="<c:url value="/webjars/bootstrap/3.1.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/basic.css"/>" rel="stylesheet">
    <script src="<c:url value="/webjars/jquery/1.9.0/jquery.min.js"  />"></script>
    <script src="<c:url value="/webjars/bootstrap/3.1.0/js/bootstrap.js"  />"></script>
    <title>CRUD operations</title>.
</head>
<body>
<c:import url="page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2" style="color: #fff2ba !important;">
            <div class="jumbotron" id="index_jumbotron" style="background-color: #ffffff00">
                <div class="text-center"><h1>MARKET PLACE</h1></div>
                <p class="lead text-center text-nowrap" style="    font-size: 32px;
    letter-spacing: 0.2px;">The most popular selling platform</p>
            </div>
            <div class="cols">
                <div class="row">
                    <div class="" style="margin: 0 auto; max-width: 340px; width: 100%;display: flex; flex-direction: column; align-items: center; text-align: center;">
                        <p style="font-size: 24px;">It is the place where you can buy or sell any product.</p>
                        <p style="margin-top: 20px;"><a class="btn btn--view-more" style="background-color: #252d52; color: #fffbec; font-size: 24px" href="/hibernate" role="button">View more</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>