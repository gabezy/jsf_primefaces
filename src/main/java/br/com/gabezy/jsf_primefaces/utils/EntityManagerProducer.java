package br.com.gabezy.jsf_primefaces.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

    private final EntityManagerFactory factory;

    public EntityManagerProducer() {
        this.factory = Persistence.createEntityManagerFactory("jsf-primefaces");
    }

    @Produces
    @RequestScoped
    public EntityManager createEntityManager() {
        return factory.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager em) {
        em.close();
    }

}
