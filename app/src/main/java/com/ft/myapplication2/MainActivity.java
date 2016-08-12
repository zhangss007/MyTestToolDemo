package com.ft.myapplication2;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ft.myapplication2.dagger2_test.DaggerTest;
import com.ft.myapplication2.rxjava.RxJava_Scheduler_DrableRes;
import com.ft.myapplication2.sample.BusinessLogic;
import com.ft.myapplication2.sample.Todo;
import com.ft.myapplication2.uri.TestUri;
import com.ft.myapplication2.utils.L;
import com.ft.myapplication2.utils.T;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
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

    private static final String TAG = "MainActivity";
    @BindView(R.id.btn_test_rx_java_1)
    Button rxJavaTest;

    @BindView(R.id.btn_test_zxing)
    Button testZxing;

    @BindView(R.id.btn_activity_manager)
    Button testActivityManager;

    @BindView(R.id.m_et)
    EditText mshow;

    @BindView(R.id.btn_uninstall_app)
    Button uninstallApp;

    @BindView(R.id.btn_test_uri)
    Button testUri;

    //@OnClick(R.id.btn_test_rx_java_1)
    @OnClick({R.id.btn_test_rx_java_1,R.id.btn_test_zxing,R.id.btn_activity_manager,R.id.btn_uninstall_app,R.id.btn_test_uri})
    public void onClick(View view){
        if (rxJavaTest == view){

            DaggerTest.test();

            testOkhttp_get1();
        }else if (testZxing == view){
            Intent intent = new Intent(MainActivity.this,ZxingTestActivity.class);
            startActivity(intent);

        }else if (testActivityManager == view){

        }else if (uninstallApp == view){
            Uri packageUri = Uri.parse("package:"+MainActivity.this.getPackageName());
            Intent intent = new Intent(Intent.ACTION_DELETE,packageUri);
            startActivity(intent);
        }else if (testUri == view){

//            TestUri.testUri_message(MainActivity.this);
            Intent getImage = new Intent(Intent.ACTION_GET_CONTENT);
            getImage.addCategory(Intent.CATEGORY_OPENABLE);
            getImage.setType(MIME_TYPE_IMAGE_JPEG);
            startActivityForResult(getImage, ACTIVITY_GET_IMAGE);
        }

    }

    public static final String MIME_TYPE_IMAGE_JPEG = "image/*";
    public static final int ACTIVITY_GET_IMAGE = 0;


    //=======================okhttp test=================================


    /**
     * get 异步的实现方式
     */
    public void testOkhttp_get(){

        //创建OkhttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        Request request = new Request.Builder()
                .url("https://github.com/hongyangAndroid")
                .build();
        //new Call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                L.d(TAG,"HtmlStr:" + response.body().string());
            }
        });
    }


    /**
     * get 同步的实现方式
     */
    public void testOkhttp_get1()  {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    //创建OkHttpClient对象
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://github.com/hongyangAndroid")
                            .build();

                    Response response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()){
                        L.d(TAG,"HtmlString:" + response.body().string());
                    }

                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }).start();



    }
   //===================test ActivityManger==============================

    public void testActivityManager(){

        ActivityManager activityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        String value = "";
        L.d(TAG,"Object Heap:" + activityManager.getMemoryClass());
//        mshow.append();
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
