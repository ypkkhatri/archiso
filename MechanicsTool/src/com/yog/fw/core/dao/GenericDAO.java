package com.bnv.ogt.models.dao.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.sql.DataSource;

import org.eclipse.persistence.jpa.JpaHelper;

public abstract class GenericDAO<T> {
//    private final static String UNIT_NAME = "OGT_UNIT";
    
    @PersistenceContext
    private EntityManager em;
    
    @Resource(name = "jdbc/Ogtdb")
    protected DataSource dataSource;
 
    private Class<T> entityClass;
 
    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
 
    public void save(T entity) {
        em.persist(entity);
        clearCache();
    }
 
    public void delete(Object id, Class<T> classe) {
        T entityToBeRemoved = em.getReference(classe, id);
 
        em.remove(entityToBeRemoved);
        clearCache();
    }
 
    public T update(T entity) {
        return em.merge(entity);
    }
 
    public T find(long entityID) {
        return em.find(entityClass, entityID);
    }
    
    // this method used for insert, update and delete query  
    protected int executeIUD(String namedQuery, Map<String, Object> parameters) {
        int result = 0;
        
        try {
            Query query = em.createNamedQuery(namedQuery);
         
            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }
            result = query.executeUpdate();
 
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }
 
        return result;
    }
 
    // Using the unchecked because JPA does not have a
    // em.getCriteriaBuilder().createQuery()<T> method
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }
 
    // Using the unchecked because JPA does not have a
    // ery.getSingleResult()<T> method
    @SuppressWarnings("unchecked")
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
        T result = null;
 
        try {
            Query query = em.createNamedQuery(namedQuery);
 
            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }
 
            result = (T) query.getSingleResult();
 
        } catch (NoResultException e) {
            System.out.println("No record found");
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }
 
        return result;
    }
 
 // Using the unchecked because JPA does not have a
    // ery.getSingleResult()<T> method
    @SuppressWarnings("unchecked")
    protected List<T> findResult(String namedQuery, Map<String, Object> parameters) {
        List<T> result = null;
 
        try {
            Query query = em.createNamedQuery(namedQuery);
 
            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }
 
            result = query.getResultList();
 
        } catch (NoResultException e) {
            System.out.println("No record found");
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }
 
        return result;
    }
    
 // Using the unchecked because JPA does not have a
    // ery.getSingleResult()<T> method
    @SuppressWarnings("unchecked")
    protected List<T> findResultByPQL(String jpql) {
        List<T> result = null;
 
        try {
            Query query = em.createQuery(jpql);
 
            result = query.getResultList();
 
        } catch (NoResultException e) {
            System.out.println("No record found");
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }
 
        return result;
    }
    
    /**
     * jpql, Not named query
     */
    protected List<Object[]> findResultByPQLArray(String jpql, Map<String, Object> parameters) {
        List<Object[]> result = null;
 
        try {
            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            
            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }

            result = query.getResultList();
 
        } catch (NoResultException e) {
            System.out.println("No record found");
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }
 
        return result;
    }
    
    // Using the unchecked because JPA does not have a
    // ery.findResultByRange()<T> method
    @SuppressWarnings("unchecked")
    protected List<T> findResultByRange(String namedQuery, Map<String, Object> parameters, int firstSize, int maxSize) {
        List<T> result = null;
 
        try {
            Query query = em.createNamedQuery(namedQuery);
            query.setFirstResult(firstSize);
            query.setMaxResults(maxSize);
 
            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }
 
            result = query.getResultList();
 
        } catch (NoResultException e) {
            System.out.println("No record found");
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }
 
        return result;
    }
 
    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
 
        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
    
    protected void clearCache() {
        JpaHelper.getEntityManager(em).getServerSession().getIdentityMapAccessor().invalidateAll();
    }
    
    protected DataSource getDataSource() {
        return dataSource;
    }
}
