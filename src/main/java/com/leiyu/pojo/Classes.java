package com.leiyu.pojo;

public class Classes {
    private Integer id;
    private String className;
    private Integer ssum;

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", ssum=" + ssum +
                '}';
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getSsum() {
        return ssum;
    }

    public void setSsum(Integer ssum) {
        this.ssum = ssum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Classes() {
    }

    public Classes(Integer id, String className, Integer ssum) {
        this.id = id;
        this.className = className;
        this.ssum = ssum;
    }
}
