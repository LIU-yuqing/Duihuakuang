package com.example.duihuakuang;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View v1 = getLayoutInflater().inflate(R.layout.login_dialog, null);
        final View v2 = getLayoutInflater().inflate(R.layout.test_dialog, null);
        final EditText userId = (EditText) v1.findViewById(R.id.editTextUserId);
        final EditText password = (EditText) v1.findViewById(R.id.editTextPwd);
        Button button1 = (Button) findViewById(R.id.main_btn_login);
        Button button2 = (Button) findViewById(R.id.btn_test);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();

                builder.setView(v1).setTitle("Login");

                builder.setPositiveButton("login",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int id){
                        if(userId.getText().toString().equals("abc") && password.getText().toString().equals("123")){
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                        }
                    }
                });

                builder.setNegativeButton("cancel",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int id){
                        Toast.makeText(MainActivity.this,"用户按下了取消按钮",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();

                builder.setView(v2).setMessage("test");
                builder.show();
            }
        });
    }
}