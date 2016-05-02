<%-- 
    Document   : login_content
    Created on : Apr 29, 2016, 8:46:03 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="foundation-6.2.1-complete/css/foundation.css"/>
<!DOCTYPE html>
Enter login credentials below.
<form action="${pageContext.request.contextPath}/dashboard.htm">
      <div class="row column log-in-form">
        <h4 class="text-center">Log in with you email account</h4>
        <label>Email
          <input type="text" placeholder="somebody@example.com">
        </label>
        <label>Password
          <input type="password" placeholder="Password">
        </label>
        <input id="show-password" type="checkbox"><label for="show-password">Show password</label>
        <!--<p><a type="submit" class="button expanded">Log In</a></p>-->
        <p><input type="submit" value="Log In"/></p>
        <p class="text-center"><a href="#">Forgot your password?</a></p>   
      </div>
    </form>

