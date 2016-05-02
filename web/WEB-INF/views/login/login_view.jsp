<%-- 
    Document   : login
    Created on : Apr 29, 2016, 8:45:33 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" href="foundation/css/foundation.css"/>-->
        <link rel="stylesheet" href="foundation-6.2.1-complete/css/foundation.css"/>
        
        <link rel="stylesheet" href="/WEB-INF/styles/loginStyles.css"/>
        <title>Denver Street School</title>
    </head>
    <body>
        <!-- Header -->
        <div class="headerDiv">
        <div class="row" id="loginHeader">
            <div class="medium-6 large-centered columns">
                <jsp:include page="/WEB-INF/fragments/header.jsp"/>
            </div>
        </div>
        </div>
            <!-- Content -->
            <div class="row">
                <div class="medium-6 large-centered columns">
                    <jsp:include page="/WEB-INF/views/login/login_content.jsp"/>
                </div>
            </div>
                
            <!-- Footer -->
            <div class="row">
                <div class="medium-6 large-centered columns">
                    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
                </div>
            </div>
    </body>
</html>
