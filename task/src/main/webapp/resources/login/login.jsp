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
        <title>Login</title>
        <style>
            body {
                min-width: 400px;
                background-color: #E8E8E8;
                text-align: center;
                font: 13px/1.4 Helvetica, arial, nimbussansl, liberationsans, freesans, clean, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
            }
            font {font-size: 26px;}
            #logo {margin-top: 5%;}
            #login {
                border: 1px #CFCFCF solid;
                width: 300px;
                text-align: left;
                margin: 1% auto;
                padding: 12px;
                background-color: white;
            }
            input {
                width: 285px;
                height: 30px;
            }
            #button {
                width: 288px;
                height: 30px;
                margin-top: 4%;
            }
            #back{
                width: 322px;
                margin: 0 auto;
                padding-top: 12px;
                padding-bottom: 12px;
                border: 1px #B5B5B5 solid;
                text-decoration: none;
            }
            a {
                text-decoration: none;
                color: black;
            }
        </style>
    </head>
    <body>
        
        <div id="logo">
            
        </div>
        <font>Київреклама</font>
        <table id="login">
            <form action="j_security_check" method="post">
                <tr><td>login</td></tr>
                <tr><td><input type="text" name="j_username"></td></tr>
                <tr><td>password</td></tr>
                <tr><td><input type="password" name="j_password"></td></tr>
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
