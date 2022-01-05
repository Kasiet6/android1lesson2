package com.example.android1lesson2;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class secondActivity2 extends AppCompatActivity {

    ImageView imImage2;
    EditText etTitle2;
    Button btnSecond;
    Uri uriImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        imImage2 = findViewById(R.id.im_image2);
        etTitle2 = findViewById(R.id.et_title2);
        btnSecond= findViewById(R.id.btn_open_second_activity_this);


        imImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultLauncher.launch("image/*");
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(secondActivity2.this, MainActivity.class);
                String value = etTitle2.getText().toString();
                intent.putExtra("Text", value);
                intent.putExtra("Image",uriImage);
                startActivity(intent);
            }
        });

    }

    ActivityResultLauncher<String> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    imImage2.setImageURI(uri);
                    uriImage = uri;


                }
            });

}