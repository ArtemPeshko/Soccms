<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="welcome.page.text.wall"/></title>
    <action:actions/>
</head>
<body>
<section>
    <div class="mainwrapper">
        <jsp:include page="/WEB-INF/pages/additional/sidebar.jsp"/>
        <div class="mainpanel">
            <div class="contentpanel">
                <div class="row">
                    <div class="col-sm-12 col-md-12">
                        <form:form action="/posts/sendapost" method="post" commandName="postDTO"
                                   enctype="multipart/form-data" onsubmit="return Validate(this);">

                            <spring:message code="messages.page.text.entertext" var="entertext"/>
                            <form:textarea class="form-control" id="texta" path="text" rows="3" name="text"
                                           placeholder="${entertext}"/>

                            <br/><action:fileupload/>

                        </form:form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
