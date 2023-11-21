package com.umrwhk.patients.dto;

/**
 * Created by umrwhk(umrwhk@gmail.com)
 */
public class PageableResponse<T> {

    private PageData page;
    private T content;

    public PageableResponse() {
    }

    public PageableResponse(PageData page, T content) {
        this.page = page;
        this.content = content;
    }

    public PageData getPage() {
        return page;
    }

    public void setPage(PageData page) {
        this.page = page;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
