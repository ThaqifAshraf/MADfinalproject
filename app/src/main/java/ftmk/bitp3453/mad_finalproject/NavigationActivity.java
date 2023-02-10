package ftmk.bitp3453.mad_finalproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private Boolean isStudent = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Toolbar toolbar = findViewById(R.id.toolbar_lecturer);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout_lecturer);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navView = findViewById(R.id.nav_view_lecturer);
        navView.inflateHeaderView(R.layout.nav_header);
        TextView txvName, txvEmail;
        txvName = navView.getHeaderView(0).findViewById(R.id.txv_name);
        txvEmail = navView.getHeaderView(0).findViewById(R.id.txv_email);
        String name = "", email = "";
        if (isStudent){
            navView.inflateMenu(R.menu.drawer_menu_student);
            name = "Student";
            email = "Student@student.email.com";
        }
        else {
            navView.inflateMenu(R.menu.drawer_menu_lecturer);
            name = "Lecturer";
            email = "Lecturer@email.com";
        }
        txvName.setText(name);
        txvEmail.setText(email);


    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.close();
        else
            super.onBackPressed();
    }
}
