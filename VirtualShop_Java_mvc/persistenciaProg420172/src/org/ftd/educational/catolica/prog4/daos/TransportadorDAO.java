package org.ftd.educational.catolica.prog4.daos;

import javax.persistence.EntityManagerFactory;

public class TransportadorDAO extends TransportadorJpaController {

    public TransportadorDAO(EntityManagerFactory emf) {
        super(emf);
    }
    
}
