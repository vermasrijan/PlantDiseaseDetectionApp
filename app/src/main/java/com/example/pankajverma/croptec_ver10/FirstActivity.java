package com.example.pankajverma.croptec_ver10;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

//    ImageView imageView;
    private Button buttonGallery;
    private Button buttonCamera;
    private static final int PICK_IMAGE = 100;
    private Uri imageUri ;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        //imageView = (ImageView) findViewById(R.id.ImageGallery);
        buttonGallery = (Button) findViewById(R.id.btnGallery);

        buttonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        buttonCamera = (Button) findViewById(R.id.btnCamera);

        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });

    }

    private void openGallery(){

        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            //imageView.setImageURI(imageUri);

            openGalleryActivity();
        }

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            openGalleryActivity(imageBitmap);
        }
    }

    public void openGalleryActivity() {
        Intent intent = new Intent(this, GalleryActivity.class);
        intent.putExtra("ImageUri", imageUri);
        startActivity(intent);
    }

    public void openGalleryActivity(Bitmap imageBitmap) {
        Intent intent = new Intent(this, GalleryActivity.class);
        intent.putExtra("ImageBitmap", imageBitmap);
        startActivity(intent);
    }

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } else {
            Toast.makeText(this, "You need a camera app to perform this action",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
