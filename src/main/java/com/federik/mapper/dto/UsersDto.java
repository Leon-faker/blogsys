package com.federik.mapper.dto;

import java.io.Serializable;

public class UsersDto  implements Serializable {

    @Override
    public String toString() {
        return "UsersDto{" +
                "netUserId=" + netUserId +
                ", netUserType=" + netUserType +
                ", netUserName='" + netUserName + '\'' +
                ", netUserPassword='" + netUserPassword + '\'' +
                ", netUserCreatetime='" + netUserCreatetime + '\'' +
                ", netUserUpdatetime='" + netUserUpdatetime + '\'' +
                '}';
    }
    public UsersDto(){};

    public UsersDto(Integer netUserId, Integer netUserType, String netUserName, String netUserPassword, String netUserCreatetime, String netUserUpdatetime) {
        this.netUserId = netUserId;
        this.netUserType = netUserType;
        this.netUserName = netUserName;
        this.netUserPassword = netUserPassword;
        this.netUserCreatetime = netUserCreatetime;
        this.netUserUpdatetime = netUserUpdatetime;
    }

    public Integer getNetUserId() {
        return netUserId;
    }

    public void setNetUserId(Integer netUserId) {
        this.netUserId = netUserId;
    }

    public Integer getNetUserType() {
        return netUserType;
    }

    public void setNetUserType(Integer netUserType) {
        this.netUserType = netUserType;
    }

    public String getNetUserName() {
        return netUserName;
    }

    public void setNetUserName(String netUserName) {
        this.netUserName = netUserName;
    }

    public String getNetUserPassword() {
        return netUserPassword;
    }

    public void setNetUserPassword(String netUserPassword) {
        this.netUserPassword = netUserPassword;
    }

    public String getNetUserCreatetime() {
        return netUserCreatetime;
    }

    public void setNetUserCreatetime(String netUserCreatetime) {
        this.netUserCreatetime = netUserCreatetime;
    }

    public String getNetUserUpdatetime() {
        return netUserUpdatetime;
    }

    public void setNetUserUpdatetime(String netUserUpdatetime) {
        this.netUserUpdatetime = netUserUpdatetime;
    }

    private Integer netUserId; //主键id

    private Integer netUserType; //用户类型

    private String netUserName;//用户名

    private String netUserPassword;//用户密码

    private String netUserCreatetime;//创建时间

    private String netUserUpdatetime;//更新时间


}
