package org.katheer.bean;

public class Student {
    private String name;
    private float cgpa;
    private String dept;

    public Student(String name, String dept, float cgpa) {
        this.name = name;
        this.cgpa = cgpa;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Name : " + this.getName() + "| Dept : " + this.getDept() + "|" +
                " CGPA : " + this.getCgpa();
    }
}
