package com.example.cbsdlib.nets.example.bean;

/**
 * Author:Ariana Wong
 * Date: 2017-12-18
 * Desctiption:
 */

public class UserRequestBean extends BaseReqBean{

    /**
     * fieldName : 1121
     * fieldValue : fieldValue
     * sort : 1
     */

    private String fieldName;
    private String fieldValue;
    private String sort;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
