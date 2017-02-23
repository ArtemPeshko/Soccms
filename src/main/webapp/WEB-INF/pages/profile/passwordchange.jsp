<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="profile.page.text.edition"/></title>
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
                        <div class="tabbable tabs-left">
                            <div class="tab-content">
                                <div class="tab-pane active" id="profile" style="margin-left: 250px; width: 300px">

                                    <c:if test="${passwordsDoNotMatch != null}">
                                        <div align="center" style="color: rgba(131, 34, 40, 0.73)">
                                            <b> <spring:message
                                                    code="registration.page.text.validation.password.confirmation"/> </b>
                                        </div>
                                    </c:if>

                                    <br/>
                                    <div>
                                        <form:form method="post" action="/profile/passwordchange" commandName="userDTO">

                                            <div class="form-group">

                                                <spring:message code="admin.page.text.newpassword" var="newPassword"/>

                                                <div class="form-group">
                                                    <div class="cols-sm-10">
                                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock fa-lg"
                                                                               aria-hidden="true"></i></span>
                                                            <form:input path="newPassword" type="password"
                                                                        class="form-control"
                                                                        name="password" id="password"
                                                                        placeholder="${newPassword}"/>
                                                        </div>
                                                    </div>
                                                    <font color="#a52a2a"> <form:errors path="confirmPassword"/> </font>
                                                </div>

                                                <spring:message code="registration.page.filed.confirmpassword"
                                                                var="confirmPassword"/>
                                                <div class="form-group">
                                                    <div class="cols-sm-10">
                                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock fa-lg"
                                                                               aria-hidden="true"></i></span>
                                                            <form:input path="confirmPassword" type="password"
                                                                        class="form-control"
                                                                        name="password" id="password"
                                                                        placeholder="${confirmPassword}"/>
                                                        </div>
                                                    </div>
                                                    <font color="#a52a2a"> <form:errors path="confirmPassword"/> </font>
                                                </div>


                                                <div class="form-group ">
                                                    <button type="submit"
                                                            style="background-color: rgba(131, 34, 40, 0.73); color: white"
                                                            class="btn btn-default btn-lg btn-block login-button">
                                                        <spring:message
                                                                code="admin.page.text.changepassword"/></button>
                                                </div>
                                            </div>

                                        </form:form>


                                        <a href="/profile/beforeprofilepage">
                                            <button class="btn btn-default btn-lg btn-block login-button">
                                                <spring:message
                                                        code="welcome.page.text.profilback"/></button>
                                        </a>


                                    </div>
                                </div>

                                <div id="admin"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
