<%-- 
    Document   : newtask
    Created on : May 25, 2016, 4:58:37 PM
    Author     : firsov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./../css/login.css"/>
        <title>Login</title>
    </head>
    <body>
        
        <div id="logo">
            <img src="./../img/logo.png" alt="logotip">
        </div>
        <font>Київреклама</font>
        <table id="login">
            <form action="j_security_check" method="post">
                <tr><td>login</td></tr>
                <tr><td><input id="text_login" type="text" name="j_username"></td></tr>
                <tr><td>password</td></tr>
                <tr><td><input  type="password" name="j_password"></td></tr>
                <tr>
                    <td>
                        <input id="button" type="submit" value="Увійти">
                    </td>
                </tr>
            </form>
            
        </table>
        
        <a href="/task/"><div id="back">Повернутися назад</div></a>
        
    </body>
</html>
