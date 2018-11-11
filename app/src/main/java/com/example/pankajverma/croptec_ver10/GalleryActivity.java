package com.example.pankajverma.croptec_ver10;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class GalleryActivity extends AppCompatActivity {

    String results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        final ProgressBar progressBar = findViewById(R.id.progressBar);
        Button processButton = findViewById(R.id.btnProcess);
        ImageView imageView = findViewById(R.id.ImageGallery);
        Intent intent = getIntent();
        results = "Imfection, fungal, wilting, senescence";
        String tokens[] = results.split(",");
        //results = "{ disease: 'CANCER!!!'; type: 'fungal'}";

        if(intent.hasExtra("ImageUri")) {
            Uri imageUri = intent.getParcelableExtra("ImageUri");
            imageView.setImageURI(imageUri);
        }
        else if(intent.hasExtra("ImageBitmap")) {
            Bitmap imageBitmap = intent.getParcelableExtra("ImageBitmap");
            imageView.setImageBitmap(imageBitmap);
        }

        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setVisibility(View.GONE);

                // IN Below TODOS, '*' denotes requirements for a proper dummy
                //TODO: (1) call your ML process, pass the image as parameter
                //TODO: *(2) show user some message with the progress bar
                //(ex: Processing, please wait). Replace try-catch block with (1) and (2)
                //TODO: (3) find a way (notify / poll) to know when the processing is complete
                //TODO: (4) fetch the results from your process
                //TODO: *(5) create a new intent (GalleryActivity.this, ResultsActivity.class)
                //TODO: *(6) pass your results as an extra (intent.putExtra()) (for dummy pass dummy data)
                //TODO: *(7) startActivity(intent)
                //TODO: *(8) finish() ---> close GalleryActivity

                // IN THE ResultsActivity
                //TODO: *(9) get the intent (getIntent())
                //TODO: *(10) get the results from the intent(intent.getExtra())
                //TODO: *(11) do something with the results
            }
        });
    }
}
