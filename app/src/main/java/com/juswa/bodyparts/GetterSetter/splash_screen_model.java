package com.juswa.bodyparts.GetterSetter;

public class splash_screen_model {

    public String Title,Desc;
    public int Img;
    public String color;

    public splash_screen_model(String title, String desc, int img, String color) {
        Title = title;
        Desc = desc;
        Img = img;
        this.color = color;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
