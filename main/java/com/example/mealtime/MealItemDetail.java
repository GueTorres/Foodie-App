package com.example.mealtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MealItemDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_item_detail);

        ImageView mealImage = findViewById(R.id.foodImageDetail);
        TextView mealTitle = findViewById(R.id.titleDetail);
        TextView mealDescription = findViewById(R.id.descriptionDetail);
        TextView mealIngredients = findViewById(R.id.ingredientsDetail);
        TextView mealCalories = findViewById(R.id.caloriesDetail);
        TextView mealWebLink = findViewById(R.id.webLinkDetail);

        Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
                .into(mealImage);
        mealTitle.setText(getIntent().getStringExtra("title"));
        mealDescription.setText(getIntent().getStringExtra("description"));
        mealIngredients.setText(getIntent().getStringExtra("ingredients"));
        mealCalories.setText(getIntent().getStringExtra("calories"));
        mealWebLink.setText(getIntent().getStringExtra("web_link"));


    }
}
