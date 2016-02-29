<%-- 
    Document   : usermain
    Created on : Feb 29, 2016, 12:59:45 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Main</title>
    </head>
    <body>
        <h1>DSS Dataportal</h1>
        <h2>User Main Hub</h2>
        <table border="0">
            <tbody>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Username: </td>
                    <td><bean:write name="LoginForm" property="username" /></td>
                </tr>
                <tr>
                    <td>Status: </td>
                    <td></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
