package ftmk.bitp3453.mad_finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class LecturerLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_login);

        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        TextView welcomeText = findViewById(R.id.welcome_text);
        welcomeText.setText("Welcome to the Lecturer Login side, " + username);
    }
}
