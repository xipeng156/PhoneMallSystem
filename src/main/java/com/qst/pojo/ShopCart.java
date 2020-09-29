package com.qst.pojo;

import java.util.Date;

public class ShopCart {
    private Integer id;

    private Integer uId;

    private Integer oId;

    private String total;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ShopCart other = (ShopCart) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getoId() == null ? other.getoId() == null : this.getoId().equals(other.getoId()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getoId() == null) ? 0 : getoId().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}