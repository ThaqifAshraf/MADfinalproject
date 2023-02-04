package ftmk.bitp3453.mad_finalproject.entities;

import java.io.Serializable;

public class Class implements Serializable {
    private int id, lecturerId, subjectId;

    public Class(int id, int lecturerId, int subjectId) {
        this.id = id;
        this.lecturerId = lecturerId;
        this.subjectId = subjectId;
    }

    public int getId() {
        return id;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public int getSubjectId() {
        return subjectId;
    }
}
