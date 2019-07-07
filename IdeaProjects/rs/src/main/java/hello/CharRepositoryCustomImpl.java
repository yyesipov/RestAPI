package hello;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CharRepositoryCustomImpl implements CharRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Character> findCharByKeyword (String keyword){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Character> query = cb.createQuery(Character.class);
        Root<Character> root = query.from(Character.class);
        query.select(root).where(cb.like(root.get("name"), "%keyword%"));


         return entityManager.createQuery(query).getResultList();

    }
}
