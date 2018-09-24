<%@ page import="model.User" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table align="center">
                <tr>
                    <td style="font-style: italic; color: blue;"><h1>Welcome ${user.password}</h1></td>
                </tr>
            </table>
<%-- <h1>Welcome ${user.password} </h1> --%>
<a href="helloWorld">Home</a>
</body>
</html>