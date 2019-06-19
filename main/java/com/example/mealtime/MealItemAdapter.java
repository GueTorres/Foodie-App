package com.example.mealtime;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MealItemAdapter extends RecyclerView.Adapter<MealItemAdapter.ViewHolder> {

    private ArrayList<MealItem> foodData;
    private Context mContext;

    MealItemAdapter(Context context, ArrayList<MealItem> foodData){
        this.foodData = foodData;
        this.mContext = context;}

    @Override
    public MealItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MealItemAdapter.ViewHolder viewHolder, int i) {
        // Get current sport.
        MealItem currentMeal = foodData.get(i);

        // Populate the textviews with data.
        viewHolder.bindTo(currentMeal);
    }

    @Override
    public int getItemCount() {
        return foodData.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mDescriptionText;
        private ImageView mFoodImage;

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mDescriptionText = itemView.findViewById(R.id.description);
            mFoodImage = itemView.findViewById(R.id.foodImage);

            itemView.setOnClickListener(this);
        }

        void bindTo(MealItem currentMeal){
            // Populate the textviews with data.
            mTitleText.setText(currentMeal.getTitle());
            mDescriptionText.setText(currentMeal.getDescription());
            Glide.with(mContext).load(currentMeal.getImageResource()).into(mFoodImage);

        }

        @Override
        public void onClick(View v) {
            MealItem currentMeal = foodData.get(getAdapterPosition());

            Intent detailIntent = new Intent(mContext,MealItemDetail.class);
            detailIntent.putExtra("title", currentMeal.getTitle());
            detailIntent.putExtra("image_resource", currentMeal.getImageResource());
            detailIntent.putExtra("description", currentMeal.getDescription());
            detailIntent.putExtra("ingredients",currentMeal.getIngredients());
            detailIntent.putExtra("calories", currentMeal.getCalories());
            detailIntent.putExtra("web_link", currentMeal.getWebLink());
            mContext.startActivity(detailIntent);
        }
    }
}
