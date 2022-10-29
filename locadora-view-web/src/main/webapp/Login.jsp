<%-- 
    Document   : Login
    Created on : 29 de out. de 2022, 08:09:17
    Author     : sufra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Locacar</title>
    </head>
    <body>
        <form class="login">
            <span class="login-faca-seu-login">
               <h2>Faça seu login!</h2>>
            </span>
            <div class="username_div">
                <input class="inputUsername" type="text" name="username">
                <span class="focus-inputUsername" data-placeholder="Email, CPF, CNPJ ou número Locacar"></span>
            </div>
            <div class="senha_div">
                <input class="inputSenha" type="password" name="pass">
                <span class="focus-inputSenha" data-placeholder="Senha"></span>
            </div>
            <div class="botaoLogin_div">
                    <button class="buttonLogin">
                        ENTRAR
                    </button>
            </div>
            <div class="cadastroERecuperacao_div">
                <a class="txt1" href="#">
                    Ainda não sou cliente
                </a>
                <a class="txt2" href="#">
                    Esqueci minha senha
                </a>
            </div>
        </form>
    </body>
</html>
