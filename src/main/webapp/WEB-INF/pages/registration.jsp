<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="registration.page.text.title"/></title>
    <action:registration/>
</head>
<body>

<div class="alert" align="center">


    <c:choose>
        <c:when test="${pageNotification eq 'email'}">
            <div class="alert alert-danger" role="alert">
                <spring:message code="registration.page.text.validation.email.exists"/>
            </div>
        </c:when>
        <c:when test="${pageNotification eq 'username'}">
            <div class="alert alert-danger" role="alert">
                <spring:message code="registration.page.text.validation.login.exists"/>
            </div>
        </c:when>
        <c:otherwise> </c:otherwise>
    </c:choose>

</div>

<div class="container" style="width: 500px">
    <div class="row main table-bordered">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title"><spring:message code="registration.page.text.title"/></h1>
                <hr/>
            </div>
        </div>
        <div class="main-login main-center">
            <form:form class="form-horizontal" name="registrationForm" method="post" action="/registrationComplete"
                       onsubmit="return validateRegistrationForm()" commandName="userDTO">

                <spring:message code="registration.page.text.email" var="email"/>
                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label">${email}</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <form:input type="text" class="form-control" path="email" name="email" id="email"
                                        placeholder="${email}"/>
                        </div>
                        <font color="#a52a2a"> <form:errors path="email"/> </font>
                    </div>
                </div>

                <spring:message code="login.page.filed.username" var="username"/>
                <div class="form-group">
                    <label for="username" class="cols-sm-2 control-label">${username}</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                            <form:input path="username" type="text" class="form-control" name="username" id="username"
                                        placeholder="${username}"/>
                        </div>
                        <font color="#a52a2a"> <form:errors path="username"/> </font>
                    </div>
                </div>

                <spring:message code="login.page.filed.password" var="password"/>
                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">${password}</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <form:input path="password" type="password" class="form-control" name="password" id="password"
                                        placeholder="${password}"/>
                        </div>
                    </div>
                    <font color="#a52a2a"> <form:errors path="password"/> </font>
                </div>

                <spring:message code="registration.page.filed.confirmpassword" var="confirmPassword"/>
                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">${confirmPassword}</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <form:input path="confirmPassword" type="password" class="form-control" name="cpassword" id="password"
                                        placeholder="${confirmPassword}"/>
                        </div>
                    </div>
                    <font color="#a52a2a"> <form:errors path="confirmPassword"/> </font>
                </div>

                <spring:message code="registration.page.button.complete" var="complete"/>
                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-lg btn-block login-button">${complete}</button>
                </div>
                <div class="login-register" align="center"><a href="loginpage"><spring:message code="login.page.loginbutton"/></a>
                </div>

            </form:form>

        </div>
    </div>
</div>


</body>
</html>
