package com.example.menuandcall;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> items = Arrays.asList(
            new Item("Item 1", R.drawable.item1, "Item 1 Description"),
            new Item("Item 2", R.drawable.item2, "Item 2 Description"),
            new Item("Item 3", R.drawable.item3, "Item 3 Description"),
            new Item("Item 4", R.drawable.item4, "Item 4 Description"),
            new Item("Item 5", R.drawable.item5, "Item 5 Description"),
            new Item("Item 6", R.drawable.item2, "Item 6 Description"),
            new Item("Item 7", R.drawable.item3, "Item 7 Description"),
            new Item("Item 8", R.drawable.item4, "Item 8 Description"),
            new Item("Item 9", R.drawable.item1, "Item 9 Description"),
            new Item("Item 10", R.drawable.item2, "Item 10 Description"),
            new Item("Item 11", R.drawable.item3, "Item 11 Description"),
            new Item("Item 12", R.drawable.item4, "Item 12 Description"),
            new Item("Item 13", R.drawable.item1, "Item 13 Description"),
            new Item("Item 14", R.drawable.item2, "Item 14 Description"),
            new Item("Item 15", R.drawable.item3, "Item 15 Description"),
            new Item("Item 16", R.drawable.item4, "Item 16 Description"),
            new Item("Item 10", R.drawable.item2, "Item 10 Description"),
            new Item("Item 11", R.drawable.item3, "Item 11 Description"),
            new Item("Item 12", R.drawable.item4, "Item 12 Description"),
            new Item("Item 13", R.drawable.item1, "Item 13 Description"),
            new Item("Item 14", R.drawable.item2, "Item 14 Description"),
            new Item("Item 15", R.drawable.item3, "Item 15 Description"),
            new Item("Item 16", R.drawable.item4, "Item 16 Description"),
            new Item("Item 17", R.drawable.item5, "Item 17 Description")

    );

    // Create a map to store item descriptions by item name
    private Map<String, String> itemDescriptions = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // RecyclerView
        recyclerView = findViewById(R.id.recyclerView);

        // Use a GridLayoutManager with 3 columns to achieve 3 items per row
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        // Initialize item descriptions in the map
        initItemDescriptions();

        itemAdapter = new ItemAdapter(items);
        recyclerView.setAdapter(itemAdapter);
        // Set item click listener
        itemAdapter.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(String itemName) {
        // Get the item description from the map
        String itemDescription = itemDescriptions.get(itemName);

        // Handle item click by showing details
        Intent intent = new Intent(this, ItemDetailActivity.class);
        intent.putExtra("item", itemName);
        intent.putExtra("description", itemDescription);
        startActivity(intent);
    }

    // Initialize item descriptions in the map
    private void initItemDescriptions() {
        for (Item item : items) {
            itemDescriptions.put(item.getName(), item.getDescription());
        }
    }
}

