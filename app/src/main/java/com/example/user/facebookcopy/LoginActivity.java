package com.example.user.facebookcopy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginBtn;
    Button signUpBtn;
    Button facebookLoginBtn;
    EditText idEdt, pwEdt;
    private android.widget.TextView modeTxt;
    private Button homepageBtn;
    private Button emailBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindViews();
        setupEvents();
    }

    void setupEvents() {
        // 버튼들이 눌릴때 하는 일들을 설정.
        // 이벤트 처리 모음

        loginBtn.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);
        facebookLoginBtn.setOnClickListener(this);
        homepageBtn.setOnClickListener(this);
        emailBtn.setOnClickListener(this);
    }

    void bindViews() {
        this.emailBtn = (Button) findViewById(R.id.emailBtn);
        this.homepageBtn = (Button) findViewById(R.id.homepageBtn);
        this.facebookLoginBtn = (Button) findViewById(R.id.facebookLoginBtn);
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.modeTxt = (TextView) findViewById(R.id.modeTxt);
    }

    @Override
    public void onClick(View v) {
        // 모든 버튼에 대한 클릭 이벤트를 처리 할 수 있음.
        if (v.getId() == R.id.loginBtn) {
            if (idEdt.getText().toString().equals("user")) {
                if (pwEdt.getText().toString().equals("1234")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            } else {
                Toast.makeText(this, "아이디나 비밀번호가 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.signUpBtn) {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.facebookLoginBtn) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("페이스북 로그인");
            alert.setMessage("준비중인 기능입니다.");
            alert.setPositiveButton("확인", null);
            alert.show();
        } else if (v.getId() == R.id.homepageBtn) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.naver.com"));
            startActivity(intent);
        } else if (v.getId() == R.id.emailBtn) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:contact@tje.co.kr"));
            startActivity(intent);
        }
    }
}