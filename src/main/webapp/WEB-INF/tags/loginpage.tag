<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>.main-center {
    margin-top: 30px;
    margin: 0 auto;
    max-width: 330px;
    padding: 40px 40px;
}</style>

<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.6/css/bootstrap.css">
<link href="<c:url value="/resources/css/font-awesome.min.css"/>" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/fontFamilyPassionOne.css"/>" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/fontFamilyOxygen.css"/>" type="text/css" rel="stylesheet">

<script>

    var ck_username = /^[A-Za-z0-9_]{5,16}$/;
    var ck_password = /^[A-Za-z0-9!@#$-%^&*()_]{7,20}$/;

    function validateLoginForm() {

        var login = document.forms["loginForm"][0].value;
        var password = document.forms["loginForm"][1].value;
        var errors = [];


        if (!ck_username.test(login)) {
            errors[errors.length] = "Login must contain 5-16 letters or digits";
        }

        if (!ck_password.test(password)) {
            errors[errors.length] = "Password must contain 7-20 symbols";
        }

        if (errors.length > 0) {

            reportErrors(errors);
            return false;
        }
        return true;
    }

        function reportErrors(errors) {
            var msg = "You must enter correct data:\n";
            for (var i = 0; i < errors.length; i++) {
                var numError = i + 1;
                msg += "\n" + numError + ". " + errors[i];
            }
            alert(msg);
        }


</script>