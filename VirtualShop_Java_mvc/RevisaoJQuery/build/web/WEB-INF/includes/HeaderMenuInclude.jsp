<%-- 
    Document   : HeaderMenuInclude
    Created on : 04/12/2017, 18:40:20
    Author     : ftdippold
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <div class="col-md-12">
        <h4>
            <a class="btn btn-primary btn-xs" href="mvcmenu?do=lstmodel" title="MENU PRINCIPAL">
                <span class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
                ${applicationName}
            <span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
            ${title}
        </h4>
    </div>
</div>
