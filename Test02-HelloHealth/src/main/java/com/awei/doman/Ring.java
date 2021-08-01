package com.awei.doman;

import sun.plugin.net.proxy.PluginProxyInfo;

import java.util.Date;

/**
 * @Description:
 * @Author: Awei
 * @Create: 2021-04-06 15:25
 **/
public class Ring {
    private String phoNum;
    private int no;
    private Date datetime;
    private String repository;
    private String version;
    private boolean isUseing;
    private boolean isCanbeUse;
    private int usetimes;
    private String remark;


    public Ring() {
    }

    public String getPhoNum() {
        return phoNum;
    }

    public void setPhoNum(String phoNum) {
        this.phoNum = phoNum;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isUseing() {
        return isUseing;
    }

    public void setUseing(boolean useing) {
        isUseing = useing;
    }

    public boolean isCanbeUse() {
        return isCanbeUse;
    }

    public void setCanbeUse(boolean canbeUse) {
        isCanbeUse = canbeUse;
    }

    public int getUsetimes() {
        return usetimes;
    }

    public void setUsetimes(int usetimes) {
        this.usetimes = usetimes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
