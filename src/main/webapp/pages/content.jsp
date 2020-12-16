<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="/resources/css/basic.css" rel="stylesheet">

    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/1.9.0/jquery.min.js"  />"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/js/bootstrap.js"  />"></script>

    <title>CRUD - ${title}</title>
</head>
</tab>
<c:import url="page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-10 col-lg-offset-1">
            <div class="panel">
                <div class="panel-heading">
                    <div class="text-center">
                        <h1>${title}<small> crud operations</small></h1>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <div class="text-center"><h3 class="color-black">Suppliers</h3></div>
                        </div>
                        <table class="table table-striped table-condensed" id="car-brands">
                            <thead>
                            <th><button class="sort" data-sort="brand-name">supplier</button></th>
                            <th><button class="sort" data-sort="founded-year">address</button></th>
                            <th><button class="sort" data-sort="headquarter">phone number</button></th>
                            <th>action</th>
                            </thead>
                            <tbody align="center" class="list">
                            <c:forEach var="supplier" items="${listMarketSupplier}" varStatus="status">
                                <tr>
                                    <td class="brand-name">${supplier.name}</td>
                                    <td class="brand-name">${supplier.address}</td>
                                    <td class="founded-year">${supplier.phoneNumber}</td>
                                    <td class="action d-flex">
                                        <a href="/${instrument}/edit-supplier/${supplier.idSupplier}">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="/${instrument}/delete-supplier/${supplier.idSupplier}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="panel-footer"><a class="btn btn-info" role="button" href="/${instrument}/newSupplier">Add new supplier</a></div>
                    </div>
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <div class="text-center"><h3 class="color-black">Products</h3></div>
                        </div>
                        <table class="table table-striped table-condensed" id="car-models">
                            <thead>
                            <th><button class="sort" data-sort="brand-name">supplier</button></th>
                            <th><button class="sort" data-sort="model-name">name</button></th>
                            <th><button class="sort" data-sort="generation">description</button></th>
                            <th><button class="sort" data-sort="production-year">produced</button></th>
                            <th>action</th>
                            </thead>
                            <tbody align="center" class="list">
                            <c:forEach var="product" items="${listMarketProduct}" varStatus="status">
                                <tr>
                                    <td class="brand-name">${product.marketSupplier.name}</td>
                                    <td class="model-name">${product.productName}</td>
                                    <td class="generation">${product.description}</td>
                                    <td class="production-year">${product.productionYear}</td>
                                    <td>
                                        <a href="/${instrument}/edit-model/${product.idProduct}">Edit</a>

                                        <a href="/${instrument}/delete-model/${product.idProduct}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="panel-footer"><a class="btn btn-info" role="button" href="/${instrument}/newProduct">Add new product</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/resources/js/list.min.js"></script>
<script src="/resources/js/content-list.js"></script>
</body>
</html>