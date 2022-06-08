package com.leiyu.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private Integer id;
    private String sname;
    private Integer gender;
    private Integer age;
    private String cname;
    private String photo;

    public Student() {
    }

    public Student(Integer id, String sname, Integer gender, Integer age, String cname, String photo) {
        this.id = id;
        this.sname = sname;
        this.gender = gender;
        this.age = age;
        this.cname = cname;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", cname=" + cname +
                ", photo='" + photo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(sname, student.sname) && Objects.equals(gender, student.gender) && Objects.equals(age, student.age) && Objects.equals(cname, student.cname) && Objects.equals(photo, student.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sname, gender, age, cname, photo);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
