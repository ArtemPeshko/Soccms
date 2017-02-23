<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="profile.page.text.page"/></title>
    <action:actions/>
</head>
<body>

<section>
    <div class="mainwrapper">
        <jsp:include page="/WEB-INF/pages/additional/sidebar.jsp"/>
        <div class="mainpanel">
            <div class="contentpanel">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="tab-content">
                            <h2><spring:message code="welcome.page.text.profile"/></h2>

                            <p>
                                <b> <spring:message
                                        code="profile.page.text.firstname"/>: </b> ${profileDTO.firstname} <br/>
                                <b> <spring:message code="profile.page.text.lastname"/>:</b> ${profileDTO.lastname}
                                <br/>
                                <b> <spring:message code="profile.page.text.email"/>:</b> ${profileDTO.email} <br/>
                                <b> <spring:message code="profile.page.text.gender"/>:</b> ${profileDTO.sex} <br/>
                                <b> <spring:message
                                        code="profile.page.text.dateofbirth"/>:</b> ${profileDTO.birthDate} <br/>
                                <b> <spring:message code="profile.page.text.age"/>: </b> ${profileDTO.age} <br/>
                                <b> <spring:message code="profile.page.text.city"/>: </b> ${profileDTO.city} <br/>
                                <b> <spring:message code="profile.page.text.phone"/>:</b> ${profileDTO.phoneNumber}
                                <br/>

                            <p><a href="/profile/profileedit"><spring:message code="profile.page.text.edit"/></a>
                            <p><a href="/profile/passwordchange"><spring:message
                                    code="admin.page.text.changepassword"/></a>

                                <c:if test="${passwordchanged != null}">
                            <div class="alert alert-success" role="alert">
                                <div class="msg" align="center">
                                    <b> <spring:message code="profile.page.text.password.changed"/> </b>
                                </div>
                            </div>
                            </c:if>

                        </div>

                    </div>

                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
