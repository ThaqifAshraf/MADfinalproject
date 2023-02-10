package ftmk.bitp3453.mad_finalproject.entities;

import java.io.Serializable;
import java.util.Calendar;

public class StudentAttendance implements Serializable {
    private int id, studentId, attendanceId;
    private Calendar time;

    /**
     * Create a StudentAttendance object with an existing row id.
     * @param id    The Student Attendance row ID in the database.
     * @param attendanceId The row ID of an existing Attendance.
     * @param time  A Calendar object that holds the time the student submitted their attendance.
     */
    public StudentAttendance(int id, int studentId, int attendanceId, Calendar time) {
        this.id = id;
        this.studentId = studentId;
        this.attendanceId = attendanceId;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public Calendar getTime() {
        return time;
    }
}
