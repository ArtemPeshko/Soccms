<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div style="position:relative;">

        <spring:message code="photos.page.text.browse"/>
        <input type="file" name="photo" size=" 40">

    <span class='label label-info' id="upload-file-info"></span>
<br/>
    <input type="submit" class="btn btn-default" style="background-color:rgba(24, 62, 118, 0.84); color: white"
           value="<spring:message code="photos.page.text.upload"/>" disabled>

</div>
