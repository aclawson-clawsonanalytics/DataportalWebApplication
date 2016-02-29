<%-- 
    Document   : login
    Created on : Feb 29, 2016, 11:35:04 AM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <title>Dataportal Login</title>
    </head>
    <body>
        <h1>Welcome to the DSS Dataportal Login</h1>
        
        <html:form action="/login">
            <table border="0">
                
                <tbody>
                    <tr>
                        <td colspan="2">
                            <bean:write name="LoginForm" property="missingFieldsError" filter="false"/>
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td>Enter your username: </td>
                        <td><html:text property="username" /></td>
                    </tr>
                    <tr>
                        <td>Enter your password: </td>
                        <td><html:text property="password" /></td>
                    </tr>
                    
                </tbody>
            </table>

            <html:submit value="Login"/>
        </html:form>
    </body>
</html>
