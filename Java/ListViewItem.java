package com.epeld.myapplication;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable ;
    private String titleStr ;
    private String descStr ;
    private String s1;
    private String a1;
    private String ad;
    private String ap;
    private String half;
    private String stone;


    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }
    public void setDesc2(String desc2) {
        s1 = desc2 ;
    }
    public void setA(String a){
        a1 = a ;
    }
    public void setAd(String aD){
        ad = aD;
    }
    public void setAp(String aP){
        ap = aP;
    }
    public void setHalf(String hf){
        half = hf;
    }
    public void setStone(String st){
        stone = st;
    }


    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
    public String getDesc2() {
        return this.s1;
    }
    public String getA() {
        return this.a1;
    }
    public String getAD() {
        return this.ad;
    }
    public String getAP() {
        return this.ap;
    }
    public String getHalf() {
        return this.half;
    }
    public String getStone() {
        return this.stone;
    }
}