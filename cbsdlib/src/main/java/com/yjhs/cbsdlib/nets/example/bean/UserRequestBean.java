package com.yjhs.cbsdlib.nets.example.bean;

import java.util.List;

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

    private String aa;
    private String AA;
    private List<String> strs;
//    private String [] strs ;

    private String sort;


    public List<String> getStrs() {
        return strs;
    }

    public void setStrs(List<String> strs) {
        this.strs = strs;
    }


//    public String[] getStrs() {
//        return strs;
//    }
//
//    public void setStrs(String[] strs) {
//        this.strs = strs;
//    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getAA() {
        return AA;
    }

    public void setAA(String AA) {
        this.AA = AA;
    }
}
