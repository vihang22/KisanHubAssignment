package com.ckeeda.kisanhubassignment.Model;

import io.realm.RealmObject;

public class WeatherData extends RealmObject {

   // @PrimaryKey
   // private int id;

    private String region;
    private String Weather;
    private int Year;
    private String Jan_data;
    private String Feb_data;
    private String Mar_data;
    private String Apr_data;
    private String May_data;
    private String Jun_data;
    private String Jul_data;
    private String Aug_data;
    private String Sep_data;
    private String Oct_data;
    private String Nov_data;
    private String Dec_data;
    private String Win_data;
    private String Spr_data;
    private String Sum_data;
    private String Aut_data;
    private String Ann_data;

    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String weather) {
        Weather = weather;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getJan_data() {
        return Jan_data;
    }

    public void setJan_data(String jan_data) {
        Jan_data = jan_data;
    }

    public String getFeb_data() {
        return Feb_data;
    }

    public void setFeb_data(String feb_data) {
        Feb_data = feb_data;
    }

    public String getMar_data() {
        return Mar_data;
    }

    public void setMar_data(String mar_data) {
        Mar_data = mar_data;
    }

    public String getApr_data() {
        return Apr_data;
    }

    public void setApr_data(String apr_data) {
        Apr_data = apr_data;
    }

    public String getMay_data() {
        return May_data;
    }

    public void setMay_data(String may_data) {
        May_data = may_data;
    }

    public String getJun_data() {
        return Jun_data;
    }

    public void setJun_data(String jun_data) {
        Jun_data = jun_data;
    }

    public String getJul_data() {
        return Jul_data;
    }

    public void setJul_data(String jul_data) {
        Jul_data = jul_data;
    }

    public String getAug_data() {
        return Aug_data;
    }

    public void setAug_data(String aug_data) {
        Aug_data = aug_data;
    }

    public String getSep_data() {
        return Sep_data;
    }

    public void setSep_data(String sep_data) {
        Sep_data = sep_data;
    }

    public String getOct_data() {
        return Oct_data;
    }

    public void setOct_data(String oct_data) {
        Oct_data = oct_data;
    }

    public String getNov_data() {
        return Nov_data;
    }

    public void setNov_data(String nov_data) {
        Nov_data = nov_data;
    }

    public String getDec_data() {
        return Dec_data;
    }

    public void setDec_data(String dec_data) {
        Dec_data = dec_data;
    }

    public String getWin_data() {
        return Win_data;
    }

    public void setWin_data(String win_data) {
        Win_data = win_data;
    }

    public String getSpr_data() {
        return Spr_data;
    }

    public void setSpr_data(String spr_data) {
        Spr_data = spr_data;
    }

    public String getSum_data() {
        return Sum_data;
    }

    public void setSum_data(String sum_data) {
        Sum_data = sum_data;
    }

    public String getAut_data() {
        return Aut_data;
    }

    public void setAut_data(String aut_data) {
        Aut_data = aut_data;
    }

    public String getAnn_data() {
        return Ann_data;
    }

    public void setAnn_data(String ann_data) {
        Ann_data = ann_data;
    }
}
