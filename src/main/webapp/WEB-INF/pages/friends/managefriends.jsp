<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="welcome.page.text.friends"/></title>
    <action:actions/>
</head>
<body>
<div class="mainwrapper">
    <jsp:include page="/WEB-INF/pages/additional/sidebar.jsp"/>
    <div class="mainpanel">
        <div class="row">
            <div class="col-xs-12">
                <div class="tabbable tabs-left">
                    <div class="tab-content">

                        <div class="tab-pane" id="wall"></div>

                        <div class="tab-pane active" id="friends" style="margin-left: 250px">


                            <a class="button" href="/friends/searchfriends/">

                                <button type="button" class="btn btn-default">
                                    <spring:message code="friend.page.text.searchfriend"/>
                                </button>
                            </a>

                            <a class="button" href="/friends/allthepeople/${pageContext.request.userPrincipal.name}">

                                <button type="button" class="btn btn-default">
                                    <spring:message code="friend.page.text.showallprofiles"/>
                                </button>
                            </a>

                            <a class="button" href="/friends/allthefriends/${pageContext.request.userPrincipal.name}">
                                <button type="button" class="btn btn-default">
                                    <spring:message code="friend.page.text.showallfriends"/>
                                </button>
                            </a>

                            <a class="button" href="/friends/pendingrequests/${pageContext.request.userPrincipal.name}">
                                <button type="button" class="btn btn-default">
                                    <spring:message code="friend.page.text.friend.requests"/>
                                </button>
                            </a>
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
</div>
</body>
</html>
