package com.example.mealtime;


public class MealItem   {

	private String title;
	private String description;
	private final int imageResource;
	private String calories;
	private String ingredients;
	private String webLink;

	public MealItem(String title, String description, int imageResource, String calories,
					String ingredients, String webLink){
		this.title = title;
		this.description = description;
		this.imageResource = imageResource;
		this.calories = calories;
		this.ingredients = ingredients;
		this.webLink = webLink;
	}

	String getTitle() {return title;}

	String getDescription(){ return description;}

	public int getImageResource() { return imageResource;}

	String getIngredients() { return ingredients;}

    String getCalories() { return calories;}

    String getWebLink(){return webLink;}
}
