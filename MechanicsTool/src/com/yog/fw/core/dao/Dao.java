package com.yog.fw.core.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yog.fw.core.utils.Criteria;
import com.yog.mt.models.BaseModel;

/**
 * @author Yougeshwar
 * 
 * */

@Repository
@Transactional
public class Dao implements IDao, java.io.Serializable {

	private static final long serialVersionUID = 8997280413727247373L;

    @Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void clear() {
		getSession().clear();
	}

	@Override
	@Transactional
	public void save(BaseModel model) {
		getSession().persist(model);
	}

	@Override
	public void refresh(BaseModel model) {
		getSession().refresh(model);
	}

	@Override
	@Transactional
	public void delete(BaseModel model) {
		getSession().delete(model);
	}

	@Override
	@Transactional
	public <T extends BaseModel> int delete(Class<T> modelClass,
			Criteria criteria) {
		String jpql = "DELETE FROM " + modelClass.getSimpleName() + " m ";
		Query query = getQuery(modelClass, jpql, criteria, true);
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T extends BaseModel> T getSingleModel(Class<T> modelClass,
			Criteria criteria) throws NoResultException {
		String jpql = "SELECT m FROM " + modelClass.getSimpleName() + " m ";

		Query query = getQuery(modelClass, jpql, criteria, true);
		query.setMaxResults(1);

		return (T) (query.list().isEmpty() ? null : query.list().get(0));
	}

	@Override
	@Transactional
	public <T extends BaseModel> Object getSingleValue(Class<T> modelClass,
			String field, Criteria criteria) throws NoResultException {
		String jpql = "SELECT " + field + " FROM " + modelClass.getSimpleName() + " m ";

		Query query = getQuery(modelClass, jpql, criteria, true);
		query.setMaxResults(1);

		return query.list().isEmpty() ? null : query.list().get(0);//query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T extends BaseModel> List<T> getModelList(
			Class<? extends T> modelClass, Criteria criteria)
			throws NoResultException {
		String jpql = "SELECT m FROM " + modelClass.getSimpleName() + " m ";

		Query query = getQuery(modelClass, jpql, criteria, false);
		return query.list();
	}

	@Override
	@Transactional
	public <T extends BaseModel> List<T> getModelList(
			Class<? extends T> modelClass) throws NoResultException {
		return getModelList(modelClass, null);
	}

	@Override
	@Transactional
	public List<Object[]> getQueryList(String jpql, Criteria criteria)
			throws NoResultException {
//		TypedQuery<Object[]> query = getSession().createQuery(jpql, Object[].class);
//
//		if (criteria.getParamList() != null) {
//			int i = 0;
//			for (Object obj : criteria.getParamList()) {
//				query.setParameter(++i, obj);
//			}
//		} else if (criteria.getParamMap() != null) {
//			for (Map.Entry<String, Object> entry : criteria.getParamMap()
//					.entrySet()) {
//				query.setParameter(entry.getKey(), entry.getValue());
//			}
//		}
//
//		if (criteria.getStartFrom() > 0 && criteria.getRows() > 0) {
//			query.setFirstResult(criteria.getStartFrom());
//			query.setMaxResults(criteria.getRows());
//		}

		return null;
	}

	private Query getQuery(Class<? extends BaseModel> modelClass, String jpql,
			Criteria crt, boolean isSingle) {

		Criteria criteria = crt;
		if (criteria == null)
			criteria = new Criteria();

		jpql = getJpql(modelClass, jpql, criteria, isSingle);
		Query query = getSession().createQuery(jpql);

		if (criteria.getParamList() != null) {
			int i = 0;
			for (Object obj : criteria.getParamList()) {
				query.setParameter(++i, obj);
			}
		} else if (criteria.getParamMap() != null) {
			for (Map.Entry<String, Object> entry : criteria.getParamMap()
					.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}

		if (!isSingle && criteria.getRows() > 0) {
			query.setFirstResult(criteria.getStartFrom());
			query.setMaxResults(criteria.getRows());
		}

		return query;
	}

	private String getJpql(Class<? extends BaseModel> modelClass, String jpql,
			Criteria crt, boolean isSingle) {

		if (!StringUtils.isEmpty(crt.getCriteria()))
			jpql += " WHERE " + crt.getCriteria();

		if (!isSingle && StringUtils.isEmpty(crt.getSortCol())) {
			jpql += " ORDER BY m.id ASC";
		} else if (!isSingle && !StringUtils.isEmpty(crt.getSortCol())) {
			jpql += " ORDER BY ";
			String sortCols = crt.getSortCol();
			for (String sortCol : StringUtils.split(sortCols, ',')) {
				if (sortCol.indexOf('.') == -1)
					jpql += "m.";
				jpql += sortCol + ",";
			}
			jpql = StringUtils.chop(jpql) + " " + crt.getSortDir();
		}
		return jpql;
	}

}
