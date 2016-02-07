package com.yog.fw.core.utils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Criteria implements Serializable {
    private static final long serialVersionUID = -5451358360993226214L;
    
    public static enum Sort {ASC, DESC}
    
    private String criteria;
    private List<Object> paramList;
    private String sortCol;
    private Sort sortDir;
    private int startFrom;
    private int rows;
    private Map<String, Object> paramMap;
    
    public Criteria() {
        criteria = "";
        sortCol = "m.id";
        sortDir = Sort.ASC;
        startFrom = 0;
        rows = 0;
    }
    
    public Criteria(String criteria) {
        this();
        this.criteria = criteria;
    }
    
    public Criteria(String criteria, List<Object> paramList) {
        this();
        this.criteria = criteria;
        this.paramList = paramList;
    }
    
    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }
    
    public String getCriteria() {
        return criteria;
    }
    
    public void setParamList(List<Object> paramList) {
        this.paramList = paramList;
    }
    
    public List<Object> getParamList() {
        return paramList;
    }
    
    public String getSortCol() {
        return sortCol;
    }
    
    public void setSortCol(String sortCol) {
        this.sortCol = sortCol;
    }
    
    public Sort getSortDir() {
        return sortDir;
    }
    
    public void setSortDir(Sort sortDir) {
        this.sortDir = sortDir;
    }
    
    public int getStartFrom() {
        return startFrom;
    }
    
    public void setStartFrom(int startFrom) {
        this.startFrom = startFrom;
    }
    
    public int getRows() {
        return rows;
    }
    
    public void setRows(int rows) {
        this.rows = rows;
    }
    
    public Map<String, Object> getParamMap() {
        return paramMap;
    }
    
    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }
    
    @Override
    public String toString() {
        return "Criteria [criteria=" + criteria + ", paramList=" + paramList
                + ", sortCol=" + sortCol + ", sortDir=" + sortDir
                + ", startFrom=" + startFrom + ", rows=" + rows + "]";
    }
}
