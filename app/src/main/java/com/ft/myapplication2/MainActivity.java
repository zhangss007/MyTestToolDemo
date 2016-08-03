package com.ft.myapplication2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ft.myapplication2.dagger2_test.DaggerTest;
import com.ft.myapplication2.rxjava.RxJava_Scheduler_DrableRes;
import com.ft.myapplication2.sample.BusinessLogic;
import com.ft.myapplication2.sample.Todo;
import com.ft.myapplication2.utils.L;
import com.ft.myapplication2.utils.T;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.btn_test_rx_java_1)
    Button rxJavaTest;

    @BindView(R.id.btn_test_zxing)
    Button testZxing;

    @BindView(R.id.m_iv)
    ImageView imageView;

    //@OnClick(R.id.btn_test_rx_java_1)
    @OnClick({R.id.btn_test_rx_java_1,R.id.btn_test_zxing})
    public void onClick(View view){
        if (rxJavaTest == view){

            DaggerTest.test();
            RxJava_Scheduler_DrableRes s = new RxJava_Scheduler_DrableRes();
            s.setImageView(imageView);
            Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
            s.setDrawable(drawable);
            s.test();
        }else if (testZxing == view){
            Intent intent = new Intent(MainActivity.this,ZxingTestActivity.class);
            startActivity(intent);

        }
    }


    //=========================Test RXJava====================================

    public static final String TAG = "RXJAVA";

    
    public void testRxJavaScheduler3_map(){
        Observable.just("images/logo.png") //输入类型 String
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String filePath) {
                        return getBitmapFromFilePath(filePath);
                    }
                })
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        showBitmap(bitmap);
                    }
                });
    }

    public Bitmap getBitmapFromFilePath(String filePath){
        return null;
    }

    public void showBitmap(Bitmap bitmap){

    }

    //===================================================================


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ButterKnife.bind(this);
        getTodoReportForBusinessLogic();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getTodoReportForBusinessLogic(){

        Class businessLogicClass = BusinessLogic.class;
        for (Method method:businessLogicClass.getMethods()){

            Todo todoAnnotation = (Todo)method.getAnnotation(Todo.class);
            if (todoAnnotation != null){
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" Author : " + todoAnnotation.author());
                System.out.println(" Priority : " + todoAnnotation.priority());
                System.out.println(" Status : " + todoAnnotation.status());
                System.out.println(" --------------------------- ");
            }
        }
    }
}
