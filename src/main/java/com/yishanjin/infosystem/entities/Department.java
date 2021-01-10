package com.yishanjin.infosystem.entities;

public class Department {

    private Integer id;

    private String departmentName;

    public Department(){//没有默认的无参构造器，导致不能初始化POJO对象;spring是通过无参构造器进行初始化bean的。
    }
    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
