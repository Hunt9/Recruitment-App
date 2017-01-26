package com.example.hp.recruiment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button adminButton;
    private Button companyButton;
    private Button studentButton;
    public SharedPreferences iterate;
    public int select = 0;
    public SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminButton = (Button)findViewById(R.id.ADMIN);
        companyButton = (Button)findViewById(R.id.COMPANY);
        studentButton = (Button)findViewById(R.id.STUDENT);

        iterate = getSharedPreferences("label", 0);
        select = iterate.getInt("tag",0);


        //To edit the variables and commit (store) them:
        mEditor = iterate.edit();

        if (select == 1)
        {
            Intent intent = new Intent(MainActivity.this,AdminActivity.class);
            startActivity(intent);
            finish();
        }else if(select == 2)
        {
            Intent intent = new Intent(MainActivity.this,CompanyActivity.class);
            startActivity(intent);
            finish();
        }else if(select == 3)
        {
            Intent intent = new Intent(MainActivity.this,StudentActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "Please Login!", Toast.LENGTH_SHORT).show();
        }

        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putInt("tag",1).commit();
                Intent intent = new Intent(MainActivity.this,AdminActivity.class);
                startActivity(intent);
                finish();
            }
        });

        companyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putInt("tag",2).commit();
                Intent intent = new Intent(MainActivity.this,CompanyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putInt("tag",3).commit();
                Intent intent = new Intent(MainActivity.this,StudentActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
