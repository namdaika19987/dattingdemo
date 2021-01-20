package com.example.datting.Home.Home;

public class People {
    private String name;
    private int image;
    private  int image_status;

    public People(String name, int image, int age, String adress, int image_status) {
        this.name = name;
        this.image = image;
        this.age = age;
        this.adress = adress;
        this.image_status = image_status;
    }

    public int getImage_status() {
        return image_status;
    }

    public void setImage_status(int image_status) {
        this.image_status = image_status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    private int age;
    private String adress;

    public People(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
