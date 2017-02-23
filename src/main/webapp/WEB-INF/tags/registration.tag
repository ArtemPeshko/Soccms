<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>.main-center {
    margin-top: 30px;
    margin: 0 auto;
    max-width: 330px;
    padding: 40px 40px;
}</style>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.6/css/bootstrap.css">
<!-- Website Font style -->
<link href="<c:url value="/resources/css/font-awesome.min.css"/>" type="text/css" rel="stylesheet"/>
<!-- Google Fonts -->
<link href="<c:url value="/resources/css/fontFamilyPassionOne.css"/>" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/fontFamilyOxygen.css"/>" type="text/css" rel="stylesheet">
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.js"></script>

<script>

    var ck_email = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
    var ck_username = /^[A-Za-z0-9_]{5,16}$/;
    var ck_password = /^[A-Za-z0-9!@#$%^&*()_]{7,20}$/;

    function validateRegistrationForm() {

        var email = document.forms["registrationForm"][0].value;
        var login = document.forms["registrationForm"][1].value;
        var password = document.forms["registrationForm"][2].value;
        var confirm = document.forms["registrationForm"][3].value;
        var errors = [];

        if (!ck_email.test(email)) {
            errors[errors.length] = "Incorrect email format";
        }
        if (!ck_username.test(login)) {
            errors[errors.length] = "Incorrect login format.";
        }
        if (!ck_password.test(password)) {
            errors[errors.length] = "Incorrect password format.";
        }
        if (confirm == 0) {
            errors[errors.length] = "You should confirm password";
        }

        if (confirm != password) {
            errors[errors.length] = "Passwords don't match";
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