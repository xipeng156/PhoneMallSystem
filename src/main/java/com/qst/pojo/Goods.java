package com.qst.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Integer id;

    private Integer goodId;

    private String name;

    private String introduce;

    private BigDecimal price;

    private Date invalidTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
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
        Goods other = (Goods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodId() == null ? other.getGoodId() == null : this.getGoodId().equals(other.getGoodId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIntroduce() == null ? other.getIntroduce() == null : this.getIntroduce().equals(other.getIntroduce()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getInvalidTime() == null ? other.getInvalidTime() == null : this.getInvalidTime().equals(other.getInvalidTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodId() == null) ? 0 : getGoodId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIntroduce() == null) ? 0 : getIntroduce().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getInvalidTime() == null) ? 0 : getInvalidTime().hashCode());
        return result;
    }
}