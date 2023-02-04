package ftmk.bitp3453.mad_finalproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "attendance.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStudent = "CREATE TABLE STUDENT_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fullname TEXT," +
                "matricNo TEXT," +
                "email TEXT," +
                "password TEXT," +
                "faculty TEXT," +
                "course TEXT," +
                "section_group TEXT)";

        String createTableLecturer = "CREATE TABLE LECTURER_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fullname TEXT," +
                "staffNo TEXT," +
                "email TEXT," +
                "password TEXT," +
                "department TEXT)";

        String createTableSubject = "CREATE TABLE SUBJECT_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "code TEXT)";

        String createBridgeTableClass = "CREATE TABLE ClASS_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "lecturer_id INTEGER," +
                "subject_id INTEGER," +
                "FOREIGN KEY (lecturer_id) REFERENCES LECTURER_TABLE(id))";

        String createBridgeTableStudentClass = "CREATE TABLE STUDENT_CLASS_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "student_id INTEGER," +
                "class_id INTEGER," +
                "FOREIGN KEY (class_id) REFERENCES LECTURER_TABLE(id))";

        db.execSQL(createTableStudent);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
