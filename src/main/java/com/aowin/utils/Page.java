package com.aowin.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Page {

    private int currentPage;
    private int pageSize;

    public int getFirst() {
        return (currentPage - 1) * pageSize;
    }

    public int getMax() {
        return pageSize;
    }
}
