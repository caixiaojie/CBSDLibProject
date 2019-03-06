package com.yjhs.cbsdlib.nets.example.bean;

import java.util.List;

public class CollectListBean {

    /**
     * iTotalpage : 1
     * iTotalrecords : 1
     * collection : [{"strinforid":"1","strtitle":"迈凯伦","strbrandid":"1","strcarmodelid":"1","strcarspecid":"1","strcolumnid":"1","strbrandtypemodel":"奥迪-A6-2.0","strimage":"url/1.jpg","strcolumnname":"打折促销","strstate":"1","strusername":"zz","struserinfoid":"1","ihitcount":2,"iforwarding":0,"icollectiontimes":0,"strinfo":"sd","strcreatetime":"sad","iisdelete":0,"strdeletetime":"2018-05-16 17:03:19","strupdatetime":"2018-05-21 16:08:28","strremark":"","irank":2}]
     * strImgRootPath : http://linux.fushoukeji.com:88/picpath/share_ad/
     */

    private int iTotalpage;
    private int iTotalrecords;
    private String strImgRootPath;
    private List<CollectionBean> collection;

    public int getITotalpage() {
        return iTotalpage;
    }

    public void setITotalpage(int iTotalpage) {
        this.iTotalpage = iTotalpage;
    }

    public int getITotalrecords() {
        return iTotalrecords;
    }

    public void setITotalrecords(int iTotalrecords) {
        this.iTotalrecords = iTotalrecords;
    }

    public String getStrImgRootPath() {
        return strImgRootPath;
    }

    public void setStrImgRootPath(String strImgRootPath) {
        this.strImgRootPath = strImgRootPath;
    }

    public List<CollectionBean> getCollection() {
        return collection;
    }

    public void setCollection(List<CollectionBean> collection) {
        this.collection = collection;
    }

    public static class CollectionBean {
        /**
         * strinforid : 1
         * strtitle : 迈凯伦
         * strbrandid : 1
         * strcarmodelid : 1
         * strcarspecid : 1
         * strcolumnid : 1
         * strbrandtypemodel : 奥迪-A6-2.0
         * strimage : url/1.jpg
         * strcolumnname : 打折促销
         * strstate : 1
         * strusername : zz
         * struserinfoid : 1
         * ihitcount : 2
         * iforwarding : 0
         * icollectiontimes : 0
         * strinfo : sd
         * strcreatetime : sad
         * iisdelete : 0
         * strdeletetime : 2018-05-16 17:03:19
         * strupdatetime : 2018-05-21 16:08:28
         * strremark :
         * irank : 2
         */

        private String strinforid;
        private String strtitle;
        private String strbrandid;
        private String strcarmodelid;
        private String strcarspecid;
        private String strcolumnid;
        private String strbrandtypemodel;
        private String strimage;
        private String strcolumnname;
        private String strstate;
        private String strusername;
        private String struserinfoid;
        private int ihitcount;
        private int iforwarding;
        private int icollectiontimes;
        private String strinfo;
        private String strcreatetime;
        private int iisdelete;
        private String strdeletetime;
        private String strupdatetime;
        private String strremark;
        private int irank;

        public String getStrinforid() {
            return strinforid;
        }

        public void setStrinforid(String strinforid) {
            this.strinforid = strinforid;
        }

        public String getStrtitle() {
            return strtitle;
        }

        public void setStrtitle(String strtitle) {
            this.strtitle = strtitle;
        }

        public String getStrbrandid() {
            return strbrandid;
        }

        public void setStrbrandid(String strbrandid) {
            this.strbrandid = strbrandid;
        }

        public String getStrcarmodelid() {
            return strcarmodelid;
        }

        public void setStrcarmodelid(String strcarmodelid) {
            this.strcarmodelid = strcarmodelid;
        }

        public String getStrcarspecid() {
            return strcarspecid;
        }

        public void setStrcarspecid(String strcarspecid) {
            this.strcarspecid = strcarspecid;
        }

        public String getStrcolumnid() {
            return strcolumnid;
        }

        public void setStrcolumnid(String strcolumnid) {
            this.strcolumnid = strcolumnid;
        }

        public String getStrbrandtypemodel() {
            return strbrandtypemodel;
        }

        public void setStrbrandtypemodel(String strbrandtypemodel) {
            this.strbrandtypemodel = strbrandtypemodel;
        }

        public String getStrimage() {
            return strimage;
        }

        public void setStrimage(String strimage) {
            this.strimage = strimage;
        }

        public String getStrcolumnname() {
            return strcolumnname;
        }

        public void setStrcolumnname(String strcolumnname) {
            this.strcolumnname = strcolumnname;
        }

        public String getStrstate() {
            return strstate;
        }

        public void setStrstate(String strstate) {
            this.strstate = strstate;
        }

        public String getStrusername() {
            return strusername;
        }

        public void setStrusername(String strusername) {
            this.strusername = strusername;
        }

        public String getStruserinfoid() {
            return struserinfoid;
        }

        public void setStruserinfoid(String struserinfoid) {
            this.struserinfoid = struserinfoid;
        }

        public int getIhitcount() {
            return ihitcount;
        }

        public void setIhitcount(int ihitcount) {
            this.ihitcount = ihitcount;
        }

        public int getIforwarding() {
            return iforwarding;
        }

        public void setIforwarding(int iforwarding) {
            this.iforwarding = iforwarding;
        }

        public int getIcollectiontimes() {
            return icollectiontimes;
        }

        public void setIcollectiontimes(int icollectiontimes) {
            this.icollectiontimes = icollectiontimes;
        }

        public String getStrinfo() {
            return strinfo;
        }

        public void setStrinfo(String strinfo) {
            this.strinfo = strinfo;
        }

        public String getStrcreatetime() {
            return strcreatetime;
        }

        public void setStrcreatetime(String strcreatetime) {
            this.strcreatetime = strcreatetime;
        }

        public int getIisdelete() {
            return iisdelete;
        }

        public void setIisdelete(int iisdelete) {
            this.iisdelete = iisdelete;
        }

        public String getStrdeletetime() {
            return strdeletetime;
        }

        public void setStrdeletetime(String strdeletetime) {
            this.strdeletetime = strdeletetime;
        }

        public String getStrupdatetime() {
            return strupdatetime;
        }

        public void setStrupdatetime(String strupdatetime) {
            this.strupdatetime = strupdatetime;
        }

        public String getStrremark() {
            return strremark;
        }

        public void setStrremark(String strremark) {
            this.strremark = strremark;
        }

        public int getIrank() {
            return irank;
        }

        public void setIrank(int irank) {
            this.irank = irank;
        }
    }
}
