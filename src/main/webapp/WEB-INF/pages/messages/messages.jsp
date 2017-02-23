<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="contactabout" tagdir="/WEB-INF/tags/" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="welcome.page.text.mesagges"/></title>
    <action:actions/>
</head>
<body>
<section>
    <div class="mainwrapper">
        <jsp:include page="/WEB-INF/pages/additional/sidebar.jsp"/>
        <div class="mainpanel">
            <div class="contentpanel">
                <div class="tab-pane" id="followers">
                    <div class="follower-list">
                        <div class="media">
                            <div class="media-body">
                                <c:forEach items="${allThePeople}" var="profile">
                                    <c:if test="${(pageContext.request.userPrincipal.name != profile.userDTO.username) &&
                                (profile.userDTO.username != 'admin')}">
                                        <h3 class="follower-name">${profile.firstname} ${profile.lastname}</h3>
                                        <div><i class="fa fa-map-marker"></i> ${profile.city}</div>
                                        <div class="mb20"></div>
                                        <div class="btn-toolbar">
                                            <div class="btn-group">
                                                <a href="/messages/beforesendmessage/${pageContext.request.userPrincipal.name}&${profile.profileID}">
                                                    <button class="btn btn-dark btn-xs"><i class="fa fa-envelope-o"></i>
                                                        <spring:message
                                                                code="messages.page.text.send.message"/></button>
                                                </a>
                                            </div><!-- btn-group -->
                                        </div>
                                        <br/>
                                    </c:if>
                                </c:forEach>
                            </div><!-- media-body -->
                        </div><!-- media -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
