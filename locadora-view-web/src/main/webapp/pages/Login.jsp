<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Locacar</title>
        <style>
            input::placeholder {
                color: #6ed696;
            }
            h2{
                color: #024f1f;
                font-size: 30px;
            }
            button{
                background-color: #1fa853;
                color: #f6e300;
            }
            a{
                color: #024f1f;
            }
            .loginDiv{
                display:flex;
                top: 0px;
                align-items: center;
                justify-content: center;
                width: 300px;
                padding: 20px;
                margin: 200px auto;
            }


        </style>
    </head>
    <body>
        <div class="loginDiv">
            <form class="loginForm">
                <span class="login-faca-seu-login">
                    <h2>Faça seu login!</h2>
                </span>
                <div class="username_div">
                    <input class="inputUsername" type="text" name="username" placeholder="Email, CPF, CNPJ ou número Locacar">
                    <span class="focus-inputUsername" ></span>
                    <label for="username" class="form__label"></label>
                </div>
                <div class="senha_div">
                    <input class="inputSenha" type="password" name="pass" placeholder="Senha">
                    <span class="focus-inputSenha" ></span>
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
        </div>      
    </body>
</html>