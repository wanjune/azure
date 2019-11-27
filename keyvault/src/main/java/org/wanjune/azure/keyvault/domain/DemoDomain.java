package org.wanjune.azure.keyvault.domain;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;

public class DemoDomain implements Serializable {
    private static final long serialVersionUID = -5554587652056198940L;

    private String sex;

    private String userId;

    private Integer points;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}
