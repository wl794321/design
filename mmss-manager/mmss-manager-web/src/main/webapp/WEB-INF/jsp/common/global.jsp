<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- Bootstrap -->
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/css/toastr.min.css" rel="stylesheet">
    <link href="${ctx}/css/style.css" rel="stylesheet">
    <script src="${ctx}/js/jquery-2.2.0.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/validator.js"></script>
    <script src="${ctx}/js/toastr.min.js"></script>
<script type="text/javascript">
	var ctx = '<%=request.getContextPath() %>';
</script>
