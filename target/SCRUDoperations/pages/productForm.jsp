<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link href="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="/resources/css/basic.css" rel="stylesheet">

    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/1.9.0/jquery.min.js"  />"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/js/bootstrap.js"  />"></script>

    <title>${title}</title>
</head>
<body>
<c:import url="page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <div class="panel">
                <div class="panel-heading">
                    <div class="text-center">
                        <h1>${action} product <small>using ${title}</small></h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form:form method="POST" modelAttribute="marketProduct" class="form-horizontal">
                        <form:hidden path="idProduct"/>
                        <div class="form-group">
                            <label for="idSupplier" class="col-sm-3 control-label" >Brand:</label>
                            <div class="col-sm-9">
                                <form:select path="idSupplier" multiple="false" class="form-control">
                                    <c:forEach var="supplier" items="${listMarketSupplier}" varStatus="status">
                                        <c:choose>
                                            <c:when test="${supplier.idSupplier == marketProduct.idProduct}">
                                                <option selected value="${supplier.idSupplier}">${supplier.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${supplier.idSupplier}">${supplier.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="productName" class="col-sm-3 control-label">Product:</label>
                            <div class="col-sm-9">
                                <form:input path="productName" class="form-control" required="required"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-sm-3 control-label">Description:</label>
                            <div class="col-sm-9">
                                <form:input path="description" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="productionYear" class="col-sm-3 control-label">Production year:</label>
                            <div class="col-sm-9">
                                <form:input path="productionYear" class="form-control" type="number" min="1800" max="2050"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>