package com.umrwhk.patients.dto;

/**
 * Created by umrwhk(umrwhk@gmail.com)
 */
public class ResponseData<T> {
    private MetaData meta;
    private T data;

    public ResponseData(MetaData meta, T data) {
        this.meta = meta;
        this.data = data;
    }

    public MetaData getMeta() {
        return meta;
    }

    public void setMeta(MetaData meta) {
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
