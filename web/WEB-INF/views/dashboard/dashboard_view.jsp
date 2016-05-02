<%-- 
    Document   : dashboard_view
    Created on : Apr 30, 2016, 1:01:24 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="foundation-6.2.1-complete/css/foundation.css"/>
        <link rel="stylesheet" href="foundation-6.2.1-complete/css/foundation.min.css"/>
        <link rel="stylesheet" href="foundation-6.2.1-complete/css/app.css"/>
        <!--<script src="/foundation-6.2.1-complete/js/vendor/modernizer.js"/>-->
        
        <title>Dataportal Dashboard</title>
    </head>
    <body>
        <!-- Header -->
        <div class="row">
            <div class="medium-6 medium-centered columns dashboardHeader">
                <h1>Dataportal Dashboard</h1>
            </div>
            
        </div>
        <!-- Content -->
        
        <jsp:include page="/WEB-INF/views/dashboard/dashboard_content.jsp"/>
        
        
        <!-- Footer -->
        
           

        <!--
        <script src="foundation-6.2.1-complete/js/vendor/jquery.js"></script>
        <script src="foundation-6.2.1-complete/js/foundation.min.js"></script>
        <script>
            $(document).foundation();
        </script>
        -->
    </body>
</html>
