package com.example.mealtime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class Receiver extends BroadcastReceiver {

    private static final String I_AM_HOME =
            BuildConfig.APPLICATION_ID + ".I_AM_HOME";

    private ArrayList<MealItem> foodData;

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction){
                case I_AM_HOME:

                        Random number = new Random();
                        int rand = number.nextInt(10);
                        MealItem randomMeal = foodData.get(rand);
                        Intent detailIntent = new Intent(context,MealItemDetail.class);
                        detailIntent.putExtra("title", randomMeal.getTitle());
                        detailIntent.putExtra("image_resource", randomMeal.getImageResource());
                        detailIntent.putExtra("description", randomMeal.getDescription());
                        detailIntent.putExtra("ingredients",randomMeal.getIngredients());
                        detailIntent.putExtra("calories", randomMeal.getCalories());
                        detailIntent.putExtra("web_link", randomMeal.getWebLink());
                        context.startActivity(detailIntent);

                        toastMessage = "Happy Cooking" + randomMeal.getTitle();
                    }}
    }
}
