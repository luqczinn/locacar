<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Locacar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <style>
            .parent-login{
                border: 1px solid #fff;
                max-width: 900px;
                margin: auto;
                display: grid;
                grid-template-areas: "box-login submit-button forgot-password";
                grid-gap: 20px;

            }
            .box-login{
                grid-area: "box-login";
                grid-row: box-login;
                width: 100%;
            }
            .submit-button{
                grid-area: "submit-button";
                width: 100%;
            }
            .btn-block{
                margin-top: 15px;
                margin-bottom: 15px;
                background-color: #1fa853;
                color: #f6e300;
                border-color: #1fa853;
            }
            .forgot-password{
                grid-area: "forgot-password";
                width: 100%;
            }
            .form-control::placeholder{
                color: #6ed696;
            }
            .ls-login-logo{
                color: #024f1f;
                font-size: 30px;
            }
            .ls-login-signup{
                color: #024f1f;
            }
            .ls-login-forgot{
                color: #024f1f;
            }
        </style>
    </head>
    <body>
        <div class="parent-login">
            <div class="parent-inner">
          
              <div class="box-login">
                <h1 class="ls-login-logo">Faça seu login!</h1>
                <form role="form" action="http://opensource.locaweb.com.br/locawebstyle-v2/manual/exemplos/login/">
                  <fieldset>
                    <div class="form-group-ls-login-user">
                      <label for="userLogin">Usuário</label>
                      <input class="form-control ls-login-bg-user input-lg" id="userLogin" type="text" aria-label="Usuário" placeholder="Usuário">
                    </div>
          
                    <div class="form-group ls-login-password">
                      <label for="userPassword">Senha</label>
                      <input class="form-control ls-login-bg-password input-lg" id="userPassword" type="password" aria-label="Senha" placeholder="Senha">
                    </div>
                    <div class="submit-button">
                        <input type="submit" value="Entrar" class="btn btn-primary btn-lg btn-block">
                    </div>
                    <div class="forgot-password">
                        <a href="http://opensource.locaweb.com.br/locawebstyle-v2/manual/exemplos/login/#" class="ls-login-forgot">Esqueci minha senha</a>
                        <p class="txt-center ls-login-signup">Não possui um usuário na Locacar? <a class="ls-login-signup"href="http://opensource.locaweb.com.br/locawebstyle-v2/manual/exemplos/login/#">Cadastre-se agora</a></p>
                    </div>
                  </fieldset>
                </form>
              </div>
          
            </div>
          </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
    </body>
</html>