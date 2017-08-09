package com.example.user.facebookcopy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EditStatusActivity extends AppCompatActivity {

    private android.widget.TextView titleTxt;
    private android.widget.LinearLayout cameraLayout;
    private android.widget.LinearLayout liveLayout;
    private android.widget.LinearLayout checkInLayout;
    private android.widget.LinearLayout stickerLayout;
    private android.widget.Button writeBtn, cancelBtn;
    private android.widget.EditText commentEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_status);

        bindViews();
        setupEvents();
        setValues();
    }

    private void bindViews() {
        this.stickerLayout = (LinearLayout) findViewById(R.id.stickerLayout);
        this.checkInLayout = (LinearLayout) findViewById(R.id.checkInLayout);
        this.liveLayout = (LinearLayout) findViewById(R.id.liveLayout);
        this.cameraLayout = (LinearLayout) findViewById(R.id.cameraLayout);
        this.commentEdt = (EditText) findViewById(R.id.commentEdt);
        this.writeBtn = (Button) findViewById(R.id.writeBtn);
        this.titleTxt = (TextView) findViewById(R.id.titleTxt);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);
    }

    private void setupEvents() {

        View.OnClickListener preparingListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditStatusActivity.this, "준비중인 기능입니다.", Toast.LENGTH_SHORT).show();
            }
        };

        cameraLayout.setOnClickListener(preparingListener);
        liveLayout.setOnClickListener(preparingListener);
        checkInLayout.setOnClickListener(preparingListener);
        stickerLayout.setOnClickListener(preparingListener);

        commentEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String edtStr = charSequence.toString();
                if (edtStr.length() > 0) {
                    writeBtn.setTextColor(Color.parseColor("#5890ff"));
                } else {
                    writeBtn.setTextColor(Color.parseColor("#a0a0a0"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edtStr = commentEdt.getText().toString();
                if (edtStr.length() > 0) {
                    Toast.makeText(EditStatusActivity.this, "게시글이 등록됩니다.", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EditStatusActivity.this, "게시글을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setValues() {

    }
}
