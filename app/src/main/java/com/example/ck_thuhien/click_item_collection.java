package com.example.ck_thuhien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class click_item_collection extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    TextView tvbackbst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_item_collection);

        imageView = findViewById(R.id.imageView3);
        textView = findViewById(R.id.tvName3);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            String selectedName = intent.getStringExtra("name1");
            int selectedImage = intent.getIntExtra("image1",0);

            textView.setText(selectedName);
            imageView.setImageResource(selectedImage);
        }
        tvbackbst = (TextView) findViewById(R.id.backbst);
        tvbackbst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(click_item_collection.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}