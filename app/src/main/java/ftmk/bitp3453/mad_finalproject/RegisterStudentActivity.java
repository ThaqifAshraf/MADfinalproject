package ftmk.bitp3453.mad_finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.os.Bundle;
import android.widget.Toast;

public class RegisterStudentActivity extends AppCompatActivity {
    private EditText fullNameEditText;
    private EditText matricNumberEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText facultyEditText;
    private EditText courseEditText;
    private EditText sectionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        fullNameEditText = findViewById(R.id.full_name_edit_text);
        matricNumberEditText = findViewById(R.id.matric_number_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        facultyEditText = findViewById(R.id.faculty_edit_text);
        courseEditText = findViewById(R.id.course_edit_text);
        sectionEditText = findViewById(R.id.section_edit_text);
    }

    public void registerStudent(View view) {
        String fullName = fullNameEditText.getText().toString();
        String matricNumber = matricNumberEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String faculty = facultyEditText.getText().toString();
        String course = courseEditText.getText().toString();
        String section = sectionEditText.getText().toString();

        // Perform validation on the input data
        if (fullName.isEmpty() || matricNumber.isEmpty() || email.isEmpty() || password.isEmpty() || faculty.isEmpty() || course.isEmpty() || section.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Call the API to register the student using the input data...
    }
}
