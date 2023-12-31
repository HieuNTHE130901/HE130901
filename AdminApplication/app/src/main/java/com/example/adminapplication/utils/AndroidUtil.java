package com.example.adminapplication.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.adminapplication.models.User;

public class AndroidUtil {
    public static  void showToast(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    public static void passUserModelAsIntent(Intent intent, User model){
        intent.putExtra("username",model.getName());
        intent.putExtra("address",model.getAddress());
        intent.putExtra("phone",model.getPhone());
        intent.putExtra("email",model.getEmail());
        intent.putExtra("uid",model.getUid());


    }

    public static User getUserModelFromIntent(Intent intent){
        User userModel = new User();
        userModel.setName(intent.getStringExtra("username"));
        userModel.setAddress(intent.getStringExtra("address"));
        userModel.setEmail(intent.getStringExtra("email"));
        userModel.setPhone(intent.getStringExtra("phone"));
        userModel.setUid(intent.getStringExtra("uid"));

        return userModel;
    }
}
