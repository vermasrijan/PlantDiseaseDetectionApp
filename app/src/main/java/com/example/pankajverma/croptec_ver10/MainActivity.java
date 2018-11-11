package com.example.pankajverma.croptec_ver10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btnNext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFirstActivity(); }
        });
    }
    public void openFirstActivity() {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
        finish();
    }
}
