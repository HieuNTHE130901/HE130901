package com.example.recycleviewdemo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        SuperHero selectedHero = getIntent().getParcelableExtra("superhero");

        ImageView imageView = findViewById(R.id.detail_imageview);
        TextView nameTextView = findViewById(R.id.detail_name);
        TextView descriptionTextView = findViewById(R.id.detail_description);

        if (selectedHero != null) {
            imageView.setImageResource(selectedHero.getImg_id());
            nameTextView.setText(selectedHero.getName());
            descriptionTextView.setText(selectedHero.getDescription());
        }
    }
}
