package java.dao;



import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.helpers.EntityManagerHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao<T> {

    final private EntityManager em;

    public Dao(EntityManager em) {
        this.em = em;
    }

    public T create(T entity) {
        EntityManagerHelper.beginTransaction();
        em.persist(entity);
        EntityManagerHelper.commit();
        return entity;
    }

    public List<T> list(Class<T> clazz, int size, int skip){


        CriteriaBuilder criteriaBuilder=em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery= criteriaBuilder.createQuery(clazz);
        Root<T> from=criteriaQuery.from(clazz);

        CriteriaQuery<T> select=criteriaQuery.select(from);
        TypedQuery<T> typedQuery=em.createQuery(select);
        typedQuery.setFirstResult(skip);
        typedQuery.setMaxResults(size);
        return typedQuery.getResultList();

    }

    public T read(Class<T> clazz, Object pk) {

        T entity = em.find(clazz, pk);

        return entity;
    }

    public T readGraph(Class<T> clazz, Object pk, String graph) {

        EntityGraph entityGraph = em.getEntityGraph(graph);
        Map<String ,Object> properties= new HashMap<>();
        properties.put(EntityManagerHelper.FETCH_GRAPH,entityGraph);
        T entity = em.find(clazz, pk, properties);

        return entity;
    }

    public T update(T entity) {
        EntityManagerHelper.beginTransaction();

        entity = em.merge(entity);

        EntityManagerHelper.commit();
        return entity;
    }

    public void delete(T entity) {
        EntityManagerHelper.beginTransaction();

        entity = em.merge(entity);
        em.remove(entity);

        EntityManagerHelper.commit();
    }


}
