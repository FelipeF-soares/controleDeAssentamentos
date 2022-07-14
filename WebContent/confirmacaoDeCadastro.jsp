
<!--core Controle de Fluxo -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--fmt formata��o /i18(internacionaliza��o) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
              <a class="nav-link" href="/secretaria/formPesquisaAvancada.jsp">Pesquisar<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="/secretaria/listarAssentamento">Listar<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="/secretaria/formAssentamento.jsp">Novo Assentamento<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="#">Novo Usu�rio<span class="sr-only">(current)</span></a>
            </li>
          </ul>
          <form class="form-inline my-2 my-lg-0" action="/secretaria/pesquisarPorRe" method="get">
            <input class="form-control mr-sm-2" name="search" type="search" placeholder="Pesquisar Por RE" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
          </form>
        </div>
      </nav>

      <div class="card">
        <h5 class="card-header">As Informa��es est�o Corretas?</h5>
        <div class="card-body">
		
		
		
	          <h5 class="card-title">Nome: ${assentamento.nome} ${assentamento.sobrenome }</h5>
	          <fmt:parseDate value="${assentamento.nascimento }" pattern="yyyy-MM-dd" var="nascimentoFormatt" type="date"></fmt:parseDate>
	          <p class="card-text">Nascimeto: <fmt:formatDate pattern="dd/MM/yyyy" value="${nascimentoFormatt}"/> 
	          RE: ${assentamento.re} 
	          Caixa: ${assentamento.caixa}</p>
	          <form action="/secretaria/confirmaCadastro" method="post">
			      	 
				          <input type="hidden" name="nome" value="${assentamento.nome}">
				          <input type="hidden" name="sobrenome" value="${assentamento.sobrenome}">
				          <input type="hidden" name="nascimento" value="${assentamento.nascimento}">
				          <input type="hidden" name="re" value="${assentamento.re}">
				          <input type="hidden" name="caixa" value="${assentamento.caixa}">
			          	  <button class="btn btn-success btn-sm" type="submit">Sim</button>
			          	  <a href="/secretaria/formAssentamento.jsp" class="btn btn-danger btn-sm">N�o</a>	
			  </form>	
	                    
         
        
        </div>
      </div>   
      
      
      
      
    </div class="container">
    
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>