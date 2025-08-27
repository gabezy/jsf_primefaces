package br.com.gabezy.jsf_primefaces.repositories;

import br.com.gabezy.jsf_primefaces.domain.model.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class EmpresaRepository extends GenericRepository<Empresa, Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    protected Class<Empresa> getEntityClass() {
        return Empresa.class;
    }

    public EmpresaRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Empresa> findAllByNomeFantasia(String nome) {
        TypedQuery<Empresa> query = entityManager.createQuery("FROM Empresa WHERE nomeFantasia LIKE :nomeFantasia", Empresa.class);
        query.setParameter("nomeFantasia", "%" + nome + "%");
        return query.getResultList();
    }

}
