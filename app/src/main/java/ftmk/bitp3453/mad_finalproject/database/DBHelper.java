package ftmk.bitp3453.mad_finalproject.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import ftmk.bitp3453.mad_finalproject.entities.Attendance;
import ftmk.bitp3453.mad_finalproject.entities.Class;
import ftmk.bitp3453.mad_finalproject.entities.Lecturer;
import ftmk.bitp3453.mad_finalproject.entities.Student;
import ftmk.bitp3453.mad_finalproject.entities.StudentAttendance;
import ftmk.bitp3453.mad_finalproject.entities.Subject;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "attendance.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStudent = "CREATE TABLE STUDENT_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fullname TEXT," +
                "matricNo TEXT UNIQUE," +
                "email TEXT," +
                "password TEXT," +
                "faculty TEXT," +
                "course TEXT," +
                "section_group TEXT)";

        String createTableLecturer = "CREATE TABLE LECTURER_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fullname TEXT," +
                "staffNo TEXT UNIQUE," +
                "email TEXT," +
                "password TEXT," +
                "department TEXT)";

        String createTableSubject = "CREATE TABLE SUBJECT_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "code TEXT UNIQUE)";

        String createBridgeTableClass = "CREATE TABLE ClASS_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "lecturer_id INTEGER," +
                "subject_id INTEGER," +
                "FOREIGN KEY (lecturer_id) REFERENCES LECTURER_TABLE(id)," +
                "FOREIGN KEY (subject_id) REFERENCES SUBJECT_TABLE(id))";

        String createBridgeTableStudentClass = "CREATE TABLE STUDENT_CLASS_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "student_id INTEGER," +
                "class_id INTEGER," +
                "FOREIGN KEY (class_id) REFERENCES CLASS_TABLE(id)," +
                "FOREIGN KEY (student_id) REFERENCES STUDENT_TABLE(id))";

        String createAttendanceTable = "CREATE TABLE ATTENDANCE_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "class_id INTEGER," +
                "time INTEGER," +
                "FOREIGN KEY (class_id) REFERENCES CLASS_TABLE(id))";

        String createStudentAttendanceTable = "CREATE TABLE STUDENT_ATTENDANCE_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "student_id INTEGER," +
                "attendance_id INTEGER," +
                "time INTEGER," +
                "FOREIGN KEY (attendance_id) REFERENCES ATTENDANCE_TABLE(id)," +
                "FOREIGN KEY (student_id) REFERENCES STUDENT_TABLE(id))";

        db.execSQL(createTableStudent);
        db.execSQL(createTableLecturer);
        db.execSQL(createTableSubject);
        db.execSQL(createBridgeTableClass);
        db.execSQL(createBridgeTableStudentClass);
        db.execSQL(createAttendanceTable);
        db.execSQL(createStudentAttendanceTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS STUDENT_CLASS_TABLE;");
        db.execSQL("DROP TABLE IF EXISTS CLASS_TABLE;");
        db.execSQL("DROP TABLE IF EXISTS SUBJECT_TABLE;");
        db.execSQL("DROP TABLE IF EXISTS LECTURER_TABLE;");
        db.execSQL("DROP TABLE IF EXISTS STUDENT_TABLE;");
        db.execSQL("DROP TABLE IF EXISTS ATTENDANCE_TABLE;");
        db.execSQL("DROP TABLE IF EXISTS STUDENT_ATTENDANCE_TABLE;");

        onCreate(db);
    }

    /*
     * ADD TO DATABASE METHODS
     */

    /**
     * Adds a new Student to the database
     * @param student A student instance that does not have an id
     * @return The row ID of the newly created row or -1 if an error occurred
     */
    public long addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("fullname", student.getFullName());
        cv.put("matricNo", student.getMatricNo());
        cv.put("email", student.getEmail());
        cv.put("password", student.getPassword());
        cv.put("faculty", student.getFaculty());
        cv.put("course", student.getCourse());
        cv.put("section_group", student.getSectionGroup());

        return db.insert("STUDENT_TABLE", null, cv);
    }

    /**
     * Adds a new Lecturer to the database
     * @param lecturer A lecturer instance that does not have an id
     * @return The row ID of the newly created row or -1 if an error occurred
     */
    public long addLecturer(Lecturer lecturer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("fullname", lecturer.getFullName());
        cv.put("staffNo", lecturer.getstaffNo());
        cv.put("email", lecturer.getEmail());
        cv.put("password", lecturer.getPassword());
        cv.put("department", lecturer.getDepartment());

        return db.insert("LECTURER_TABLE", null, cv);
    }

    /**
     * Adds a new Subject to the database
     * @param subject A subject instance that does not have an id
     * @return The row Id of the newly created row or -1 if an error occurred
     */
    public long addSubject(Subject subject){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", subject.getName());
        cv.put("code", subject.getCode());

        return db.insert("SUBJECT_TABLE", null, cv);
    }

    /**
     * A class is a bridge relationship between lecturer and subject table.
     * This method adds a new row to the bridge table.
     * @param lecturer  A lecturer instance that exists in the database. Must have an ID.
     * @param subject   A subject instance that exists in the database. Must have an ID.
     * @return  The row ID of the newly added row or -1 if an error occurred
     */
    public long addClass(Lecturer lecturer, Subject subject){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("lecturer_id", lecturer.getId());
        cv.put("subject_id", subject.getId());

        return db.insert("CLASS_TABLE", null, cv);
    }

    /**
     * A student class is a bridge relationship between Student and Class table.
     * This method adds a new student class row to the bridge table.
     * @param student   A student instance that exists in the database. Must have an ID.
     * @param classId   The ID row of the class from the class table.
     * @return  The row ID of the newly added row or -1 if an error occurred
     */
    public long addStudentClass(Student student, int classId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("student_id", student.getId());
        cv.put("class_id", classId);

        return db.insert("STUDENT_CLASS_TABLE", null, cv);
    }

    /**
     * Add a new Attendance into the database.
     * @param attendance    An Attendance object that doesn't have an existing id.
     * @return  The row id of the new Attendance from the database.
     */
    public long addAttendance(Attendance attendance){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("class_id", attendance.getClass_id());
        cv.put("time", attendance.getDatetime().getTimeInMillis());

        return db.insert("ATTENDANCE_TABLE", null, cv);
    }

    /**
     * Add a new Student Attendance into the database.
     * @param student   A Student object with an existing id.
     * @param attendance    An Attendance object with an existing id.
     * @param time  A Calendar object that holds the datetime the
     *              student submitted the attendance.
     * @return The row id of the new Student Attendance row.
     */
    public long addStudentAttendance(Student student, Attendance attendance, Calendar time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String status = "-";
        cv.put("student_id", student.getId());
        cv.put("attendance_id", attendance.getId());
        cv.put("time", time.getTimeInMillis());

        return db.insert("STUDENT_ATTENDANCE_TABLE", null, cv);
    }

    /*
     * RETRIEVE FROM DATABASE METHOD
     */

    /**
     * Retrieves a row from the student table based on the provided row id
     * @param studentId Student table row ID
     * @return  A student object or null if the provided row ID is invalid
     */
    @SuppressLint("Range")
    public Student getStudent(int studentId){
        Student student = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM STUDENT_TABLE" +
                " WHERE id=" + studentId;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String fullName = cursor.getString(cursor.getColumnIndex("fullname"));
            String matricNo = cursor.getString(cursor.getColumnIndex("matricNo"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String faculty = cursor.getString(cursor.getColumnIndex("faculty"));
            String course = cursor.getString(cursor.getColumnIndex("course"));
            String section = cursor.getString(cursor.getColumnIndex("section"));
            student = new Student(id, fullName, matricNo,
                    email, password, faculty, course, section);
        }
        cursor.close();
        db.close();
        return student;
    }

    /**
     * Retrieves a row from the student table based on the provided email and password
     * @param email Student email
     * @param password Student password
     * @return  A student object or null if the provided email and password are invalid
     */
    @SuppressLint("Range")
    public Student getStudent(String email, String password){
        Student student = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM STUDENT_TABLE" +
                " WHERE email=" + email +
                " AND password=" + password;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String fullName = cursor.getString(cursor.getColumnIndex("fullname"));
            String matricNo = cursor.getString(cursor.getColumnIndex("matricNo"));
            String faculty = cursor.getString(cursor.getColumnIndex("faculty"));
            String course = cursor.getString(cursor.getColumnIndex("course"));
            String section = cursor.getString(cursor.getColumnIndex("section"));
            student = new Student(id, fullName, matricNo,
                    email, password, faculty, course, section);
        }
        cursor.close();
        db.close();
        return student;
    }

    /**
     * Retrieves a row from the lecturer table based on the provided row id
     * @param lecturerId Lecturer table row ID
     * @return  A lecturer object or null if the provided row ID is invalid
     */
    @SuppressLint("Range")
    public Lecturer getLecturer(int lecturerId){
        Lecturer lecturer = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM LECTURER_TABLE" +
                " WHERE id=" + lecturerId;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String fullName = cursor.getString(cursor.getColumnIndex("fullname"));
            String staffNo = cursor.getString(cursor.getColumnIndex("staffNo"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String department = cursor.getString(cursor.getColumnIndex("department"));
            lecturer = new Lecturer(id, fullName, staffNo,
                    email, password, department);
        }
        cursor.close();
        db.close();
        return lecturer;
    }

    /**
     * Retrieves a row from the student table based on the provided email and password
     * @param email Lecturer email
     * @param password Lecturer password
     * @return  A lecturer object or null if the provided email and password is invalid
     */
    @SuppressLint("Range")
    public Lecturer getLecturer(String email, String password){
        Lecturer lecturer = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM LECTURER_TABLE" +
                " WHERE email=" + email +
                " AND password=" + password;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String fullName = cursor.getString(cursor.getColumnIndex("fullname"));
            String staffNo = cursor.getString(cursor.getColumnIndex("staffNo"));
            String department = cursor.getString(cursor.getColumnIndex("department"));
            lecturer = new Lecturer(id, fullName, staffNo,
                    email, password, department);
        }
        cursor.close();
        db.close();
        return lecturer;
    }

    /**
     * Gets a list available subjects from the database
     * @return A List of datatype Subject
     */
    @SuppressLint("Range")
    public List<Subject> getSubjects(){
        List<Subject> subjects = new ArrayList<>();
        Subject holder;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM SUBJECT_TABLE";
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String code = cursor.getString(cursor.getColumnIndex("code"));
            holder = new Subject(id, name, code);
            subjects.add(holder);
        }
        cursor.close();
        db.close();
        return subjects;
    }

    /**
     * Retrieves the subjects taught by a lecturer based on their row ID
     * @param lecturerId    Lecturer table row ID
     * @return  A List of datatype Subject
     */
    @SuppressLint("Range")
    public List<Subject> getLecturerSubjects(int lecturerId){
        List<Subject> subjects = new ArrayList<>();
        Subject holder;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM SUBJECT_TABLE " +
                "WHERE id=" +
                "(SELECT subject_id FROM CLASS_TABLE " +
                "WHERE lecturer_id = " + lecturerId + ")";
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String code = cursor.getString(cursor.getColumnIndex("code"));
            holder = new Subject(id, name, code);
            subjects.add(holder);
        }
        cursor.close();
        db.close();
        return subjects;
    }

    /**
     * Retrieves a list of students who are enrolled to a lecturer's class based
     * on the provided row ID
     * @param lecturerId Lecturer table row ID
     * @return A list of datatype Student
     */
    @SuppressLint("Range")
    public List<Student> getStudentsInClass(int lecturerId){
        List<Student> students = new ArrayList<>();
        Student holder;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM STUDENT_TABLE " +
                "WHERE id=" +
                "(SELECT student_id FROM STUDENT_CLASS_TABLE " +
                "WHERE class_id=" +
                "(SELECT id FROM CLASS_TABLE " +
                "WHERE lecturer_id="+lecturerId+"))";
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String fullName = cursor.getString(cursor.getColumnIndex("fullname"));
            String matricNo = cursor.getString(cursor.getColumnIndex("matricNo"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String faculty = cursor.getString(cursor.getColumnIndex("faculty"));
            String course = cursor.getString(cursor.getColumnIndex("course"));
            String section = cursor.getString(cursor.getColumnIndex("section"));
            holder = new Student(id, fullName, matricNo,
                    email, password, faculty, course, section);
            students.add(holder);
        }
        cursor.close();
        db.close();
        return students;
    }

    /**
     * Retrieves the classes the student is enrolled in based on the provided row ID
     * @param studentId Student Table row ID
     * @return  A List of datatype Class
     */
    @SuppressLint("Range")
    public List<Class> getStudentClasses(int studentId){
        List<Class> classes = new ArrayList<>();
        Class holder;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM CLASS_TABLE " +
                "WHERE id=" +
                "(SELECT class_id FROM STUDENT_CLASS_TABLE " +
                "WHERE student_id = " + studentId + ")";
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            int lecturerId = cursor.getInt(cursor.getColumnIndex("lecturer_id"));
            int subjectId = cursor.getInt(cursor.getColumnIndex("subject_id"));
            holder = new Class(id, lecturerId, subjectId);
            classes.add(holder);
        }
        cursor.close();
        db.close();
        return classes;
    }

    /**
     * Gets a List of Attendances for a class
     * @param classId The row ID of an existing Class
     * @return A list of Attendances based on the provided class ID
     */
    @SuppressLint("Range")
    public List<Attendance> getAttendances(int classId) {
        List<Attendance> attendances = null;
        Attendance holder;
        Calendar calHolder = new GregorianCalendar();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM ATTENDANCE_TABLE " +
                "WHERE class_id=" + classId + ")";
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            int time = cursor.getInt(cursor.getColumnIndex("time"));
            calHolder.setTimeInMillis(time);
            holder = new Attendance(classId, id, calHolder);
            attendances.add(holder);
        }
        cursor.close();
        db.close();
        return attendances;
    }

    /**
     * Gets a List of Student Attendances for an Attendance
     * @param attendanceId The row ID of an existing Attendance
     * @return  A list of Student Attendance based on the provided attendance ID
     */
    @SuppressLint("Range")
    public List<StudentAttendance> getStudentAttendances(int attendanceId) {
        List<StudentAttendance> attendances = null;
        StudentAttendance holder;
        Calendar calHolder = new GregorianCalendar();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM STUDENT_ATTENDANCE_TABLE " +
                "WHERE attendance_id=" + attendanceId + ")";
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            int studentId = cursor.getInt(cursor.getColumnIndex("student_id"));
            int time = cursor.getInt(cursor.getColumnIndex("time"));
            calHolder.setTimeInMillis(time);
            holder = new StudentAttendance(id, studentId, attendanceId, calHolder);
            attendances.add(holder);
        }
        cursor.close();
        db.close();
        return attendances;
    }

    /*
     * LOGICAL OPERATIONS
     */

    /**
     * Checks whether the provided email and password belongs to a student
     * @param email A String email to verify
     * @param password A String password to verify
     * @return  A Boolean value. True it is a student, otherwise false
     */
    public Boolean isStudent(String email, String password){
        return getStudent(email, password) != null;
    }

    //comment to commit

}
