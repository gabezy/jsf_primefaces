package br.com.gabezy.jsf_primefaces.repositories;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class GenericRepository<T, I> {

    protected final EntityManager entityManager;

    protected GenericRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected abstract Class<T> getEntityClass();

    public T findById(I id) {
        return entityManager.find(getEntityClass(), id);
    }

    public List<T> findAll() {
        TypedQuery<T> query = entityManager.createQuery("FROM " + getEntityClass().getSimpleName(), getEntityClass());
        return query.getResultList();
    }

    public T save(T entity) {
        return entityManager.merge(entity);
    }

    public void remove(T entity) {
        T managed = entity;
        if (!entityManager.contains(entity)) {
            managed = entityManager.merge(entity);
        }
        entityManager.remove(managed);
    }

}
