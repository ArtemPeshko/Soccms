<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<html>
<head>
    <action:actions/>
    <title><spring:message code="error.page.text"/> 403</title>
</head>

<body>
<section>
    <div class="mainwrapper">
        <div class="mainpanel" align="center">
            <font size="40"> <spring:message code="error.page.text.403"/> </font> <br/> <br/> <br/>
            <c:choose>
                <c:when test="${empty username}">
                    <spring:message code="accessdenied.label.notpermission"/>
                </c:when>
                <c:otherwise>
                    <spring:message code="accessdenied.label.username"/> ${username} <br/>
                    <spring:message code="accessdenied.label.notpermission"/>
                </c:otherwise>
            </c:choose>
            <br/> <br/> <br/>
            <button type="button" name="back" onclick="history.back()" class="btn btn-default">BACK</button>
        </div>
    </div>
</section>
</body>
</html>