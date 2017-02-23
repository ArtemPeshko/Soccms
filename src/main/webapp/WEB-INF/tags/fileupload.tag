<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div style="position:relative;">
    <a class='btn btn-default'>
        <spring:message code="photos.page.text.browse"/>
        <input type="file"
               style='position:absolute;z-index:2;top:0;left:0;filter: alpha(opacity=0);
                                               -ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
                                               opacity:0;'
               name="photo" size=" 40"
               onchange='$("#upload-file-info").html($(this).val());'>
    </a>
    <span class='label label-info' id="upload-file-info"></span>
    <input type="submit" class="btn btn-default" style="background-color:rgba(30, 132, 157, 0.75); float: right; color: white"
           value="<spring:message code="posts.page.text.send"/>">

</div>

