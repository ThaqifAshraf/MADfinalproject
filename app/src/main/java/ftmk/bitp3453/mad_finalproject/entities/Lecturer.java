package ftmk.bitp3453.mad_finalproject.entities;

import java.io.Serializable;

public class Lecturer implements Serializable {
    private int id;
    private String fullName,
    lecturer_id,
    email,
    password,
    department;

    //constructor used to create a new Lecturer
    public Lecturer(String fullName, String lecturer_id, String email, String password, String department) {
        id = -1;
        this.fullName = fullName;
        this.lecturer_id = lecturer_id;
        this.email = email;
        this.password = password;
        this.department = department;
    }

    //constructor used to assign an existing Lecturer to an instance
    public Lecturer(int id, String fullName, String lecturer_id, String email, String password, String department) {
        this.id = id;
        this.fullName = fullName;
        this.lecturer_id = lecturer_id;
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

    public String getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(String lecturer_id) {
        this.lecturer_id = lecturer_id;
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
