package com.example.groceryapplication.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.groceryapplication.R;
import com.example.groceryapplication.databinding.FragmentProfileBinding; // Import the correct binding class


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding; // Declare the binding variable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = root.findViewById(R.id.nav_profile); // Replace with the actual ID

        // Do any further setup with your views here

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
