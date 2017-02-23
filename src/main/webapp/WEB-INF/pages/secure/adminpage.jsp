<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>

<html>
<head>
    <title><spring:message code="welcome.page.text.admin.dashboard"/></title>
    <action:actions/>
</head>
<body>


<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <h3><spring:message code="welcome.page.text.menu"/></h3>
            <!-- tabs -->
            <div class="tabbable tabs-left">
                <ul class="nav nav-tabs">
                    <li><a href="/welcomePage"><spring:message code="welcome.page.text.wall"/></a></li>
                    <li><a href="/friends"><spring:message code="welcome.page.text.friends"/></a></li>
                    <li><a href="/messages/"><spring:message code="welcome.page.text.mesagges"/></a></li>
                    <li><a href="/photos"><spring:message code="welcome.page.text.photoes"/></a></li>
                    <li><a href="/profile/beforeprofilepage"><spring:message code="welcome.page.text.profile"/></a></li>
                    <li><a href="#contact" data-toggle="tab"><spring:message code="welcome.page.text.contacts"/></a></li>
                    <li><a href="#about" data-toggle="tab"><spring:message code="welcome.page.text.about"/></a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li class="active"><a href="#admin" data-toggle="tab"><spring:message
                                code="welcome.page.text.admin.dashboard"/></a></li>
                    </c:if>

                </ul>
                <div class="tab-content">


                    <div class="tab-pane active" id="admin" style="margin-left: 250px">

                        <c:if test="${userdeleted.username != null}">
                            <div class="alert-danger">
                                <spring:message code="admin.page.text.accountfor"/>
                                <b>   ${userdeleted.profileDTO.firstname} ${userdeleted.profileDTO.lastname} </b>
                                <spring:message code="admin.page.text.userdeleted"/>
                            </div>
                            <br/>
                        </c:if>


                        <div class="alert-info">
                            <p>
                                <b> User agent:</b> ${pageContext.request.getHeader("user-agent")} <br/>
                                <b> Current host:</b> ${pageContext.request.getHeader("host")} <br/>
                                <b> Current language:</b> ${pageContext.request.getHeader("accept-language")} <br/>
                        </div>


                        <h5 align="center"> <spring:message code="admin.page.text.allprdb"/>:</h5>

                        <p></p>
                        <table class="table table-bordered">
                            <thead class="navbar-inverse" style="color: white">
                            <tr>
                                <th>#</th>
                                <th><spring:message code="profile.page.text.firstname"/></th>
                                <th><spring:message code="profile.page.text.lastname"/></th>
                                <th><spring:message code="profile.page.text.email"/></th>
                                <th><spring:message code="profile.page.text.age"/></th>
                                <th><spring:message code="profile.page.text.city"/></th>
                                <th><spring:message code="profile.page.text.phone"/></th>
                                <th><spring:message code="profile.page.text.gender"/></th>
                                <th><spring:message code="profile.page.text.credentials"/></th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${allTheProfiles}" var="profile">
                                <tr>
                                    <th scope="row">${profile.profileID}</th>
                                    <td>${profile.firstname}</td>
                                    <td>${profile.lastname}</td>
                                    <td>${profile.email}</td>
                                    <td>${profile.age}</td>
                                    <td>${profile.city}</td>
                                    <td>${profile.phoneNumber}</td>
                                    <td>${profile.sex}</td>
                                    <td><a href="/admin/manageuserinfo/${profile.profileID}"> <spring:message
                                            code="admin.page.text.manageuserinfo"/> </a></td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>

                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>
