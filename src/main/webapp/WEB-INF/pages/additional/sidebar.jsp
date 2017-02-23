<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <div class="leftpanel">
            <h5 class="leftpanel-title"><spring:message code="welcome.page.text.menu"/></h5>
            <ul class="nav nav-pills nav-stacked">
                <li><a href="/welcomePage"><i class="fa fa-home"></i> <span><spring:message code="welcome.page.text.wall"/></span></a></li>
                <li><a href="/friends/allthepeople/${pageContext.request.userPrincipal.name}"><i class="glyphicon glyphicon-user"></i> <span><spring:message code="welcome.page.text.allpeople"/></span></a></li>
                <li><a href="/messages/"><i class="fa fa-envelope-o"></i> <span><spring:message code="welcome.page.text.mesagges"/></span></a></li>
                <li><a href="/photos"><i class="fa fa-edit"></i> <span><spring:message code="welcome.page.text.photoes"/></span></a></li>
                <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                     <li><a href="/admin/"><spring:message code="welcome.page.text.admin.dashboard"/></a></li>
                </c:if>
            </ul>
        </div>
