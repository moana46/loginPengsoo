package com.example.loginpengsoo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

public class FaceRecognition extends AppCompatActivity {

    ImageButton btnLeftRotate, btnRightRotate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_recognition);

        View decorView = getWindow().getDecorView();        // 하단 소프트키 없애기
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
            uiOptions |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            uiOptions |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
            uiOptions |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);



        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();  // 액션바 숨김

        WebView webView = (WebView)findViewById(R.id.webView);
        //webView.setPadding(0,0,0,0);
        webView.setInitialScale(100);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        //webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);

        String url ="http://192.168.0.139:8090/?action=stream";
        webView.loadUrl(url);

        btnLeftRotate = (ImageButton) findViewById(R.id.btnLeftRotate);
        btnLeftRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnRightRotate = (ImageButton) findViewById(R.id.btnRightRotate);
        btnRightRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuVoice:
                //mSendData.setStr("[PS]Speak");
                //mSendData.start();
                return true;
            case R.id.menuAuto:
                return true;
            case R.id.menuManual:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}