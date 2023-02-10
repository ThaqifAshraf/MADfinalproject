package ftmk.bitp3453.mad_finalproject.entities;

import java.io.Serializable;
import java.util.Calendar;

public class Attendance implements Serializable {
    private int class_id, id;
    private Calendar datetime;


    /**
     * Use this constructor to assign an existing Attendance to an object.
     * @param class_id  Row ID of a class from the database.
     * @param id    Row ID of an existing Attendance from the database.
     * @param datetime  A Calendar object that holds the time limit for the
     *                  students to submit their attendance.
     */
    public Attendance(int class_id, int id, Calendar datetime) {
        this.class_id = class_id;
        this.id = id;
        this.datetime = datetime;
    }

    /**
     * Use this constructor to create a new Attendance, an Attendance that doesn't have an
     * existing row ID.
     * @param class_id  Row ID of a class from the database.
     * @param datetime  A Calendar object that holds the time limit for the
     *                  students to submit their attendance.
     */
    public Attendance(int class_id, Calendar datetime) {
        id = -1;
        this.class_id = class_id;
        this.datetime = datetime;
    }

    public int getClass_id() {
        return class_id;
    }

    public int getId() {
        return id;
    }

    public Calendar getDatetime() {
        return datetime;
    }

    public void setDatetime(Calendar datetime) {
        this.datetime = datetime;
    }
}
