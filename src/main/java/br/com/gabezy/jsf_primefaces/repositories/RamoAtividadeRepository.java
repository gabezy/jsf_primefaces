package br.com.gabezy.jsf_primefaces.repositories;

import br.com.gabezy.jsf_primefaces.domain.model.RamoAtividade;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class RamoAtividadeRepository extends GenericRepository<RamoAtividade, Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    public RamoAtividadeRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<RamoAtividade> getEntityClass() {
        return RamoAtividade.class;
    }

    public List<RamoAtividade> findAllByDescricao(String descricao) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RamoAtividade> cq = cb.createQuery(RamoAtividade.class);
        Root<RamoAtividade> root = cq.from(RamoAtividade.class);
        cq.select(root).where(cb.like(root.get("descricao"), "%" + descricao + "%"));
        return entityManager.createQuery(cq).getResultList();
    }
}
