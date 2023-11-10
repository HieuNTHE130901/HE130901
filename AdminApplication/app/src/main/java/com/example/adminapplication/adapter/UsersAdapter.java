package com.example.adminapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapplication.R;
import com.example.adminapplication.activities.ChatActivity;
import com.example.adminapplication.models.User;
import com.example.adminapplication.utils.AndroidUtil;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
public class UsersAdapter extends FirestoreRecyclerAdapter<User, UsersAdapter.UserViewHolder> {

    Context context;
    public UsersAdapter(@NonNull FirestoreRecyclerOptions<User> options, Context context) {
        super(options);
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull UserViewHolder holder, int position, @NonNull User model) {
        holder.usernameTextview.setText(model.getName());

        // Handle chat button click for the specific chat room
        holder.chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChatActivity.class);
                AndroidUtil.passUserModelAsIntent(intent,model);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView usernameTextview;
        Button chatButton;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTextview = itemView.findViewById(R.id.userName);
            chatButton = itemView.findViewById(R.id.chatButton);
        }
    }
}