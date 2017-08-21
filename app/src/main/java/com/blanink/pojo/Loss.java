package com.blanink.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class Loss {
    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"isNewRecord":true,"totalSaleAmount":0,"totalCostAmount":0,"totalProfitAmount":0,"totalaccountReceivable":0,"totalLossAmount":0,"totalLossQuantity":18,"totalReceivedAmount":0,"totalPayedAmount":0,"totalUnPayedAmount":0,"processName":"工序A","userName":"dongdong","reportList":[{"isNewRecord":true,"startDate":"2017-07-07","endDate":"2017-07-07","saleAmount":0,"costAmount":0,"profitAmount":0,"accountReceivable":0,"receivedAmount":0,"payedAmount":0,"unPayedAmount":0,"lossQuantity":18,"lossAmount":0,"achieveAmount":1,"userName":"dongdong","process":{"id":"be091cd5cdbc4b778494d54c870e7add","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"processName":"工序A","dateString":"2017-07","user":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","mobileMenuList":[],"roleList":[],"roleNames":"","admin":false}}]},{"isNewRecord":true,"totalSaleAmount":0,"totalCostAmount":0,"totalProfitAmount":0,"totalaccountReceivable":0,"totalLossAmount":0,"totalLossQuantity":5,"totalReceivedAmount":0,"totalPayedAmount":0,"totalUnPayedAmount":0,"processName":"发货","userName":"张三丰","reportList":[{"isNewRecord":true,"startDate":"2017-07-07","endDate":"2017-07-07","saleAmount":0,"costAmount":0,"profitAmount":0,"accountReceivable":0,"receivedAmount":0,"payedAmount":0,"unPayedAmount":0,"lossQuantity":5,"lossAmount":0,"achieveAmount":1,"userName":"张三丰","process":{"id":"dce551fbde2a46f5881fbc689e275f9e","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"processName":"发货","dateString":"2017-07","user":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"loginFlag":"1","mobileMenuList":[],"roleList":[],"roleNames":"","admin":false}}]},{"isNewRecord":true,"totalSaleAmount":0,"totalCostAmount":0,"totalProfitAmount":0,"totalaccountReceivable":0,"totalLossAmount":0,"totalLossQuantity":0,"totalReceivedAmount":0,"totalPayedAmount":0,"totalUnPayedAmount":0,"processName":"工序A","userName":"老二","reportList":[{"isNewRecord":true,"startDate":"2017-07-06","endDate":"2017-07-06","saleAmount":0,"costAmount":0,"profitAmount":0,"accountReceivable":0,"receivedAmount":0,"payedAmount":0,"unPayedAmount":0,"lossQuantity":0,"lossAmount":0,"achieveAmount":200,"userName":"老二","process":{"id":"be091cd5cdbc4b778494d54c870e7add","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"processName":"工序A","dateString":"2017-07","user":{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"loginFlag":"1","mobileMenuList":[],"roleList":[],"roleNames":"","admin":false}}]}]
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
         * isNewRecord : true
         * totalSaleAmount : 0
         * totalCostAmount : 0
         * totalProfitAmount : 0
         * totalaccountReceivable : 0
         * totalLossAmount : 0
         * totalLossQuantity : 18
         * totalReceivedAmount : 0
         * totalPayedAmount : 0
         * totalUnPayedAmount : 0
         * processName : 工序A
         * userName : dongdong
         * reportList : [{"isNewRecord":true,"startDate":"2017-07-07","endDate":"2017-07-07","saleAmount":0,"costAmount":0,"profitAmount":0,"accountReceivable":0,"receivedAmount":0,"payedAmount":0,"unPayedAmount":0,"lossQuantity":18,"lossAmount":0,"achieveAmount":1,"userName":"dongdong","process":{"id":"be091cd5cdbc4b778494d54c870e7add","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"processName":"工序A","dateString":"2017-07","user":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","mobileMenuList":[],"roleList":[],"roleNames":"","admin":false}}]
         */

        private boolean isNewRecord;
        private double totalSaleAmount;
        private double totalCostAmount;
        private double totalProfitAmount;
        private double totalaccountReceivable;
        private double totalLossAmount;
        private double totalLossQuantity;
        private double totalReceivedAmount;
        private double totalPayedAmount;
        private double totalUnPayedAmount;
        private String processName;
        private String userName;
        private List<ReportListBean> reportList;

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public double getTotalSaleAmount() {
            return totalSaleAmount;
        }

        public void setTotalSaleAmount(double totalSaleAmount) {
            this.totalSaleAmount = totalSaleAmount;
        }

        public double getTotalCostAmount() {
            return totalCostAmount;
        }

        public void setTotalCostAmount(double totalCostAmount) {
            this.totalCostAmount = totalCostAmount;
        }

        public double getTotalProfitAmount() {
            return totalProfitAmount;
        }

        public void setTotalProfitAmount(double totalProfitAmount) {
            this.totalProfitAmount = totalProfitAmount;
        }

        public double getTotalaccountReceivable() {
            return totalaccountReceivable;
        }

        public void setTotalaccountReceivable(double totalaccountReceivable) {
            this.totalaccountReceivable = totalaccountReceivable;
        }

        public double getTotalLossAmount() {
            return totalLossAmount;
        }

        public void setTotalLossAmount(double totalLossAmount) {
            this.totalLossAmount = totalLossAmount;
        }

        public double getTotalLossQuantity() {
            return totalLossQuantity;
        }

        public void setTotalLossQuantity(double totalLossQuantity) {
            this.totalLossQuantity = totalLossQuantity;
        }

        public double getTotalReceivedAmount() {
            return totalReceivedAmount;
        }

        public void setTotalReceivedAmount(double totalReceivedAmount) {
            this.totalReceivedAmount = totalReceivedAmount;
        }

        public double getTotalPayedAmount() {
            return totalPayedAmount;
        }

        public void setTotalPayedAmount(double totalPayedAmount) {
            this.totalPayedAmount = totalPayedAmount;
        }

        public double getTotalUnPayedAmount() {
            return totalUnPayedAmount;
        }

        public void setTotalUnPayedAmount(double totalUnPayedAmount) {
            this.totalUnPayedAmount = totalUnPayedAmount;
        }

        public String getProcessName() {
            return processName;
        }

        public void setProcessName(String processName) {
            this.processName = processName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public List<ReportListBean> getReportList() {
            return reportList;
        }

        public void setReportList(List<ReportListBean> reportList) {
            this.reportList = reportList;
        }

        public static class ReportListBean {
            /**
             * isNewRecord : true
             * startDate : 2017-07-07
             * endDate : 2017-07-07
             * saleAmount : 0
             * costAmount : 0
             * profitAmount : 0
             * accountReceivable : 0
             * receivedAmount : 0
             * payedAmount : 0
             * unPayedAmount : 0
             * lossQuantity : 18
             * lossAmount : 0
             * achieveAmount : 1
             * userName : dongdong
             * process : {"id":"be091cd5cdbc4b778494d54c870e7add","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]}
             * processName : 工序A
             * dateString : 2017-07
             * user : {"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","mobileMenuList":[],"roleList":[],"roleNames":"","admin":false}
             */

            private boolean isNewRecord;
            private String startDate;
            private String endDate;
            private double saleAmount;
            private double costAmount;
            private double profitAmount;
            private double accountReceivable;
            private double receivedAmount;
            private double payedAmount;
            private double unPayedAmount;
            private double lossQuantity;
            private double lossAmount;
            private double achieveAmount;
            private String userName;
            private ProcessBean process;
            private String processName;
            private String dateString;
            private UserBean user;

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public double getSaleAmount() {
                return saleAmount;
            }

            public void setSaleAmount(double saleAmount) {
                this.saleAmount = saleAmount;
            }

            public double getCostAmount() {
                return costAmount;
            }

            public void setCostAmount(double costAmount) {
                this.costAmount = costAmount;
            }

            public double getProfitAmount() {
                return profitAmount;
            }

            public void setProfitAmount(double profitAmount) {
                this.profitAmount = profitAmount;
            }

            public double getAccountReceivable() {
                return accountReceivable;
            }

            public void setAccountReceivable(double accountReceivable) {
                this.accountReceivable = accountReceivable;
            }

            public double getReceivedAmount() {
                return receivedAmount;
            }

            public void setReceivedAmount(double receivedAmount) {
                this.receivedAmount = receivedAmount;
            }

            public double getPayedAmount() {
                return payedAmount;
            }

            public void setPayedAmount(double payedAmount) {
                this.payedAmount = payedAmount;
            }

            public double getUnPayedAmount() {
                return unPayedAmount;
            }

            public void setUnPayedAmount(double unPayedAmount) {
                this.unPayedAmount = unPayedAmount;
            }

            public double getLossQuantity() {
                return lossQuantity;
            }

            public void setLossQuantity(double lossQuantity) {
                this.lossQuantity = lossQuantity;
            }

            public double getLossAmount() {
                return lossAmount;
            }

            public void setLossAmount(double lossAmount) {
                this.lossAmount = lossAmount;
            }

            public double getAchieveAmount() {
                return achieveAmount;
            }

            public void setAchieveAmount(double achieveAmount) {
                this.achieveAmount = achieveAmount;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public ProcessBean getProcess() {
                return process;
            }

            public void setProcess(ProcessBean process) {
                this.process = process;
            }

            public String getProcessName() {
                return processName;
            }

            public void setProcessName(String processName) {
                this.processName = processName;
            }

            public String getDateString() {
                return dateString;
            }

            public void setDateString(String dateString) {
                this.dateString = dateString;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public static class ProcessBean {
                /**
                 * id : be091cd5cdbc4b778494d54c870e7add
                 * isNewRecord : false
                 * sort : 30
                 * relPPList : []
                 * proList : []
                 * parentId : 0
                 * positionNames : []
                 */

                private String id;
                private boolean isNewRecord;
                private double sort;
                private String parentId;
                private List<?> relPPList;
                private List<?> proList;
                private List<?> positionNames;

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

                public double getSort() {
                    return sort;
                }

                public void setSort(double sort) {
                    this.sort = sort;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }

                public List<?> getRelPPList() {
                    return relPPList;
                }

                public void setRelPPList(List<?> relPPList) {
                    this.relPPList = relPPList;
                }

                public List<?> getProList() {
                    return proList;
                }

                public void setProList(List<?> proList) {
                    this.proList = proList;
                }

                public List<?> getPositionNames() {
                    return positionNames;
                }

                public void setPositionNames(List<?> positionNames) {
                    this.positionNames = positionNames;
                }
            }

            public static class UserBean {
                /**
                 * id : 4856035c527b419a9cf70d856e65c93b
                 * isNewRecord : false
                 * loginFlag : 1
                 * mobileMenuList : []
                 * roleList : []
                 * roleNames :
                 * admin : false
                 */

                private String id;
                private boolean isNewRecord;
                private String loginFlag;
                private String roleNames;
                private boolean admin;
                private List<?> mobileMenuList;
                private List<?> roleList;

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

                public String getLoginFlag() {
                    return loginFlag;
                }

                public void setLoginFlag(String loginFlag) {
                    this.loginFlag = loginFlag;
                }

                public String getRoleNames() {
                    return roleNames;
                }

                public void setRoleNames(String roleNames) {
                    this.roleNames = roleNames;
                }

                public boolean isAdmin() {
                    return admin;
                }

                public void setAdmin(boolean admin) {
                    this.admin = admin;
                }

                public List<?> getMobileMenuList() {
                    return mobileMenuList;
                }

                public void setMobileMenuList(List<?> mobileMenuList) {
                    this.mobileMenuList = mobileMenuList;
                }

                public List<?> getRoleList() {
                    return roleList;
                }

                public void setRoleList(List<?> roleList) {
                    this.roleList = roleList;
                }
            }
        }
    }
}
