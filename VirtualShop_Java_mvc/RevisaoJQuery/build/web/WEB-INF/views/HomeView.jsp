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
        <!-- menu superior -->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="mvcmenu?do=lstmodel">VirtualShop</a>
              </div>
              <ul class="nav navbar-nav">
                <li><a href="mvccustomer?do=lstmodel">Clientes</a></li>
                <li><a href="mvcproduto?do=lstmodel">Produtos</a></li>
                <li><a href="mvctransportador?do=lstmodel">Transportadoras</a></li>
                <li><a href="#">Pedidos</a></li>
              </ul>
            </div>
        </nav>
         <!-- menu superior -->
         <div class="col-md-6 panel  panel-default"> 
             <div class="row panel-heading">
                 Orientações
             </div>
             <div class="panel-body">
            <p>VirtualShop é um painel de controle para negócios genéricos, onde existam clientes, pedidos, produtos, e envios via empresas.
                Esse sistema serve principalmente para lojas virtuais. Em caso de dúvidas contate o administrador do sistema <a href="https://github.com/AndersonMerten">clicando aqui!</a></p>
            <p>Caso contrario você pode navegar nos menus acima, cadastrar, visualizar, editar ou deletar os itens. Todas as suas ações serão irreversiveis, portanto tome cuidado!</p>
         </div>   
        </div><!-- /MAIN CONTAINER --> 

        <!-- JQUERY -->                    
        <script src="assets/js/jquery.min.js"></script>
        <!-- /JQUERY --> 

        <script type="text/javascript">

            $(document).ready(function () {

                $("#comboMenu").change(
                        function () {
                            //alert($("#comboMenu").val());                        
                            $(location).attr('href', $("#comboMenu").val());
                        }
                );

            });

        </script>

    </body>
</html>
