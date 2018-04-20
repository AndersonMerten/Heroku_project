<%-- 
    Document   : ListProdutoView
    Created on : Dec 13, 2017, 10:02:40 PM
    Author     : Anderson
--%>

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
        <meta name="author" content="Anderson">

        <link rel="icon" href="assets/icons/qb-icon.png">
        <title>${app}</title>

        <!-- Bootstrap -->
        <link href="assets/core/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/core/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
    </head><!-- /HEAD -->


    <body>
        <!-- MAIN CONTAINER -->   
        <div id="main" class="container-fluid"> 

            <!-- menu superior -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="mvcmenu?do=lstmodel">VirtualShop</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li><a href="mvccustomer?do=lstmodel">Clientes</a></li>
                        <li class="active"><a href="mvcproduto?do=lstmodel">Produtos</a></li>
                        <li><a href="mvctransportador?do=lstmodel">Transportadoras</a></li>
                        <li><a href="#">Pedidos</a></li>
                    </ul>
                </div>
            </nav>
            <!-- menu superior -->


            <!-- DIV-LIST -->
            <div id="list">
                <!-- SIMPLE GRID... -->
               
                <div class="panel panel-default col-lg-10 col-md-10">
                    <div class="panel-heading row">Listagem de produto
                        <div style="float: right;"><a class="btn btn-success" href="${actionToAdd}" title="Adicionar novo">
                                                Adicionar novo produto</a></div>
                    </div>
                    <!-- TABLE -->
                    <div class="panel-body row">
                        <table class="table text-center table-responsive table-striped" >
                            <!-- HEADER -->
                            <thead >
                                <tr class="text-center">
                                    <th class="text-center">Id</th><th class="text-center">Nome</th><th class="text-center">Descrição</th><th class="text-center">Preço</th><th class="text-center">Editar</th><th class="text-center">Visualizar</th><th class="text-center">Apagar</th>
                                </tr>
                            </thead><!-- /HEADER -->
                            <!-- DATAGRID-LINES -->
                            <tbody>
                                <c:forEach var="o" items="${datasource}">
                                    <tr>
                                        <td>${o.id}</td>
                                        <td>${o.name}</td>
                                        <td>${o.descricao}</td>
                                        <td>${o.price}</td>
                                        <td><a class="btn btn-info" href="mvcproduto?do=updmodel&id=${o.id}" title="ATUALIZAR">
                                                Update</a>
                                        </td>
                                        <td>
                                            <a class="btn btn-info" href="mvcproduto?do=readmodel&id=${o.id}" title="VISUALIZAR">
                                                Visualizar</a>
                                        </td>
                                        <td>
                                            <a class="btn btn-danger" href="mvcproduto?do=del&id=${o.id}" title="DELETAR">
                                                Deletar</a>
                                        </td>
                                        </div>
                                    </tr>
                                </c:forEach>
                            </tbody><!-- /DATAGRID-LINES -->

                        </table><!-- /TABLE -->
                    </div>
                </div>
            </div><!-- /DIV-LIST -->

        </div><!--/MAIN CONTAINER -->

        <!-- CORE JAVASCRIPT LYBRARIES -->
        <script type="text/javascript" src="assets/core/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="assets/core/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
        <!-- /CORE JAVASCRIPT LYBRARIES -->
    </body>
</html>