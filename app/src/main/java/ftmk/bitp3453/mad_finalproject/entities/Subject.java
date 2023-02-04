package ftmk.bitp3453.mad_finalproject.entities;

import java.io.Serializable;

public class Subject implements Serializable {
    private  int id;
    private String name;
    private String code;

    //constructor for creating a new subject
    public Subject(String name, String code) {
        id = -1;
        this.name = name;
        this.code = code;
    }

    //constructor used to assign an existing subject to an instance
    public Subject(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
