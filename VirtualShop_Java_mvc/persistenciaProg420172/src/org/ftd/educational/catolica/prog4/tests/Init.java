package org.ftd.educational.catolica.prog4.tests;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.ftd.educational.catolica.prog4.daos.ClienteDAO;
import org.ftd.educational.catolica.prog4.daos.TransportadorDAO;
import org.ftd.educational.catolica.prog4.daos.ProdutoDAO;
import org.ftd.educational.catolica.prog4.daos.TipoClienteDAO;
import org.ftd.educational.catolica.prog4.daos.UserDAO;
import org.ftd.educational.catolica.prog4.entities.Cliente;
import org.ftd.educational.catolica.prog4.entities.Produto;
import org.ftd.educational.catolica.prog4.entities.TipoCliente;
import org.ftd.educational.catolica.prog4.entities.User;

public class Init {

    private static final String PERSISTENCE_UNIT_NAME = "persistenciaPU";

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        TransportadorDAO dao = new TransportadorDAO(factory);
       
        userAuthenticateTest("senna@gmail.com", "prostviadinho@soutrimasnaoroubei");
        userAuthenticateTest("prost3@gmail.com", "sennaviadinho@soutetracampeao"); 
        
        findAllUser();
        System.out.println(listarCliente());  
        createDefaultProduto();
        
        
//                Fornecedor o = new Fornecedor();
//                o.setName("WEG Motores Eletricos S.A.");
//                o.setCnpj("123.123.123/0001");
//                dao.create(o);        
//                System.out.println(o);
//
//                Fornecedor o2 = new Fornecedor();
//                o2.setName("SIEMENS S.A.");
//                o2.setCnpj("321.123.321/0001");
//                dao.create(o2);        
//                System.out.println(o2);                
                
        //        Fornecedor o = dao.findFornecedor(251L);
        //        System.out.println(o);        
        //        o = dao.findFornecedor(259L);
        //        if (o != null) {
        //            System.out.println(o);
        //        } else {
        //            System.out.println("Não encontrei o Fornecedor 259");
        //        }

//        try {
//            Fornecedor o = dao.findFornecedor(251L);
//            if (o != null) {
//                System.out.println(o);
//            }
//            dao.destroy(251L);
//        } catch (NonexistentEntityException e) {
//            System.out.println("Não encontrei o Fornecedor 251");
//        }

        
//          List<Fornecedor> lst = dao.findFornecedorEntities();
//          for (Fornecedor fornecedor:lst) {
//              System.out.println(fornecedor);
//          }
          
        
        

    }

    private static void userAuthenticateTest(String login, String passwd) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO dao = new UserDAO(factory);

        try {
            User user = dao.findUser(login, passwd);
            System.out.println("Autenticado user: " + user);
        } catch (Exception e) {
            System.out.println("Autenticação falhou p/ "
                    + login + " & " + passwd);
        }

    }

    private static void createDefaultCliente() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ClienteDAO clienteDAO = new ClienteDAO(factory);
        String[][] lst
                = {
                    {"Cliente A", "1", "123.123.123-40"},
                    {"Cliente B", "2", "123.123.123-41"},
                    {"Cliente C", "3", "123.123.123-42"},
                    {"Cliente D", "2", "123.123.123-43"},
                    {"Cliente E", "4", "123.123.123-44"}
                };

        for (int i = 0; i < lst.length; i++) {
            Cliente o = new Cliente();
            o.setName(lst[i][0]);
            o.setTipoClienteid(Long.parseLong(lst[i][1]));
            o.setCpf(lst[i][2]);
            clienteDAO.create(o);
        }

    }
    private static void createDefaultProduto() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ProdutoDAO produtoDAO = new ProdutoDAO(factory);
        String[][] lst
                = {
                    {"123", "Goiaba", "Ruim demais", "2"},
                    {"124", "Maça", "Ruim", "5"},
                    {"125", "Nozes", "caro", "200"}
                };

        for (int i = 0; i < lst.length; i++) {
            Produto o = new Produto();
            o.setId(Long.parseLong(lst[i][0]));
            o.setName(lst[i][1]);
            o.setDescricao(lst[i][2]);
            o.setPrice(Long.parseLong(lst[i][3]));
            produtoDAO.create(o);
        }

    }

    private static String listarCliente() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ProdutoDAO dao = new ProdutoDAO(factory);
        StringBuilder sb = new StringBuilder();
        List<Produto> lst = dao.findProdutoEntities();

        for (Produto o : lst) {
            sb.append(o.getId());
            sb.append(" - ");
            sb.append(o.getName());
            sb.append(" - ");
            sb.append(o.getDescricao());
            sb.append(" (");
            sb.append(o.getPrice());
            sb.append(")\n");
        }

        return sb.toString();
    }

    private static void createDefaultTipoCliente() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        TipoClienteDAO dao = new TipoClienteDAO(factory);
        String[] lstNomes = {"Vip", "Normal", "Admin", "A definir"};

        for (int i = 0; i < lstNomes.length; i++) {
            TipoCliente o = new TipoCliente();
            o.setName(lstNomes[i]);
            dao.create(o);
        }

    }

    private static String listarTiposDeCliente() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        TipoClienteDAO dao = new TipoClienteDAO(factory);
        StringBuilder sb = new StringBuilder();
        List<TipoCliente> lst = dao.findTipoClienteEntities();

        for (TipoCliente o : lst) {
            sb.append(o.getId());
            sb.append(" - ");
            sb.append(o.getName());
            sb.append("\n");
        }

        return sb.toString();
    }

    private static void findAllUser() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO dao = new UserDAO(factory);
        List<User> lst = dao.findUserEntities();
        for (User o : lst) {
            System.out.println(o);
        }

    }

}
