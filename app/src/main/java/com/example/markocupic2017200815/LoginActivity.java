package com.example.markocupic2017200815;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonConfirm = findViewById(R.id.buttonCancelLogin);
        buttonConfirm.setOnClickListener(this);

        Button buttonCancel = findViewById(R.id.buttonConfirmLogin);
        buttonCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonConfirmLogin:
                this.doConfirm();
                break;
            case R.id.buttonCancelLogin:
                this.doCancel();
                break;
        }
    }

    private void doConfirm() {
        String username = ((EditText) findViewById(R.id.inputUsernameLogin)).getText().toString();
        String password = ((EditText) findViewById(R.id.inputPasswordLogin)).getText().toString();

        if(username.isEmpty() || password.isEmpty()) {
            ((TextView) findViewById(R.id.labelMessageLogin)).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.labelMessageLogin)).setText("Email and password fields should not be empty!");
        } else if (username.matches("^[^@\\s]+@[^@\\s\\.]+\\.[^@\\.\\s]+$") || (username.equals("test") && password.equals("test"))) {
            ((TextView) findViewById(R.id.labelMessageLogin)).setVisibility(View.INVISIBLE);
            startActivity(new Intent(this, PcPartsActivity.class));
        } else {
            ((TextView) findViewById(R.id.labelMessageLogin)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.labelMessageLogin)).setText("Invalid email format!");
        }
    }

    private void doCancel() {
        finish();
    }

    @Override
    public void onBackPressed() {
        return;
    }
}