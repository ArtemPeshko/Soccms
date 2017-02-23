<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <action:actions/>
    <title><spring:message code="error.page.text"/> 500</title>
</head>
<body>
<section>
    <div class="mainwrapper">
        <div class="mainpanel" align="center">
            <font size="40"> <spring:message code="error.page.text.500"/> </font><br/> <br/> <br/>
            <button type="button" name="back" onclick="history.back()" class="btn btn-default">BACK</button>
        </div>
    </div>
</section>
</body>
</html>
