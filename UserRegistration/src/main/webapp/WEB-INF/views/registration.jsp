<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>
        <body>
            <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="userName">Username</form:label>
                        </td>
                        <td>
                            <form:input path="userName" name="userName" id="userName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="emailId">Email</form:label>
                        </td>
                        <td>
                            <form:input path="emailId" name="emailId" id="emailId" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="mobileNumber">Phone</form:label>
                        </td>
                        <td>
                            <form:input path="mobileNumber" name="mobileNumber" id="mobileNumber" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <form:button id="register" name="register">Register</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="helloworld">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>
        </body>
        </html>