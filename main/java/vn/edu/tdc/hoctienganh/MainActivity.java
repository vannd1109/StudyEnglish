package vn.edu.tdc.hoctienganh;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import vn.edu.tdc.hoctienganh.luyentap.BaiHocFragment;
import vn.edu.tdc.hoctienganh.luyentap.GhiChuFragment;
import vn.edu.tdc.hoctienganh.luyentap.HomeFragment;
import vn.edu.tdc.hoctienganh.luyentap.LuyenTapFragment;
import vn.edu.tdc.hoctienganh.luyentap.NguPhapFragment;
import vn.edu.tdc.hoctienganh.luyentap.TraTuFragment;
import vn.edu.tdc.hoctienganh.question.DBHelper;
import vn.edu.tdc.hoctienganh.score.ScoreFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        HomeFragment homeFragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_main, homeFragment, homeFragment.getTag()).commit();

        DBHelper dbHelper = new DBHelper(this);

        // Delelte database old and create database new

//        dbHelper.deleteDataBase();
//        Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();


        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            HomeFragment homeFragment = new HomeFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, homeFragment, homeFragment.getTag()).commit();
        } else if (id == R.id.nav_tratudien) {
            TraTuFragment traTuFragment = new TraTuFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, traTuFragment, traTuFragment.getTag()).commit();

        } else if (id == R.id.nav_luyentap) {
            LuyenTapFragment luyenTapFragment = new LuyenTapFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, luyenTapFragment, luyenTapFragment.getTag()).commit();
        } else if (id == R.id.nav_ghichu) {
            GhiChuFragment ghiChuFragment = new GhiChuFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, ghiChuFragment, ghiChuFragment.getTag()).commit();
        } else if (id == R.id.nav_nguphap) {
            NguPhapFragment nguPhapFragment = new NguPhapFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, nguPhapFragment, nguPhapFragment.getTag()).commit();
        } else if (id == R.id.nav_score) {
            ScoreFragment scoreFragment = new ScoreFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, scoreFragment, scoreFragment.getTag()).commit();
        }else if (id == R.id.nav_baihoc) {
            BaiHocFragment baiHocFragment = new BaiHocFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, baiHocFragment, baiHocFragment.getTag()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
