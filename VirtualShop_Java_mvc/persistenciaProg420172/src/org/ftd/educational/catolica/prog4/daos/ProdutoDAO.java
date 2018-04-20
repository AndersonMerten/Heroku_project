/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftd.educational.catolica.prog4.daos;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.ftd.educational.catolica.prog4.entities.Produto;

/**
 *
 * @author Anderson
 */
public class ProdutoDAO extends ProdutoJpaController {
    public ProdutoDAO(EntityManagerFactory emf) {
        super(emf);
    }
    
    public Produto findByName(String name) {
        EntityManager em = getEntityManager();
        try {
            return (Produto) em.createNamedQuery("Produto.find.by.name")
                .setParameter("name", name)
                .getSingleResult();
        } finally {
            
        }        
    }    
    
    public Produto findByCodigo(String codigo) {
        EntityManager em = getEntityManager();
        try {
            return (Produto) em.createNamedQuery("Produto.find.by.codigo")
                .setParameter("codigo", codigo)
                .getSingleResult();
        } finally {
            em.close();
        }        
    }     
    
}
