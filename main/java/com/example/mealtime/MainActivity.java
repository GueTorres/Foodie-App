package com.example.mealtime;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<MealItem> foodData;
    private MealItemAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CardView mealCard = findViewById(R.id.mealCard);
        mealCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        int gridColumnCount =
                getResources().getInteger(R.integer.grid_column_count);

        // Initialize the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerView);

        // Set the Layout Manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the ArrayList that will contain the data.
        foodData = new ArrayList<>();

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = new MealItemAdapter(this, foodData);
        mRecyclerView.setAdapter(mAdapter);

        // Get the data.
        initializeData();

        RecyclerView recList = (RecyclerView) findViewById(R.id.recyclerView);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchAddItem();
            }
        });
    }

    public void launchAddItem(){

        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeData() {
        // Get the resources from the XML file.

        TypedArray foodImageResources =
                getResources().obtainTypedArray(R.array.food_images);

        String[] foodList = getResources()
                .getStringArray(R.array.food_titles);
        String[] foodInfo = getResources()
                .getStringArray(R.array.food_description);

        String[] foodIngredients = getResources()
                .getStringArray(R.array.food_ingredients);
        String[] foodCalories = getResources()
                .getStringArray(R.array.food_calories);
        String[] foodWebLink = getResources()
                .getStringArray(R.array.food_webLink);
        // Clear the existing data (to avoid duplication).
        foodData.clear();

        // Create the ArrayList of Sports objects with titles and
        // information about each sport.
        for(int i=0;i<foodList.length;i++){
            foodData.add(new MealItem(foodList[i],foodInfo[i],
                    foodImageResources.getResourceId(i,0),
                    foodIngredients[i], foodCalories[i],foodWebLink[i]));
        }



        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();
    }
}
