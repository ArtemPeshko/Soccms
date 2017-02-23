<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">

<link href="<c:url value="/resources/css/main.css"/>" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/style.default.css"/>" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/morris.css"/>" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/select2.css"/>" type="text/css"  rel="stylesheet">
<link href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>" type="text/css" rel="stylesheet">
<!-- Google Fonts -->
<link href="<c:url value="/resources/css/fontFamilyPassionOne.css"/>" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/fontFamilyOxygen.css"/>" type="text/css" rel="stylesheet">
<!-- Website Font style -->
<link href="<c:url value="/resources/css/font-awesome.min.css"/>" type="text/css" rel="stylesheet">
<jsp:include page="/WEB-INF/pages/additional/navbar.jsp"/>

<%--photo gallery--%>
<link href="<c:url value="/resources/css/bootstrap302.min.css"/>" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/blueimp-gallery.min.css"/>" type="text/css" rel="stylesheet">

<script type="text/javascript" src="<c:url value="/resources/js/1102jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/302bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.blueimp-gallery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-migrate-1.2.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/modernizr.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/pace.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/retina.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.cookies.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/flot/jquery.flot.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/flot/jquery.flot.resize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/flot/jquery.flot.spline.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.sparkline.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/morris.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/raphael-2.1.0.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap-wizard.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/select2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/custom.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dashboard.js"/>"></script>
<script>
    $(document).ready(
            function () {
                $('input:file').change(
                        function () {
                            if ($(this).val()) {
                                $('input:submit').attr('disabled', false);
                            }
                        }
                );
            });
</script>

<script type='text/javascript'>

    $(document).ready(function () {
        $('input[type="submit"]').attr('disabled', true);
        $('input[type="text"],textarea').on('keyup', function () {
            var textarea_value = $("#texta").val();
            var text_value = $('input[name="textField"]').val();
            if (textarea_value != '' && text_value != '') {
                $('input[type="submit"]').attr('disabled', false);
            } else {
                $('input[type="submit"]').attr('disabled', true);
            }
        });
    });

</script>

<script>

    document.getElementById("myText").disabled = true;

</script>


<script>

    var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png"];

    function Validate(oForm) {
        var arrInputs = oForm.getElementsByTagName("input");
        for (var i = 0; i < arrInputs.length; i++) {
            var oInput = arrInputs[i];
            if (oInput.type == "file") {
                var sFileName = oInput.value;
                if (sFileName.length > 0) {
                    var blnValid = false;
                    for (var j = 0; j < _validFileExtensions.length; j++) {
                        var sCurExtension = _validFileExtensions[j];
                        if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                            blnValid = true;
                            break;
                        }
                    }
                    if (!blnValid) {
                        alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
                        return false;
                    }
                }
            }
        }
        return true;
    }

</script>


<style>
    .tabs-left > .nav-tabs {
        border-bottom: 0;
    }

    .tab-content > .tab-pane,
    .pill-content > .pill-pane {
        display: none;
    }

    .tab-content > .active,
    .pill-content > .active {
        display: block;
    }

    .tabs-left > .nav-tabs > li {
        float: none;
    }

    .tabs-left > .nav-tabs > li > a {
        min-width: 74px;
        margin-right: 0;
        margin-bottom: 3px;
    }

    .tabs-left > .nav-tabs {
        float: left;
        margin-right: 19px;
        border-right: 1px solid #ddd;
    }

    .tabs-left > .nav-tabs > li > a {
        margin-right: -1px;
        -webkit-border-radius: 4px 0 0 4px;
        -moz-border-radius: 4px 0 0 4px;
        border-radius: 4px 0 0 4px;
    }

    .tabs-left > .nav-tabs > li > a:hover,
    .tabs-left > .nav-tabs > li > a:focus {
        border-color: #eeeeee #dddddd #eeeeee #eeeeee;
    }

    .tabs-left > .nav-tabs .active > a,
    .tabs-left > .nav-tabs .active > a:hover,
    .tabs-left > .nav-tabs .active > a:focus {
        border-color: #ddd transparent #ddd #ddd;
        *border-right-color: lightblue;;
    }
</style>

<script type="text/javascript" src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

