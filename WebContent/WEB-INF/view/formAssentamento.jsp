
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=NovoAssentamento" var="linkNovoAssentamento"></c:url>
<c:url value="/entrada?acao=PesquisarPorRe" var="linkPesquisaPorRe"></c:url>
<c:url value="/entrada?acao=FormNovoUsuario" var="linkNovoUsuario"></c:url>

<!DOCTYPE html>
<html lang="pt-Br">
<head>
    <meta charset="Cp1258">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Sistema de Pesquisa de Assentamentos</title>
</head>
<body>
    <div class="container">
    
     <!-- Barra de Navegacao -->
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
              <a class="nav-link" href="/secretaria/entrada?acao=FormPesquisaAvancada">Pesquisar<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="/secretaria/entrada?acao=ListarAssentamento">Listar<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="/secretaria/entrada?acao=FormNovoAssentamento">Novo Assentamento<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="${linkNovoUsuario}">Novo Usuário<span class="sr-only">(current)</span></a>
            </li>
          </ul>
          <form class="form-inline my-2 my-lg-0" action="${linkPesquisaPorRe}" method="post">
            <input class="form-control mr-sm-2" name="search" type="search" placeholder="Pesquisar Por RE" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
          </form>
        </div>
      </nav>
      <!-- Boas Vindas  -->
      <h3>Bem-vindo ${usuario.nome} </h3>
      <!-- Formulario -->
    <form class="row gy-2 gx-3 align-items-center" action="${linkNovoAssentamento}" method="post">
        <div class="col-auto">
            <label class="visually-hidden" for="autoSizingInput">Nome: </label>
            <input type="text" name="nome" class="form-control" id="autoSizingInput" placeholder="Primeiro Nome">
        </div>
        <div class="col-md-6">
            <label class="visually-hidden" for="autoSizingInput">Sobrenome: </label>
            <input type="text" name="sobrenome" class="form-control" id="autoSizingInput" placeholder="Sobrenome Completo Sem Abreviaçăo">
        </div>
        <div class="col-auto">
            <label class="visually-hidden" for="autoSizingInput">Nascimento: </label>
            <input type="date" name="nascimento" class="form-control" id="autoSizingInput">
        </div>
        <div class="col-auto">
            <label class="visually-hidden" for="autoSizingInput">RE: </label>
            <input type="text" name="re" class="form-control" id="autoSizingInput" placeholder="6 dígitos">
        </div>
        <div class="col-auto">
            <label class="visually-hidden" for="autoSizingInput">Caixa: </label>
            <input type="text" name="caixa" class="form-control" id="autoSizingInput" placeholder="Número da Caixa">
        </div>
        <div class="col-auto">
            <br>
          <button type="submit" class="btn btn-outline-success">Enviar</button>
        </div>
      </form>
    <div class="container">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>