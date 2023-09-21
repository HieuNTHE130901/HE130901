package com.example.groceryapplication.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.groceryapplication.R;
import com.example.groceryapplication.databinding.FragmentCategoryBinding; // Import the correct binding class


public class CategoryFragment extends Fragment {

    private FragmentCategoryBinding binding; // Declare the binding variable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = root.findViewById(R.id.nav_category); // Replace with the actual ID

        // Do any further setup with your views here

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
