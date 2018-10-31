package com.example.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbstractDTO<T> implements Serializable {

    private static final long serialVersionUID = 7213600440729202783L;

    private Long id;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
    private int totalPages = 0;
    private int maxPageItems = 2;
    private int page = 1;
    private List<T> listResult = new ArrayList<>();
    private int totalItems = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) this.getTotalItems() / this.getMaxPageItems());
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getMaxPageItems() {
        return maxPageItems;
    }

    public void setMaxPageItems(int maxPageItems) {
        this.maxPageItems = maxPageItems;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}
