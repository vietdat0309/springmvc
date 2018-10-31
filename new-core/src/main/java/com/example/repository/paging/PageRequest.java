package com.example.repository.paging;

public class PageRequest implements Pageable {

    private Integer page;
    private Integer maxPageItems;

    public PageRequest(Integer page, Integer maxPageItems){
        this.page = page;
        this.maxPageItems = maxPageItems;
    }

    @Override
    public Integer getOffset() {
        return (this.page - 1) * this.maxPageItems;
    }

    @Override
    public Integer getPageSize() {
        return maxPageItems;
    }

    @Override
    public Integer getPageNumber() {
        return page;
    }
}
