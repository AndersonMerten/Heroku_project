<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <!-- HEAD -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="${app}">
        <meta name="author" content="Fábio Tavares Dippold">

        <link rel="icon" href="assets/icons/qb-icon.png">
        <title>${app}</title>
        <!-- Bootstrap -->
        <link href="assets/css/custom.css" rel="stylesheet">
        <link href="assets/core/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/core/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
    </head><!-- /HEAD -->
    <body>
        <!-- menu superior -->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="mvcmenu?do=lstmodel">VirtualShop</a>
                </div>
                <ul class="nav navbar-nav">
                        <li class="active"><a href="mvccustomer?do=lstmodel">Clientes</a></li>
                        <li><a href="mvcproduto?do=lstmodel">Produtos</a></li>
                        <li><a href="mvctransportador?do=lstmodel">Transportadoras</a></li>
                        <li><a href="#">Pedidos</a></li>
                </ul>
            </div>
        </nav>
        <!-- menu superior -->
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3>Dados do cliente</h3>
            </div>
            <div class="panel-body">
                <label>Id: ${datasource.id}</label>
                <label>Nome: ${datasource.name}</label>
                <label>CPF: ${datasource.cpf}</label>
            </div>
            <div class="panel-footer">
                <a class="btn btn-info" href="mvccustomer?do=lstmodel" title="VISUALIZAR">
                                                Voltar</a>
            </div>
        </div>

    </body>
</html>
