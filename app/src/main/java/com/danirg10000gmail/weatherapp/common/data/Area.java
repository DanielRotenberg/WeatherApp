package com.danirg10000gmail.weatherapp.common.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dr9874 on 22/11/2017.
 */

public class Area {
    @SerializedName("cod")
    private String cod;
    @SerializedName("calctime")
    private Double calctime;
    @SerializedName("cnt")
    private Integer cnt;
    @SerializedName("list")
    private List<City> citiesList;

    public List<City> getCitiesList() {
        return citiesList;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getCalctime() {
        return calctime;
    }

    public void setCalctime(Double calctime) {
        this.calctime = calctime;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public void setCitiesList(List<City> citiesList) {
        this.citiesList = citiesList;
    }
}
