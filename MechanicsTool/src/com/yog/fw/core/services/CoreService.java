package com.yog.fw.core.services;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yog.fw.core.dao.IDao;
import com.yog.fw.core.utils.Criteria;
import com.yog.mt.models.BaseModel;

/**
 * @author Yougeshwar
 * 
 * */

@Service
@Transactional
public class CoreService implements ICoreService, java.io.Serializable {

	private static final long serialVersionUID = 8997280413727247373L;

	@Autowired
	private IDao dao;
	
	@Override
	@Transactional
	public void save(BaseModel model) {
		if (model.getId() == null) {
			model.setCreatedBy("none");
			model.setCreationDate(new Date());
		} else {
			model.setUpdatedBy("none");
			model.setUpdationDate(new Date());
		}
		dao.save(model);
	}

	@Override
	public void refresh(BaseModel model) {
		dao.refresh(model);
	}

	@Override
	@Transactional
	public void delete(BaseModel model) {
		dao.delete(model);
	}

	@Override
	@Transactional
	public <T extends BaseModel> int delete(Class<T> modelClass,
			Criteria criteria) {
		return dao.delete(modelClass, criteria);
	}

	@Override
	@Transactional
	public <T extends BaseModel> T getSingleModel(Class<T> modelClass,
			Criteria criteria) throws NoResultException {
		return dao.getSingleModel(modelClass, criteria);
	}

	@Override
	@Transactional
	public <T extends BaseModel> Object getSingleValue(Class<T> modelClass,
			String field, Criteria criteria) throws NoResultException {
		return dao.getSingleValue(modelClass, field, criteria);
	}

	@Override
	@Transactional
	public <T extends BaseModel> List<T> getModelList(
			Class<? extends T> modelClass, Criteria criteria)
			throws NoResultException {
		return dao.getModelList(modelClass, criteria);
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
		return dao.getQueryList(jpql, criteria);
	}

}
