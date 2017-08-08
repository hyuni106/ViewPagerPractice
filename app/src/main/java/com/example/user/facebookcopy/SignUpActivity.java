package com.example.user.facebookcopy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    private android.widget.Button overlapCheckBtn;
    private android.widget.Button signUpBtn;
    private EditText idEdt, pwEdt, pwCheckEdt;
    boolean checkId = false;
    private TextView checkTxt, birthDayTxt;
    private ImageView checkImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindViews();
        setupEvents();
    }
    void setupEvents() {
        overlapCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(idEdt.getText().toString().equals("user")) {
                    Toast.makeText(SignUpActivity.this, "이미 사용중인 아이디입니다.", Toast.LENGTH_SHORT).show();
                } else if (idEdt.getText().toString().equals("")) {
                    Toast.makeText(SignUpActivity.this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (idEdt.getText().toString().length() < 8) {
                    Toast.makeText(SignUpActivity.this, "ID의 길이가 너무 짧습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignUpActivity.this, "사용해도 좋습니다.", Toast.LENGTH_SHORT).show();
                    checkId = true;
                }
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pw = pwEdt.getText().toString();
                String pwCheck = pwCheckEdt.getText().toString();
                if (pw.equals(pwCheck) && pw.length() >= 8) {
                    if (checkId) {
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(SignUpActivity.this, "아이디를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignUpActivity.this, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        idEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String changedStr = charSequence.toString();
                Log.d("changedStr", changedStr);

                checkId = false;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        pwEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkPwAndChangeMessage();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        pwCheckEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkPwAndChangeMessage();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        final Calendar tmpCal = Calendar.getInstance();

        birthDayTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SignUpActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        birthDayTxt.setText(""+i+i1+i2);
                    }
                }, tmpCal.get(Calendar.YEAR), tmpCal.get(Calendar.MONTH), tmpCal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    void checkPwAndChangeMessage() {
        String pw = pwEdt.getText().toString();
        String pwCheck = pwCheckEdt.getText().toString();

        if (pw.length() == 0) {
            checkTxt.setText("비밀번호를 입력해주세요");
            checkTxt.setTextColor(Color.parseColor("#FF0000"));
            checkImg.setImageResource(R.drawable.alert_icon);
        } else if (pw.length() < 8) {
            checkTxt.setText("비밀번호의 길이가 너무 짧습니다.");
            checkTxt.setTextColor(Color.parseColor("#FF0000"));
            checkImg.setImageResource(R.drawable.alert_icon);
        } else if (!pw.equals(pwCheck)) {
            checkTxt.setText("두개의 비밀번호가 서로 다릅니다.");
            checkTxt.setTextColor(Color.parseColor("#FF0000"));
            checkImg.setImageResource(R.drawable.alert_icon);
        } else {
            checkTxt.setText("회원가입이 가능합니다.");
            checkTxt.setTextColor(Color.parseColor("#319944"));
            checkImg.setImageResource(R.drawable.ok_icon);
        }
    }
    
    void bindViews() {
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.overlapCheckBtn = (Button) findViewById(R.id.overlapCheckBtn);
        idEdt = (EditText)findViewById(R.id.idEdt);
        pwEdt = (EditText)findViewById(R.id.pwEdt);
        pwCheckEdt = (EditText)findViewById(R.id.pwCheckEdt);
        checkTxt = (TextView)findViewById(R.id.checkTxt);
        checkImg = (ImageView)findViewById(R.id.checkImg);
        birthDayTxt = (TextView) findViewById(R.id.birthDayTxt);
    }
}
