package com.example.cbsdlibproject;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class PhonePwdLoginCommitVo extends BaseReqBean{
    private String strRegionNumber;
    private String strPassword;
    private String strUserPhone;

    public String getStrRegionNumber() {
        return strRegionNumber;
    }

    public void setStrRegionNumber(String strRegionNumber) {
        this.strRegionNumber = strRegionNumber;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public String getStrUserPhone() {
        return strUserPhone;
    }

    public void setStrUserPhone(String strUserPhone) {
        this.strUserPhone = strUserPhone;
    }

}
