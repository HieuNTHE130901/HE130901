package com.example.recycleviewdemo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.view.Menu;
import android.view.MenuItem;
import com.example.recycleviewdemo.R;



public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private List<SuperHero> superHeroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize and populate the list of superheroes
        initializeSuperHeroes();

        recyclerView = findViewById(R.id.recycleview); // Corrected the ID
        MyAdapter myAdapter = new MyAdapter(superHeroList, this);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private void initializeSuperHeroes() {
        superHeroList = new ArrayList<>();
        superHeroList.add(new SuperHero("Siêu nhân đỏ", R.drawable.img, "Siêu nhân đỏ rất mạnh"));
        superHeroList.add(new SuperHero("Siêu nhân xanh", R.drawable.img_1, "Siêu nhân xanh rất khoẻ"));
        superHeroList.add(new SuperHero("Siêu nhân xanh 2", R.drawable.img_2, "Siêu nhân xanh 2 bơi giỏi"));
        superHeroList.add(new SuperHero("Siêu nhân đỏ", R.drawable.img, "Siêu nhân đỏ rất mạnh"));
        superHeroList.add(new SuperHero("Siêu nhân xanh", R.drawable.img_1, "Siêu nhân xanh rất khoẻ"));
        superHeroList.add(new SuperHero("Siêu nhân xanh 2", R.drawable.img_2, "Siêu nhân xanh 2 bơi giỏi"));
    }

    @Override
    public void onItemClick(int position) {
        SuperHero selectedHero = superHeroList.get(position);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("superhero", selectedHero);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

                return super.onOptionsItemSelected(item);
        }
    }

