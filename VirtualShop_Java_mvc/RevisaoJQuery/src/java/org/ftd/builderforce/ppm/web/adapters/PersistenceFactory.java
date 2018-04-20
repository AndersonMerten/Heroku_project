/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftd.builderforce.ppm.web.adapters;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Anderson
 */
public abstract class PersistenceFactory {

    private static final String PERSISTENCE_UNIT_NAME = "persistenciaPU";

    public static String getPERSISTENCE_UNIT_NAME() {
        return PERSISTENCE_UNIT_NAME;
    }

    public static final EntityManagerFactory getFactoryInstance(){
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
}
