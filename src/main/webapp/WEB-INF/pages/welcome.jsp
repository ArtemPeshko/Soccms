<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="welcome.page.text.wall"/></title>
    <action:actions/>

</head>
<body>
<section>
    <div class="mainwrapper">
        <jsp:include page="/WEB-INF/pages/additional/sidebar.jsp"/>
        <div class="mainpanel">
            <div class="contentpanel">
                <div class="row">
                    <div class="col-sm-4 col-md-3">
                        <div class="text-center">
                            <div class="mb20"></div>
                            <div class="btn-group">
                                <a class="button"
                                   href="/friends/allthefriends/${pageContext.request.userPrincipal.name}">
                                    <button type="button" class="btn btn-primary btn-bordered">
                                        <spring:message code="friend.page.text.showallfriends"/>
                                    </button>
                                </a>
                                <br/>
                                <br/>
                                <a href="/posts/showusers" class="btn btn-primary btn-bordered"><spring:message
                                        code="posts.page.text.choose.wall"/></a>
                            </div>
                        </div>
                        <br/>
                        <div class="mb30"></div>
                    </div>
                    <div class="col-sm-8 col-md-9">
                        <form:form action="/posts/sendaposttomyself" method="post" commandName="postDTO"
                                   enctype="multipart/form-data" onsubmit="return Validate(this);">
                            <spring:message code="messages.page.text.entertext" var="entertext"/>
                            <form:textarea class="form-control" id="texta" path="text" rows="3" name="text"
                                           placeholder="${entertext}"/>
                            <br/><action:fileupload/>
                        </form:form>
                        <div class="tab-content nopadding noborder">
                            <div class="tab-pane active" id="activities">
                                <div class="activity-list">
                                    <div class="media">
                                        <div class="media-body">
                                            <c:forEach items="${allThePosts}" var="post">
                                                <c:choose>
                                                    <c:when test="${post.photoFileName.length() gt 1}">
                                                        <img src="images/${post.photoFileName}" style="width: 600px">
                                                        <br/>
                                                    </c:when>
                                                </c:choose>
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">
                                                        <font size="1"> <b> <spring:message
                                                                code="posts.page.text.author"/>:
                                                        </b> ${post.senderProfileDTO.firstname} ${post.senderProfileDTO.lastname}
                                                        </font>
                                                        <font size="1"> <b style="margin-left: 7px;"> <spring:message
                                                                code="posts.page.text.date"/>: </b> ${post.postDate.toLocaleString()}
                                                            <a href="/posts/deleteapost/${post.postID}"
                                                               style="margin-left: 5px;">
                                                                <spring:message code="posts.page.text.delete"/></a>
                                                        </font>

                                                    </div>

                                                    <c:choose>
                                                        <c:when test="${post.text.length() gt 1}">
                                                            <div class="panel-body"> ${post.text}
                                                            </div>
                                                        </c:when>
                                                    </c:choose>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                                        <div class="tab-pane" id="admin">
                                            <p>

                                                </c:if>
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
