package ftmk.bitp3453.mad_finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText matricNumberEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        matricNumberEditText = findViewById(R.id.username_input);
        passwordEditText = findViewById(R.id.password_input);
    }

    public void onLoginButtonClicked(View view) {
        String matricNumber = matricNumberEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (matricNumber.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Matric number and password are required", Toast.LENGTH_SHORT).show();
            return;
        }



        // Perform login logic here, such as checking against a database or making a network request

        // For example, assume the login is successful
        EditText usernameInput = findViewById(R.id.username_input);
        EditText passwordInput = findViewById(R.id.password_input);

        if (username.startsWith("S")) {
            Intent intent = new Intent(this, StudentLoginActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("password", password);
            startActivity(intent);
        } else if (username.startsWith("L")) {
            Intent intent = new Intent(this, LecturerLoginActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("password", password);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid username. Please try again.", Toast.LENGTH_SHORT).show();
        }

    }

    public void onSignUpButtonClicked(View view) {
        Intent intent = new Intent(this, RegisterOptionActivity.class);
        startActivity(intent);
    }

}
