package com.blanink.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/4/24.
 * 属性
 */

public class RelIndustryCategoryAttribute {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"id":"7275a4c694314d0e9414fc536508e6c4","isNewRecord":false,"remarks":"","category":{"id":"0c89ee5b537e4056b92d009508375f22","isNewRecord":false,"sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryIds":"","industryCategoryNames":"","attributeIds":"","parentName":"","parentId":"0"},"attribute":{"id":"db14779d29c9436db4b766a649e00a51","isNewRecord":false,"name":"尺寸","sort":30,"public":false,"parentId":"0"},"isRequired":"1","inputType":"1","hardcodeValue":"15","sort":10,"attributeSearchType":"1"},{"id":"a0dcf420f4874406abc1f5df8de74a68","isNewRecord":false,"remarks":"","category":{"id":"0c89ee5b537e4056b92d009508375f22","isNewRecord":false,"sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryIds":"","industryCategoryNames":"","attributeIds":"","parentName":"","parentId":"0"},"attribute":{"id":"292c2053b9c54bd684cc9ce2e5789df0","isNewRecord":false,"name":"颜色","sort":30,"public":false,"parentId":"0"},"isRequired":"1","inputType":"2","hardcodeValue":"黑色,白色","sort":10,"attributeSearchType":"2"},{"id":"17ef50b4687e41a4a301410279de9864","isNewRecord":false,"remarks":"","category":{"id":"eb646ffa0b1c4d93837d29e77de1d07b","isNewRecord":false,"sort":30,"categoryAttributeList":[],"attributeNames":"","attributeIds":"","parentId":"0"},"attribute":{"id":"267a9460de74443cb8d292aac1b2e0ab","isNewRecord":false,"name":"容量","sort":30,"public":false,"parentId":"0"},"isRequired":"0","inputType":"1","hardcodeValue":"","sort":10},{"id":"ff0585d06ef145508c369ad58c1f4eae","isNewRecord":false,"remarks":"","category":{"id":"a7e9f04c18134441b1703117d605f912","isNewRecord":false,"sort":30,"categoryAttributeList":[],"attributeNames":"","attributeIds":"","parentId":"0"},"attribute":{"id":"b8b0228502a344989522d603bdc15035","isNewRecord":false,"name":"品牌","sort":30,"public":false,"parentId":"0"},"isRequired":"1","inputType":"1","hardcodeValue":"","sort":10}]
     */

    private String errorCode;
    private String reason;
    private List<ResultBean> result;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 7275a4c694314d0e9414fc536508e6c4
         * isNewRecord : false
         * remarks :
         * category : {"id":"0c89ee5b537e4056b92d009508375f22","isNewRecord":false,"sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryIds":"","industryCategoryNames":"","attributeIds":"","parentName":"","parentId":"0"}
         * attribute : {"id":"db14779d29c9436db4b766a649e00a51","isNewRecord":false,"name":"尺寸","sort":30,"public":false,"parentId":"0"}
         * isRequired : 1
         * inputType : 1
         * hardcodeValue : 15
         * sort : 10
         * attributeSearchType : 1
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private CategoryBean category;
        private AttributeBean attribute;
        private String isRequired;
        private String inputType;
        private String hardcodeValue;
        private int sort;
        private String attributeSearchType;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public CategoryBean getCategory() {
            return category;
        }

        public void setCategory(CategoryBean category) {
            this.category = category;
        }

        public AttributeBean getAttribute() {
            return attribute;
        }

        public void setAttribute(AttributeBean attribute) {
            this.attribute = attribute;
        }

        public String getIsRequired() {
            return isRequired;
        }

        public void setIsRequired(String isRequired) {
            this.isRequired = isRequired;
        }

        public String getInputType() {
            return inputType;
        }

        public void setInputType(String inputType) {
            this.inputType = inputType;
        }

        public String getHardcodeValue() {
            return hardcodeValue;
        }

        public void setHardcodeValue(String hardcodeValue) {
            this.hardcodeValue = hardcodeValue;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getAttributeSearchType() {
            return attributeSearchType;
        }

        public void setAttributeSearchType(String attributeSearchType) {
            this.attributeSearchType = attributeSearchType;
        }

        public static class CategoryBean {
            /**
             * id : 0c89ee5b537e4056b92d009508375f22
             * isNewRecord : false
             * sort : 30
             * size : 0
             * categoryAttributeList : []
             * relIndustryCompanyCategoryList : []
             * attributeNames :
             * industryCategoryIds :
             * industryCategoryNames :
             * attributeIds :
             * parentName :
             * parentId : 0
             */

            private String id;
            private boolean isNewRecord;
            private int sort;
            private int size;
            private String attributeNames;
            private String industryCategoryIds;
            private String industryCategoryNames;
            private String attributeIds;
            private String parentName;
            private String parentId;
            private List<?> categoryAttributeList;
            private List<?> relIndustryCompanyCategoryList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getAttributeNames() {
                return attributeNames;
            }

            public void setAttributeNames(String attributeNames) {
                this.attributeNames = attributeNames;
            }

            public String getIndustryCategoryIds() {
                return industryCategoryIds;
            }

            public void setIndustryCategoryIds(String industryCategoryIds) {
                this.industryCategoryIds = industryCategoryIds;
            }

            public String getIndustryCategoryNames() {
                return industryCategoryNames;
            }

            public void setIndustryCategoryNames(String industryCategoryNames) {
                this.industryCategoryNames = industryCategoryNames;
            }

            public String getAttributeIds() {
                return attributeIds;
            }

            public void setAttributeIds(String attributeIds) {
                this.attributeIds = attributeIds;
            }

            public String getParentName() {
                return parentName;
            }

            public void setParentName(String parentName) {
                this.parentName = parentName;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public List<?> getCategoryAttributeList() {
                return categoryAttributeList;
            }

            public void setCategoryAttributeList(List<?> categoryAttributeList) {
                this.categoryAttributeList = categoryAttributeList;
            }

            public List<?> getRelIndustryCompanyCategoryList() {
                return relIndustryCompanyCategoryList;
            }

            public void setRelIndustryCompanyCategoryList(List<?> relIndustryCompanyCategoryList) {
                this.relIndustryCompanyCategoryList = relIndustryCompanyCategoryList;
            }
        }

        public static class AttributeBean {
            /**
             * id : db14779d29c9436db4b766a649e00a51
             * isNewRecord : false
             * name : 尺寸
             * sort : 30
             * public : false
             * parentId : 0
             */

            private String id;
            private boolean isNewRecord;
            private String name;
            private int sort;
            @SerializedName("public")
            private boolean publicX;
            private String parentId;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public boolean isPublicX() {
                return publicX;
            }

            public void setPublicX(boolean publicX) {
                this.publicX = publicX;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }
        }
    }
}
