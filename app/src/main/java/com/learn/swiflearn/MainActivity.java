package com.learn.swiflearn;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationView;
import com.learn.swiflearn.adapter.CourseAdapter;
import com.learn.swiflearn.models.CourseResModel;
import com.learn.swiflearn.viewModels.CourseViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    private String subject = "Maths";
    DrawerLayout mDrawerLayout;
    ImageView closeDarwer;
    NavigationView navigationView;
    private RecyclerView courseRV;
    private CourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Past Classes");
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        initViews();
    }


    public void initViews() {


        Spinner subjectSpinner = findViewById(R.id.subjectSpinner);
        subjectSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> spinadapter = ArrayAdapter.createFromResource(this,
                R.array.subject_arrays, android.R.layout.simple_spinner_item);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(spinadapter);


        courseRV = findViewById(R.id.courseRV);
        courseRV.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        courseRV.setLayoutManager(linearLayoutManager);

        getCourseData(subject);

        View headerView = navigationView.getHeaderView(0);
        closeDarwer = headerView.findViewById(R.id.closeDarwer);

        closeDarwer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        @SuppressWarnings("unused") int id = item.getItemId();

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

        subject = adapterView.getItemAtPosition(position).toString();
        getCourseData(subject);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void getCourseData(String subject) {
        CourseViewModel courseViewModel = ViewModelProviders.of(this).get(CourseViewModel.class);
        courseViewModel.getCourse(subject).observe(this, new Observer<CourseResModel>() {
            @Override
            public void onChanged(@Nullable CourseResModel courseResModel) {

                adapter = new CourseAdapter(MainActivity.this, courseResModel);
                courseRV.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });
    }
}
