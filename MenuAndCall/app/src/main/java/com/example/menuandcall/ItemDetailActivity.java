package com.example.menuandcall;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        ImageView itemDetailImage = findViewById(R.id.itemDetailImage);
        TextView itemDetailName = findViewById(R.id.itemDetailName);
        TextView itemDetailDescription = findViewById(R.id.itemDetailDescription);

        // Get item details from the intent
        Intent intent = getIntent();
        if (intent != null) {
            String itemName = intent.getStringExtra("item");
            String itemDescription = intent.getStringExtra("description");
            if (itemName != null) {
                // Set the item's name and description in the TextViews
                itemDetailName.setText(itemName);
                itemDetailDescription.setText(itemDescription);

                // Set the item's image (replace with appropriate logic)
                int imageResourceId = getImageResourceId(itemName);
                if (imageResourceId != 0) {
                    itemDetailImage.setImageResource(imageResourceId);
                }
            }
        }
    }

    // Replace this with your logic to map item names to image resource IDs
    private int getImageResourceId(String itemName) {
        switch (itemName) {
            case "Item 1":
                return R.drawable.item1;
            case "Item 2":
                return R.drawable.item2;
            case "Item 3":
                return R.drawable.item3;
            case "Item 4":
                return R.drawable.item4;
            case "Item 5":
                return R.drawable.item5;
            default:
                return 0; // Use a default image resource or handle missing items as needed
        }
    }


}
