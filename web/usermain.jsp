<%-- 
    Document   : usermain
    Created on : Feb 29, 2016, 12:59:45 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns=:h="http://java.sun.com/jsf/html">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" type="text/css" href="foundation/css/foundation.css">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <title>User Main</title>
    </head>
    <body>
        <h1>DSS Dataportal</h1>
        <h2>User Main Hub</h2>
        <div class="row" style="height:100px">
            
            <b>User Email: </b> <bean:write name="LoginForm" property="email" />
        </div>
        <div class="row" style="height:400px">
            <div class="large-4 columns">
                <b>Woodcock Johnson</b><br><br>
                    <html:form action="/wjdata"><html:submit value="Data"></html:submit></html:form>
                    <html:form><html:submit value="Analysis"></html:submit></html:form>
                    <html:form><html:submit value="Reports"></html:submit></html:form>
                       
            </div>
            <div class="large-4 columns">
                <b>Attendance</b><br><br>
                    <html:form><html:submit value="Data"></html:submit></html:form>
                    <html:form><html:submit value="Analysis"></html:submit></html:form>
                    <html:form><html:submit value="Reports"></html:submit></html:form>
            </div>
            <div class="large-4 columns">
                <b>Risk Factors</b><br><br>
                    <html:form><html:submit value="Data"></html:submit></html:form>
                    <html:form><html:submit value="Analysis"></html:submit></html:form>
                    <html:form><html:submit value="Reports"></html:submit></html:form>
            </div>
        </div>
        <div class="row">
            <html:form action="/logout"><html:submit value="Logout"></html:submit></html:form>
        </div>
        <!--
        <table border="0">
            <tbody>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><bean:write name="LoginForm" property="email" /></td>
                </tr>
                <tr>
                    <td>Status:</td>
                    <td></td>
                </tr>
                <tr>
                    <td>
                        <b>Woodcock Johnson Test Analysis</b>
                        <table border="0">
                            <tr>
                                <td>
                                <html:form action="/wjdata">
                                    <html:submit value="WJIII Data"/>
                                </html:form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                <html:form>
                                    <html:submit value="WJIII Analysis"/>
                                </html:form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                <html:form>
                                    <html:submit value="WJIII Reports"/>
                                </html:form>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <b>Attendance Analysis</b>
                        <table border ="0">
                            <tr>
                                <td>
                                <html:form>
                                    <html:submit value="Attendance Data"/>
                                </html:form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                <html:form>
                                    <html:submit value="Attendance Analysis"/>
                                </html:form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                <html:form>
                                    <html:submit value="Attendance Reports"/>
                                </html:form>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <b>Risk Factor Analysis</b>
                        <table border="0">
                        <tr>
                            <td>
                                <html:form>
                                    <html:submit value="Risk Factor Data"/>
                                </html:form>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <html:form>
                                    <html:submit value="Risk Factor Analysis"/>
                                </html:form>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <html:form>
                                    <html:submit value="Risk Factor Reports"/>
                                </html:form>
                            </td>
                        </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <html:form action="/logout">
                            <html:submit value="Logout"/>
                        </html:form>
                    </td>
                    <td>
                        
                    </td>
                </tr>
            </tbody>
        </table>
                -->

    </body>
</html>
