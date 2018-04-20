/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftd.builderforce.ppm.web.cmds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftd.builderforce.ppm.web.adapters.PersistenceFactory;
import org.ftd.educational.catolica.prog4.daos.ProdutoDAO;
import org.ftd.educational.catolica.prog4.entities.Produto;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ProdutoMvcServlet", urlPatterns = {"/mvcproduto"}, initParams = {
    @WebInitParam(name = "do", value = "")})

public class ProdutoMvcServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = this.readParameter(request, "do");
        String nextAction;
        switch (action) {
            case "lstmodel":
                nextAction = buildLstModel(request, response);
                break;
            case "addmodel":
                nextAction = buildAddModel(request, response);
                break;
            case "updmodel":
                nextAction = buildUpdModel(request, response);
                break;
            case "readmodel":
                nextAction = buildReadModel(request, response);
                break;
            case "add":
                nextAction = doAddNew(request, response);
                break;
            case "upd":
                nextAction = doUpdate(request, response);
                break;
            case "del":
                nextAction = doRemove(request, response);
                break;
            default:
                request.setAttribute("msg", "Erro controller: recebi obscuro do=" + action);
                nextAction = "signin.jsp";
        }

        request.getRequestDispatcher(nextAction).forward(request, response);
    }
    private String buildLstModel(HttpServletRequest request, HttpServletResponse response) {        
        String nextAction = "/WEB-INF/views/Produto/ListProdutoView.jsp";
        request.setAttribute("applicationName","Virtual Shop");
        request.setAttribute("title","Cadastro de Produtos");
        
        request.setAttribute("userName", (String) request.getSession().getAttribute("username"));
        request.setAttribute("datasource", this.findAll());        
        request.setAttribute("showColumnId", true);        
        
        request.setAttribute("actionToAdd", "mvcproduto?do=addmodel");
        request.setAttribute("actionToUpd", "mvcproduto?do=updmodel&id=");
        request.setAttribute("actionToRead", "mvcproduto?do=readmodel&id=");
        
        return nextAction;
    }

    private String buildAddModel(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/views/Produto/CreateProdutoView.jsp";

        request.setAttribute("applicationName","Virtual Shop");
        request.setAttribute("title","Adicionando Novo Produto");
        
        request.setAttribute("controller","mvcproduto");
        request.setAttribute("do","add");
        request.setAttribute("fieldNameLabel","Nome");
        
        return nextAction;
    }

    private String buildUpdModel(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/views/Produto/UpdateProdutoView.jsp";
        String id = this.readParameter(request, "id");

        request.setAttribute("applicationName","Virtual Shop");
        request.setAttribute("title","Atualizando o Produto " + id);
        
        request.setAttribute("controller","mvcproduto");
        request.setAttribute("do","upd");
        request.setAttribute("fieldNameLabel","Nome");        
        
        final String PERSISTENCE_UNIT_NAME = "persistenciaPU";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ProdutoDAO dao = new ProdutoDAO(factory);
        
        request.setAttribute("entity",dao.findProduto(Long.parseLong(id)));
        
        
        return nextAction;
    }

    private String buildReadModel(HttpServletRequest request, HttpServletResponse response) {
         String nextAction = "/WEB-INF/views/Produto/ReadProdutoView.jsp";
        String id = this.readParameter(request, "id");

        ProdutoDAO produto = new ProdutoDAO(PersistenceFactory.getFactoryInstance());
        request.setAttribute("datasource", produto.findProduto(Long.parseLong(id)));
        return nextAction;
    }

    private String doAddNew(HttpServletRequest request, HttpServletResponse response) {
        String successNextAction = "mvcproduto?do=lstmodel";
        String failureNextAction = "mvcproduto?do=addmodel";

        final String PERSISTENCE_UNIT_NAME = "persistenciaPU";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ProdutoDAO dao = new ProdutoDAO(factory);
        Produto o = new Produto();
        
        o.setName(this.readParameter(request, "nameInput"));
        o.setDescricao(this.readParameter(request, "descricaoInput"));
        o.setPrice(Long.parseLong(this.readParameter(request, "precoInput")));
       
        
        try {
            dao.create(o);
            
            return successNextAction;
        } catch (Exception e) {
            request.setAttribute("msg", "A criação do registro falhou! Java: " + e.getMessage());
            
            return failureNextAction;
        }

    }

    private String doUpdate(HttpServletRequest request, HttpServletResponse response) {
        String id = this.readParameter(request, "id");
        
        String successNextAction = "mvcproduto?do=lstmodel";
        String failureNextAction = "mvcproduto?do=updmodel";

        final String PERSISTENCE_UNIT_NAME = "persistenciaPU";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ProdutoDAO dao = new ProdutoDAO(factory);                      
        Produto o = dao.findProduto(Long.parseLong(id));
        o.setName(this.readParameter(request, "nameInput"));
        o.setDescricao(this.readParameter(request, "descricaoInput"));
        o.setPrice(Long.parseLong(this.readParameter(request, "precoInput")));

        try {
            dao.edit(o);
            
            return successNextAction;
        } catch (Exception e) {
            request.setAttribute("msg", "A atualização falhou! Java: " + e.getMessage());
            
            return failureNextAction;
        }
    }

    private String doRemove(HttpServletRequest request, HttpServletResponse response) {
        String id = this.readParameter(request, "id");
        ProdutoDAO produto = new ProdutoDAO(PersistenceFactory.getFactoryInstance());
        request.setAttribute("datasource", produto.findProduto(Long.parseLong(id)));
        try{
            produto.destroy(Long.parseLong(id));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        String successNextAction = "mvcproduto?do=lstmodel";

        return successNextAction;
    }

    private String readParameter(HttpServletRequest req, String parameterName) {
        return readParameter(req, parameterName, "");
    }

    private String readParameter(HttpServletRequest req, String parameterName, String defaultValue) {
        String value = req.getParameter(parameterName);
        if ((value == null) || (value.equals(""))) {
            value = defaultValue;
        }

        return value;
    }

    private List<Produto> findAll() {
        final String PERSISTENCE_UNIT_NAME = "persistenciaPU";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ProdutoDAO dao = new ProdutoDAO(factory);
        
        return dao.findProdutoEntities();
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
