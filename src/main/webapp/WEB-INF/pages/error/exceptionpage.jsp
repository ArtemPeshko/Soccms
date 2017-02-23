z<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<html>
<head>
    <title><spring:message code="error.page.text.exception"/></title>
    <action:actions/>
</head>
<body>
<section>
    <div class="mainwrapper">
        <div class="mainpanel" align="center">
    <font size="3"> ${ex} </font> <br/> <br/> <br/>
    <button type="button" name="back" onclick="history.back()" class="btn btn-default">BACK</button>
</div>

</body>
</html>
