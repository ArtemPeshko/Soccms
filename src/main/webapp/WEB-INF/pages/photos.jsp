<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="welcome.page.text.photoes"/></title>
    <action:actions/>

</head>
<body>
<section>
    <div class="mainwrapper">
        <jsp:include page="/WEB-INF/pages/additional/sidebar.jsp"/>
        <div class="mainpanel">
            <div class="contentpanel">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="tabbable tabs-left">
                            <div class="tab-content">
                                    <div style="margin-left: 20%">

                                        <form:form method="post"
                                                   action="/photos/photoupload/${pageContext.request.userPrincipal.name}"
                                                   enctype="multipart/form-data" onsubmit="return Validate(this);"
                                                   commandName="photoDTO">

                                            <action:photopload/> <br/> <br/>
                                        </form:form>
                                        <!--list of images -->

                                        <div id="links">

                                            <c:forEach items="${allThePhotos}" var="photo">

                                                <a data-gallery="" href="images/${photo.photoFileName}"> <img
                                                        src="images/${photo.photoFileName}" width="200"> </a>

                                                <a href="/photos/delete/${photo.id}"><b><font color="#a52a2a" size="5">
                                                    x </font></b> </a>

                                            </c:forEach>

                                        </div>

                                        <!-- The Bootstrap Image Gallery lightbox, should be a child element of the document body -->
                                        <div id="blueimp-gallery" class="blueimp-gallery">
                                            <!-- The container for the modal slides -->
                                            <div class="slides"></div>
                                            <!-- Controls for the borderless lightbox -->
                                            <h3 class="title"></h3>
                                            <a class="prev">‹</a>
                                            <a class="next">›</a>
                                            <a class="close">×</a>
                                            <a class="play-pause"></a>
                                            <ol class="indicator"></ol>
                                            <!-- The modal dialog, which will be used to wrap the lightbox content -->
                                            <div class="modal fade">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" aria-hidden="true">×
                                                            </button>
                                                            <h4 class="modal-title"></h4>
                                                        </div>
                                                        <div class="modal-body next"></div>
                                                        <div class="modal-footer">
                                                            <button type="button"
                                                                    class="btn btn-default pull-left prev">
                                                                <i class="glyphicon glyphicon-chevron-left"></i>
                                                                Previous
                                                            </button>
                                                            <button type="button" class="btn btn-primary next">
                                                                Next
                                                                <i class="glyphicon glyphicon-chevron-right"></i>
                                                            </button>
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
                </div>
            </div>
        </div>
</section>

</body>
</html>
