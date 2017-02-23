<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="welcome.page.text.mesagges"/></title>
    <action:actions/>
</head>

<body style="height: 200%; + position:absolute;">

<section>
    <div class="mainwrapper">
        <jsp:include page="/WEB-INF/pages/additional/sidebar.jsp"/>
        <div class="mainpanel">
            <div class="contentpanel">
                <div class="row">
                    <div class="col-sm-12 col-md-12">
                        <h3><spring:message
                                code="messages.page.text.conversationwith"/> ${destinationProfileDTO.firstname} ${destinationProfileDTO.lastname}  </h3>
                        <form:form method="POST" action="/messages/sendmessage" modelAttribute="MessageDTO">

                            <spring:message code="messages.page.text.entertext" var="entertext"/>
                            <p><form:textarea path="text" id="texta" rows="4" cols="150" maxlength="1023"
                                              placeholder="${entertext}"/></p>


                            <a href="/messages/">
                                <button type="button" class="btn btn-default">
                                    <spring:message code="messages.page.text.send.manage.messages"/></button>
                            </a>
                            <div style="float: right;">
                                <spring:message code="messages.page.text.send.sendmessage" var="send"/>
                                <input type="submit" class="btn btn-primary login-button" value="${send}">
                            </div>

                        </form:form>
                        <div class="tab-content nopadding noborder">
                            <div class="tab-pane active" id="activities">
                                <div class="activity-list">
                                    <div class="media">
                                        <div class="media-body">
                                            <c:forEach items="${allTheMessages}" var="message">

                                                <c:choose>
                                                    <c:when test="${pageContext.request.userPrincipal.name eq message.senderProfileDTO.firstname}">
                                                        <br/>
                                                        <div class="alert-info">
                                                            <font size="1">
                                                                <b><spring:message
                                                                        code="messages.page.text.sender"/>:</b>
                                                                    ${message.senderProfileDTO.firstname} ${message.senderProfileDTO.lastname}
                                                            </font> <font size="1">
                                                            <b><spring:message
                                                                    code="messages.page.text.time"/>: </b> ${message.messageDate}
                                                        </font><br/>
                                                            <p>
                                                            <div style="margin-left: 5px"><b> ${message.text} </b></div>
                                                        </div>
                                                    </c:when>

                                                    <c:otherwise>
                                                        <br/>
                                                        <div class="alert-success" style="margin-left: 20px">
                                                            <font size="1">
                                                                <b><spring:message
                                                                        code="messages.page.text.sender"/>:</b>
                                                                    ${message.senderProfileDTO.firstname} ${message.senderProfileDTO.lastname}
                                                            </font> <font size="1">
                                                            <b><spring:message
                                                                    code="messages.page.text.time"/>: </b> ${message.messageDate}
                                                        </font><br/>
                                                            <p>
                                                            <div style="margin-left: 5px"><b> ${message.text} </b></div>
                                                        </div>

                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
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
