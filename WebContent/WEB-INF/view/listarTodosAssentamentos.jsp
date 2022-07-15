<!--core Controle de Fluxo -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--fmt formatação /i18(internacionalização) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada?acao=PesquisarPorRe" var="linkPesquisaPorRe"></c:url>

<!DOCTYPE html>
<html lang="pt-Br">
<head>
    <meta charset="Cp1252">
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
              <a class="nav-link" href="#">Novo Usuário<span class="sr-only">(current)</span></a>
            </li>
          </ul>
          <form class="form-inline my-2 my-lg-0" action="${linkPesquisaPorRe}" method="post">
            <input class="form-control mr-sm-2" name="search" type="search" placeholder="Pesquisar Por RE" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
          </form>
        </div>
      </nav>

      <div class="card">
        <h5 class="card-header">Lista De Assentamento</h5>
        
        <c:if test="${not empty assentamentos }">
	        <c:forEach items="${assentamentos}" var="assentamento">
		         <div class="card-body">
			          <h5 class="card-title">Nome: ${assentamento.nome} ${assentamento.sobrenome} </h5>
			          <fmt:parseDate value="${assentamento.nascimento}" pattern="yyyy-MM-dd" var="nascimetoFormatt" type="date"></fmt:parseDate>
			          <p class="card-text">Nascimento: <fmt:formatDate pattern="dd/MM/yyyy" value="${nascimetoFormatt}"/> RE: ${assentamento.re}  Caixa: ${assentamento.caixa} </p>
			          <a href="entrada?acao=PesquisarPorId&id=${assentamento.id}" class="btn btn-warning" btn-sm">Alterar</a>
		        </div>
	        </c:forEach>
        </c:if>
        <c:if test="${empty assentamentos }">
        	<h1>Nenhum Assentamento Cadastrados!</h1>
        </c:if>
        </div>
      
          
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>