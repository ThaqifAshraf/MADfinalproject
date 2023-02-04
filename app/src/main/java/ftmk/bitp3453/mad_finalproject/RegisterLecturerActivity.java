package ftmk.bitp3453.mad_finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterLecturerActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText matricNumberEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText departmentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_lecturer);

        fullNameEditText = findViewById(R.id.full_name_edit_text);
        matricNumberEditText = findViewById(R.id.matric_number_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        departmentEditText = findViewById(R.id.department_edit_text);
    }

    public void onRegisterButtonClicked(View view) {
        String fullName = fullNameEditText.getText().toString();
        String matricNumber = matricNumberEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String department = departmentEditText.getText().toString();

        // validate the inputs
        if (fullName.isEmpty() || matricNumber.isEmpty() || email.isEmpty() || password.isEmpty() || department.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // save the lecturer's information
        // ...

        Toast.makeText(this, "Lecturer registered successfully!", Toast.LENGTH_SHORT).show();
    }
}