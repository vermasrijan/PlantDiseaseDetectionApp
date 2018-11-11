package com.example.pankajverma.croptec_ver10;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Intent intent = getIntent();
        Uri imageUri = intent.getParcelableExtra("ImageUri");

        ImageView imageView = findViewById(R.id.ImageGallery);
        imageView.setImageURI(imageUri);
    }
}
