package com.example.android1lesson2;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ImageView image;
    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btn_open_second_activity);
        image = findViewById(R.id.im_image);
        tvText = findViewById(R.id.tv_text);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, secondActivity2.class);
                startActivity(intent);
            }
        });
        String text = getIntent().getStringExtra("Text");
        Uri uri = getIntent().getParcelableExtra("Image");

        tvText.setText(text);
        image.setImageURI(uri);

    }

}