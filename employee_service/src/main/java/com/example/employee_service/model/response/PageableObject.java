package com.example.employee_service.model.response;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PageableObject<T> {

    private List<T> content;
    private long totalPages;
    private int currentPage;

    public PageableObject(Page<T> page) {
        this.content = page.getContent();
        this.totalPages = page.getTotalPages();
        this.currentPage = page.getNumber();
    }
}