package com.yjhs.cbsdlib.nets.example.bean;

/**
 * Author:Ariana Wong
 * Date: 2017-12-18
 * Desctiption:
 */

public class UserRespBean {

    /**
     * cUser : {"id":"11","userName":"123456","userPassword":"*******","nickName":"测试用户","sex":null,"unitId":null,"userType":0,"userEmil":null,"userPhone":null,"userFax":null,"userMovePhone":null,"istate":0,"iDelete":0,"createTime":null,"updateTime":null,"deleteTime":null}
     * session_id : 366dca6f3d204caf9f04ba07fa8e4c9b
     * strImgRootPath : http://linux.fushoukeji.com:88/picpath/ulabor/
     */

    private CUserBean cUser;
    private String session_id;
    private String strImgRootPath;

    public CUserBean getCUser() {
        return cUser;
    }

    public void setCUser(CUserBean cUser) {
        this.cUser = cUser;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getStrImgRootPath() {
        return strImgRootPath;
    }

    public void setStrImgRootPath(String strImgRootPath) {
        this.strImgRootPath = strImgRootPath;
    }

    public static class CUserBean {
        /**
         * id : 11
         * userName : 123456
         * userPassword : *******
         * nickName : 测试用户
         * sex : null
         * unitId : null
         * userType : 0
         * userEmil : null
         * userPhone : null
         * userFax : null
         * userMovePhone : null
         * istate : 0
         * iDelete : 0
         * createTime : null
         * updateTime : null
         * deleteTime : null
         */

        private String id;
        private String userName;
        private String userPassword;
        private String nickName;
        private Object sex;
        private Object unitId;
        private int userType;
        private Object userEmil;
        private Object userPhone;
        private Object userFax;
        private Object userMovePhone;
        private int istate;
        private int iDelete;
        private Object createTime;
        private Object updateTime;
        private Object deleteTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public Object getSex() {
            return sex;
        }

        public void setSex(Object sex) {
            this.sex = sex;
        }

        public Object getUnitId() {
            return unitId;
        }

        public void setUnitId(Object unitId) {
            this.unitId = unitId;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public Object getUserEmil() {
            return userEmil;
        }

        public void setUserEmil(Object userEmil) {
            this.userEmil = userEmil;
        }

        public Object getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(Object userPhone) {
            this.userPhone = userPhone;
        }

        public Object getUserFax() {
            return userFax;
        }

        public void setUserFax(Object userFax) {
            this.userFax = userFax;
        }

        public Object getUserMovePhone() {
            return userMovePhone;
        }

        public void setUserMovePhone(Object userMovePhone) {
            this.userMovePhone = userMovePhone;
        }

        public int getIstate() {
            return istate;
        }

        public void setIstate(int istate) {
            this.istate = istate;
        }

        public int getIDelete() {
            return iDelete;
        }

        public void setIDelete(int iDelete) {
            this.iDelete = iDelete;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getDeleteTime() {
            return deleteTime;
        }

        public void setDeleteTime(Object deleteTime) {
            this.deleteTime = deleteTime;
        }
    }
}
