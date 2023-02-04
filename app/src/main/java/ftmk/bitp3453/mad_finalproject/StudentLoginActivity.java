package ftmk.bitp3453.mad_finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StudentLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        TextView welcomeText = findViewById(R.id.welcome_text);
        welcomeText.setText("Welcome to the Student Login side, " + username);
    }
}
