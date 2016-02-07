package com.yog.mt.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel implements Serializable {
    
    private static final long serialVersionUID = -7107531516035953287L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "XID", unique = true, nullable = false)
    protected Long id;
        
    @Column(name = "CREATED_BY")
    private String createdBy;
    
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    
    @Column(name = "UPDATION_DATE")
    private Date updationDate;
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}

	@Override
    public boolean equals(Object other) {
        return (other instanceof BaseModel) && (id != null)
            ? id.equals(((BaseModel) other).id)
            : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null)
            ? (this.getClass().hashCode() + id.hashCode())
            : super.hashCode();
    }
    
}
