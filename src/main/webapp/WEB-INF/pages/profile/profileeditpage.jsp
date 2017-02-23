<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="profile.page.text.edition"/></title>
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


                            <form:form method="POST" action="/profile/editprofile" commandName="profileDTO" class="form-horizontal">

                                <form:hidden path="profileID"/>

                                <form:errors path="firstname"/>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <form:input class="form-control" type="text" path="firstname" name="name"
                                                id="name" placeholder="firstname"/>
                                </div>


                                <br/>
                                <form:errors path="lastname"/>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <form:input class="form-control" type="text" path="lastname" name="name" id="name"
                                                placeholder="lastname"/>
                                </div>

                                <br/>
                                <form:errors path="email"/>
                                <div class="cols-sm-10">
                                    <div class="input-group"> <span class="input-group-addon">
                                    <i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                        <form:input path="email" placeholder="email" type="text" class="form-control"
                                                    name="email" id="email"/>
                                    </div>
                                </div>


                                <br/>

                                <spring:message code="profile.page.text.gender"/>: <form:radiobutton path="sex" value="male"/>
                                <spring:message code="profile.page.text.male"/>
                                <form:radiobutton path="sex" value="female"/> <spring:message code="profile.page.text.female"/>
                                <br/> <br/>

                                <form:errors path="phoneNumber"/>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-mobile" aria-hidden="true"></i></span>
                                        <form:input path="phoneNumber" type="text" class="form-control" name="mobile" id="mobile"
                                                    placeholder="phoneNumber"/>
                                    </div>
                                </div>

                                <br/>
                                <form:errors path="city"/>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-map-marker fa-lg" aria-hidden="true">
                                         </i></span> <form:input path="city" placeholder="city" type="text" class="form-control"
                                                                 name="country" id="country"/>
                                    </div>
                                </div>

                                <br/>

                                <form:errors path="birthDate"/>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <form:input path="birthDate" placeholder="city" type="date" class="form-control"
                                                    name="name" id="name"/> <br/>

                                    </div>
                                </div>

                                <br/>
                                <form:errors path="age"/>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <form:input path="age" placeholder="age" type="text" class="form-control"
                                                    name="name" id="name"/>
                                    </div>
                                </div>
                                <br/>

                                <button type="submit" class="btn btn-default btn-lg btn-block"><spring:message
                                        code="profile.page.text.save"/>
                                </button>
                            </form:form>
                        </div>

                    </div>

                </div>
            </div>
    </div>
</section>
</body>
</html>
