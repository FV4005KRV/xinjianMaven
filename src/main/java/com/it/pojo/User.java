package com.it.pojo;

public class User {
    private Integer id;
    private String username;
    private String pwd;
    private int age;
    private double money;
    private String photo;

    public User() {
    }

    public User(Integer id, String username, String pwd, int age, double money, String photo) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.age = age;
        this.money = money;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", photo='" + photo + '\'' +
                '}';
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
