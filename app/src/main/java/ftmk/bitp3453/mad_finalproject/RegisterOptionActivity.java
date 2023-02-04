package ftmk.bitp3453.mad_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_option);
    }

    public void onStudentRegisterButtonClicked(View view) {
        Intent intent = new Intent(this, RegisterStudentActivity.class);
        startActivity(intent);
    }

    public void onLecturerRegisterButtonClicked(View view) {
        Intent intent = new Intent(this, RegisterLecturerActivity.class);
        startActivity(intent);
    }
}
