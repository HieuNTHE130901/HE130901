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

    public void onCallButtonClick(View view) {
        // Get the telephone number to call (replace with your actual logic)
        String phoneNumber = getPhoneNumber();

        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            // Create an intent to initiate a phone call
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phoneNumber));

            // Check if there's a phone app available to handle the intent
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // Handle the case where no phone app is available
                Toast.makeText(this, "No phone app available.", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Handle the case where the phone number is not available
            Toast.makeText(this, "Phone number not available.", Toast.LENGTH_SHORT).show();
        }
    }

    // Replace this with your logic to retrieve the phone number associated with the item
    private String getPhoneNumber() {
        // Replace with your logic to retrieve the phone number based on the item
        // For example, you can use a map or database to store and retrieve phone numbers.
        // In this example, return a dummy phone number.
        return "1234567890";
    }

}
