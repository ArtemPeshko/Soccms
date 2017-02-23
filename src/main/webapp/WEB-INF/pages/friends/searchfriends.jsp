<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <div class="row">
            <div class="col-xs-12">
                <div class="tab-content"
                <form:form action="/friends/searchfriends/" method="post" modelAttribute="messageDTO">

                    <p><a href="/friends">
                        <button type="button" class="btn btn-default btn-lg btn-block">
                            <spring:message code="friend.page.text.friend.managefriends"/></button>
                    </a></p>
                    <br/>
                    <div class="input-group col-sm-12">
                        <div class="input-group">
                            <spring:message code="friend.page.text.friend.searchtext" var="searchtext"/>
                            <form:input type="text" path="text" placeholder="${searchtext}"
                                        class="form-control"/>

                            <span class="input-group-btn">
                                                <input class="btn btn-secondary" type="submit" id="myText"
                                                       value=" <spring:message code="friend.page.text.friend.search"/>"/>

                                 </span>
                        </div>
                        <br/>
                    </div>


                </form:form> <br/>

                <c:if test="${nofriends ne null }">
                    <div class="warning">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>

                        <font color="#5f9ea0"> <spring:message code="friend.page.text.friend.noffoundfriend"/> </font>
                    </div>
                </c:if>
                <br/>


                <c:if test="${allTheProfiles.size() gt 0 }">

                    <table class="table">
                        <tr>
                            <th>#</th>
                            <th><spring:message code="profile.page.text.fullname"/></th>
                            <th><spring:message code="profile.page.text.age"/></th>
                            <th><spring:message code="profile.page.text.city"/></th>
                            <th><spring:message code="profile.page.text.gender"/></th>
                        </tr>
                        <c:forEach items="${allTheProfiles}" var="profile">

                            <tr>
                                <th scope="row"><a
                                        href="/friends/addfriend/${pageContext.request.userPrincipal.name}&${profile.profileID}">
                                    <spring:message code="friend.page.text.friend.addfriend"/> </a>
                                </th>

                                <td>${profile.firstname} ${profile.lastname}</td>
                                <td>${profile.age}</td>
                                <td>${profile.city}</td>
                                <td>${profile.sex}</td>
                            </tr>

                        </c:forEach>
                    </table>

                </c:if>

                <br/>

            </div>

            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                <div class="tab-pane" id="admin">
                </div>
            </c:if>

        </div>
    </div>
</div>
</section>
</body>
</html>
