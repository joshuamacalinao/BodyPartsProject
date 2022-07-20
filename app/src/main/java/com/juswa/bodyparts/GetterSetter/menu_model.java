package com.juswa.bodyparts.GetterSetter;

public class menu_model {

    public String Title;
    public int img,id;


    public menu_model(String title, int img, int id) {
        this.Title = title;
        this.img = img;
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
