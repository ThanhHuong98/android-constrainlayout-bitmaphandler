package com.za.constrain_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgHeader = findViewById(R.id.header);

        // Scale bitmap
       // get Dimension of device
        Display display = getWindowManager().getDefaultDisplay();
        int displayWidth = display.getWidth();
        // get Dimension of bitmap, don't load it in memory
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.singapore, options);
        int width = options.outWidth;
        // Calculator scale ratio
        if(width > displayWidth){
            int widthRatio = Math.round((float) width / (float) displayWidth);
            options.inSampleSize = widthRatio;
        }
        // Create new bitmap with scale ratio and set it into imgHeader
        options.inJustDecodeBounds = false;
        Bitmap scaleBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.singapore, options);
        imgHeader.setImageBitmap(scaleBitmap);
    }
}
