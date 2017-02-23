<%@ taglib prefix="action" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="welcome.page.text.friends"/></title>
    <action:actions/>
</head>
<body>
<section>
    <div class="mainwrapper">
        <jsp:include page="/WEB-INF/pages/additional/sidebar.jsp"/>
        <div class="mainpanel">
            <div class="contentpanel">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="tab-content">

                                <p>
                                    <a href="/friends">
                                        <button type="button" class="btn btn-default btn-lg btn-block">
                                            <spring:message code="friend.page.text.friend.managefriends"/></button>
                                    </a>
                                </p>
                                <br/> <br/>
                                <c:choose>
                                    <c:when test="${allThePendingRequests.size()==0}">
                                        <div class="warning">
                                            <span class="glyphicon glyphicon-exclamation-sign"
                                                  aria-hidden="true"></span>
                                            <spring:message code="friend.page.text.friend.nopendingrequests"/>
                                        </div>


                                    </c:when>
                                    <c:otherwise>
                                        <table id="friendsTable" class="table">
                                            <tr>
                                                <th><spring:message code="friend.page.text.friend.good"/></th>
                                                <th><spring:message code="friend.page.text.friend.bad"/></th>
                                                <th><spring:message code="profile.page.text.fullname"/></th>
                                                <th><spring:message code="profile.page.text.age"/></th>
                                                <th><spring:message code="profile.page.text.city"/></th>
                                                <th><spring:message code="profile.page.text.gender"/></th>
                                            </tr>
                                            <c:forEach items="${allThePendingRequests}" var="friend">
                                                <tr>
                                                    <th scope="row"><a
                                                            href="/friends/approve/${pageContext.request.userPrincipal.name}&${friend.profileDTO.profileID}">
                                                        <spring:message
                                                                code="friend.page.text.friend.approverequest"/> </a>
                                                    </th>
                                                    <th scope="row"><a
                                                            href="/friends/reject/${pageContext.request.userPrincipal.name}&${friend.profileDTO.profileID}">
                                                        <spring:message
                                                                code="friend.page.text.friend.rejectrequest"/> </a>
                                                    </th>
                                                    <td>${friend.profileDTO.firstname} ${friend.profileDTO.lastname}</td>
                                                    <td>${friend.profileDTO.age}</td>
                                                    <td>${friend.profileDTO.city}</td>
                                                    <td>${friend.profileDTO.sex}</td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </c:otherwise>
                                </c:choose>
                                <br/>


                            </div>

                            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                                <div class="tab-pane" id="admin">
                                </div>
                            </c:if>

                        </div>
                    </div>
                </div>
            </div>
        </div>
</section>
</body>
</html>
