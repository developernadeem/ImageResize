package com.example.dexty.imageresize;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class EditorActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageView mImageView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.rotate:
                    mTextMessage.setText("Rotate");
                    return true;
                case R.id.crop:
                    mTextMessage.setText("Crop");
                    return true;
                case R.id.resize:
                    mTextMessage.setText("Resize");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);


        mImageView = (ImageView) findViewById(R.id.imageEdit);

        Bitmap loadedImage = (Bitmap) getIntent().getExtras().getParcelable("data");
        mImageView.setImageBitmap(loadedImage);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
