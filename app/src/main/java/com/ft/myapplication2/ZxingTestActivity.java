package com.ft.myapplication2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ft.myapplication2.utils.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * Created by FT_ZSS on 2016/8/3.
 */
public class ZxingTestActivity extends AppCompatActivity {


    @BindView(R.id.btn_test1)
    Button test1;


    @OnClick(R.id.btn_test1)
    public void onClick(View view){
        T.showShort(ZxingTestActivity.this,"KKKKKKKKKKKKKK");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_zxing);
        ButterKnife.bind(this);
    }
}
