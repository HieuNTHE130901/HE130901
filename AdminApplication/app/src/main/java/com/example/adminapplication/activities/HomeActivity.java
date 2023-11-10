package com.example.adminapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.adminapplication.R;
import com.example.adminapplication.adapter.UsersAdapter;
import com.example.adminapplication.models.ChatRoom;
import com.example.adminapplication.models.User;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class HomeActivity extends AppCompatActivity {


    private RecyclerView userRecyclerView;
    private UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FirebaseApp.initializeApp(this);

        userRecyclerView = findViewById(R.id.chatRoomsRecyclerView);
        // Set up the RecyclerView for chat rooms
        setupUserRecyclerView();
    }

    private void setupUserRecyclerView() {
        // Define the query to fetch users from Firestore
        Query query = FirebaseFirestore.getInstance()
                .collection("users");
        FirestoreRecyclerOptions<User> options = new FirestoreRecyclerOptions.Builder<User>()
                .setQuery(query, User.class)
                .build();

        usersAdapter = new UsersAdapter(options,getApplicationContext());
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        userRecyclerView.setAdapter(usersAdapter);
        usersAdapter.startListening();
    }

}
