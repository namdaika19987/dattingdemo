package com.example.datting.Model;

public class User_infor {
    private int image_infor;
    private String name_infor;

    public int getImage_infor() {
        return image_infor;
    }

    public void setImage_infor(int image_infor) {
        this.image_infor = image_infor;
    }

    public User_infor(String name_infor) {
        this.name_infor = name_infor;
    }

    public String getName_infor() {
        return name_infor;
    }

    public void setName_infor(String name_infor) {
        this.name_infor = name_infor;
    }

    public User_infor(int image_infor, String name_infor) {
        this.image_infor = image_infor;
        this.name_infor = name_infor;
    }
}
