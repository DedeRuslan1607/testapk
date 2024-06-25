package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Karyawan
 */
public class Karyawan {

    private String name;
    private int age;

    private String username;
    private String password;

    private List<Absen> absens = new ArrayList<>();

    public List<Absen> getAbsens() {
        return absens;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

}