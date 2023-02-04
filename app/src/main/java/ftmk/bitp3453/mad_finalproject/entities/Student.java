package ftmk.bitp3453.mad_finalproject.entities;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String fullName;
    private String matricNo;
    private String email;
    private String password;
    private String faculty;
    private String course;

    //constructor used to create a new Student
    public Student(String fullName, String matricNo, String email, String password, String faculty, String course, String sectionGroup) {
        id = -1;
        this.fullName = fullName;
        this.matricNo = matricNo;
        this.email = email;
        this.password = password;
        this.faculty = faculty;
        this.course = course;
        this.sectionGroup = sectionGroup;
    }

    //constructor used to assign existing Student to an instance
    public Student(int id, String fullName, String matricNo, String email, String password, String faculty, String course, String sectionGroup) {
        this.id = id;
        this.fullName = fullName;
        this.matricNo = matricNo;
        this.email = email;
        this.password = password;
        this.faculty = faculty;
        this.course = course;
        this.sectionGroup = sectionGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMatricNo() {
        return matricNo;
    }

    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSectionGroup() {
        return sectionGroup;
    }

    public void setSectionGroup(String sectionGroup) {
        this.sectionGroup = sectionGroup;
    }

    private String sectionGroup;

}
