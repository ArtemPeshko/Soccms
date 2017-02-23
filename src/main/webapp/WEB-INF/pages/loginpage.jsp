<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="login.page.text.welcome"/></title>
    <action:loginpage/>
</head>
<body>


<div class="alert" align="center">

    <c:if test="${not empty error}">
        <spring:message code="login.page.text.invalid.credentials" var="invalidCredentials"/>
        <div class="alert alert-danger" role="alert">
            <div class="error">${invalidCredentials}</div>
        </div>

    </c:if>
    <c:if test="${not empty msg}">
        <spring:message code="page.text.logout.message" var="logoutMessage"/>

        <div class="alert alert-success" role="alert">
            <div class="msg">${logoutMessage}</div>
        </div>
    </c:if>

    <c:if test="${brandnewuser.username != null}">
        <div class="alert alert-info" role="alert">
            <div class="msg"><spring:message code="admin.page.text.accountfor"/>
                <b> ${brandnewuser.username} </b>
                <spring:message code="registration.page.filed.success"/></div>
        </div>
        <br/>
    </c:if>

</div>

<div class="container" style="width: 500px">
    <div class="row main table-bordered">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title"><spring:message code="login.page.text.welcome"/></h1>
                <hr/>
            </div>
        </div>
        <div class="main-login main-center">

            <form class="form-horizontal" method="POST" action="<c:url value='/j_spring_security_check'/>"
                  name="loginForm" onsubmit="return validateLoginForm()">

                <spring:message code="login.page.filed.username" var="username"/>
                <div class="form-group">
                    <label for="username" class="cols-sm-2 control-label">${username}</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="username" id="username"
                                   placeholder="${username}"/>
                        </div>
                    </div>
                </div>

                <spring:message code="login.page.filed.password" var="password"/>
                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">${password}</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="password" id="password"
                                   placeholder="${password}"/>
                        </div>
                    </div>

                </div>

                <div class="form-group ">
                    <!-- if this is login for update, ignore remember me check -->
                    <c:if test="${empty loginUpdate}">
                        <spring:message code="login.page.text.rememberme" var="rememberme"/>
                        ${rememberme}: <label> <input type="checkbox" name="remember-me"/> </label>
                    </c:if>
                </div>

                <spring:message code="login.page.loginbutton" var="enter"/>
                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-lg btn-block login-button">${enter}</button>
                </div>

                <div class="login-register" align="center"><a href="/registration"><spring:message
                        code="registration.page.text.registration"/></a>
                </div>

            </form>
        </div>
    </div>
</div>


</body>
</html>
