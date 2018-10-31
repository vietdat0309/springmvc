package com.example.repository.paging;

public interface Pageable {
    Integer getOffset();
    Integer getPageSize();
    Integer getPageNumber();
}
