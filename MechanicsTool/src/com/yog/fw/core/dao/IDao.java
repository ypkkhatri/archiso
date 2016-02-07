package com.yog.fw.core.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;

import com.yog.fw.core.utils.Criteria;
import com.yog.mt.models.BaseModel;

public interface IDao {
    public void clear();

    public void save(BaseModel model);

    public void refresh(BaseModel model);

    public void delete(BaseModel model);
    
    public <T extends BaseModel> int delete(Class<T> modelClass, Criteria criteria);
    
    public <T extends BaseModel> T getSingleModel(Class<T> modelClass, Criteria criteria) throws NoResultException;

    public <T extends BaseModel> Object getSingleValue(Class<T> modelClass, String field, Criteria criteria) throws NoResultException;

    public <T extends BaseModel> List<T> getModelList(Class<? extends T> modelClass, Criteria criteria) throws NoResultException;
    
    public <T extends BaseModel> List<T> getModelList(Class<? extends T> modelClass) throws NoResultException;
    
    public List<Object[]> getQueryList(String jpql, Criteria criteria) throws NoResultException;

    public Session getSession();
}
