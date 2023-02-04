package ftmk.bitp3453.mad_finalproject.entities;

import java.io.Serializable;

public class Lecturer implements Serializable {
    private int id;
    private String fullName,
    staffNo,
    email,
    password,
    department;

    //constructor used to create a new Lecturer
    public Lecturer(String fullName, String staffNo, String email, String password, String department) {
        id = -1;
        this.fullName = fullName;
        this.staffNo = staffNo;
        this.email = email;
        this.password = password;
        this.department = department;
    }

    //constructor used to assign an existing Lecturer to an instance
    public Lecturer(int id, String fullName, String staffNo, String email, String password, String department) {
        this.id = id;
        this.fullName = fullName;
        this.staffNo = staffNo;
        this.email = email;
        this.password = password;
        this.department = department;
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

    public String getstaffNo() {
        return staffNo;
    }

    public void setstaffNo(String staffNo) {
        this.staffNo = staffNo;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
