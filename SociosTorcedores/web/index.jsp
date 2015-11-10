<%-- 
    Document   : index
    Created on : 05/11/2015, 10:25:55
    Author     : Everson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no">
        <meta name="viewport" content="width=500, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <meta charset="utf-8" />
        <title>
            Login Socio Torcedor
        </title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="validacaoFormulario.js">
        </script>
    </head>
    <body>


        <?php
        if(isset($_COOKIE['username'])) $nome = $_COOKIE['username'];
        else $nome = "";

        if(isset($_COOKIE['password'])) $senha = $_COOKIE['password'];
        else $senha = "";
        sd
        ?>
        <header>
            <div id="top">
                <form id="formulario1" action="Controller"  method="POST"> 
                    <input type="hidden" name="command" value="usuario.login"/>
                    <input type="text" id="text" name="username" placeholder="Nome de usuário">
                    <input type="password" id="senha" name="password" placeholder="Senha">
                    <input type="submit" name="entrar" value="Entrar">
                    <br/>
                    <input type="checkbox" name="lembrar-me" value="lembrar-me"/>Lembrar-me 
                </form>
            </div>
            <h1>

                Socio Torcedor

            </h1>
        </header>
        <br />

        <article>
            <h2>
                Escolha seu time do coração e o melhor plano que cabe no seu bolso. 
                Saiba dos últimos resultados dos jogos e ganhe descontos em seus ingressos.

            </h2> 
        </article>
    </section>

    <section class="flutuante">
        <form name="form" id="formulario2" action="Inscreva-se.php" method="post" onSubmit="return validarFormulario(this)">
            <span>
                Quer fazer parte dos sócios torcedores também? Inscreva-se
            </span>
            <br/>
            <hr>
            <input type="name" id="name" name="nome" placeholder="Nome completo">
            <br/>
            <br/>
            <input type="email" id="email" name="email" placeholder="E-mail">
            <br/>
            <br/>
            <input type="password" id="senha" name="senha" placeholder="Senha">
            <br/> 
            <br/>
            <input type="submit" name="entrar" value="Proximo">
            <br/>
        </form>

    </section>

    <footer>
        <small> &copy2015. Edgar, Everson, Thiago  </small>
    </footer>
</body>

</html>
