package com.ft.myapplication2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ft.myapplication2.utils.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * Created by FT_ZSS on 2016/8/3.
 */
public class ZxingTestActivity extends AppCompatActivity {

    private static final String TAG = "ZxingTestActivity";

    @BindView(R.id.input_et)
    EditText etInput;

    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_zxing);
        ButterKnife.bind(this);

        webView.setVerticalScrollbarOverlay(true);
        //设置WebView支持JavaScript
        webView.getSettings().setJavaScriptEnabled(true);

        String url = "file:///android_asset/demo.html";
        webView.loadUrl(url);

        //在js中调用本地java方法
        webView.addJavascriptInterface(new JsInterface(this), "AndroidWebView");

        //添加客户端支持
        webView.setWebChromeClient(new WebChromeClient());

    }

    private class JsInterface {
        private Context mContext;

        public JsInterface(Context context) {
            this.mContext = context;
        }

        //在js中调用window.AndroidWebView.showInfoFromJs(name)，便会触发此方法。
        @JavascriptInterface
        public void showInfoFromJs(String name) {
            Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
        }
    }

    //在java中调用js代码
    public void sendInfoToJs(View view) {
        String msg = etInput.getText().toString();
        //调用js中的函数：showInfoFromJava(msg)
        webView.loadUrl("javascript:showInfoFromJava('" + msg + "')");
    }

}
