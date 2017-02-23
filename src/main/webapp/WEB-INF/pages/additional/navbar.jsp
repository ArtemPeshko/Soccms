<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
<nav class="navbar navbar-default top">

    <div style="margin: 10px">

        <a href="?lang=en"> eng  </a>
        <a href="?lang=ru"> рус  </a>

        <%--<spring:message code="navbar.page.text.language.en"/>--%>
        <spring:message code="login.page.filed.username" var="username"/>
        <spring:message code="page.text.logout.button" var="logoutButton"/>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <object align="right">${username}: <b> ${pageContext.request.userPrincipal.name} </b>
                | <a href="<c:url value="/j_spring_security_logout" />"> ${logoutButton}</a></object>
        </c:if>

    </div>

</nav>-->
<header>
    <div class="headerwrapper">
        <div class="header-left">
            <a href="/welcomePage" class="logo">
               <span style="color: #FFFFFF;">SocialCMS</span>
            </a>
            <div class="pull-right">
                <a href="" class="menu-collapse">
                    <i class="fa fa-bars"></i>
                </a>
            </div>
        </div><!-- header-left -->
        <div class="header-left">
            <div class="pull-left">
                <div class="btn-group btn-group-option">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-caret-down"> <spring:message code="select.site.language"/></i>
                    </button>
                    <ul class="dropdown-menu pull-right" role="menu">
                        <li><a href="?lang=en">English</a></li>
                        <li><a href="?lang=ru">Русский</a></li>
                    </ul>
                </div><!-- btn-group -->
            </div><!-- pull-right -->
        </div>
        <div class="header-right">
            <div class="pull-right">
                <div class="btn-group btn-group-option">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <ul class="dropdown-menu pull-right" role="menu">
                        <li><a href="/profile/beforeprofilepage"><i class="glyphicon glyphicon-user"></i> <spring:message code="welcome.page.text.profile"/></a></li>
                        <li><a href="/profile/passwordchange"><i class="glyphicon glyphicon-star"></i> <spring:message
                                code="admin.page.text.changepassword"/></a></li>
                        <li><a href="/profile/profileedit"><i class="glyphicon glyphicon-cog"></i> <spring:message code="profile.page.text.edit"/></a></li>
                        <li class="divider"></li>
                        <li><a href="<c:url value="/j_spring_security_logout" />"><i class="glyphicon glyphicon-log-out"></i> ${logoutButton}</a></li>
                    </ul>
                </div><!-- btn-group -->
            </div><!-- pull-right -->
        </div><!-- header-right -->

    </div><!-- headerwrapper -->
</header>