package com.hetic.antoinegourtay.canieat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hetic.antoinegourtay.canieat.R;
import com.hetic.antoinegourtay.canieat.model.Recipe;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

/**
 * Created by antoinegourtay on 06/06/2017.
 */

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    public RecipeAdapter(Context context, ArrayList<Recipe> recipes) {
        super(context, 0, recipes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Recipe recipe = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_recipe, parent, false);
        }

        TextView recipeName = (TextView) convertView.findViewById(R.id.recipe_name);
        TextView recipeDuration = (TextView) convertView.findViewById(R.id.recipe_duration);
        TextView recipeDifficulty = (TextView) convertView.findViewById(R.id.recipe_difficulty);
        TextView recipeIngredients = (TextView) convertView.findViewById(R.id.recipe_ingredients);
        TextView recipeRecipe = (TextView) convertView.findViewById(R.id.recipe_recipe);

        if (recipe != null) {
            recipeName.setText(recipe.getName());
            recipeDuration.setText(recipe.getDuration());
            recipeDifficulty.setText(recipe.getDifficulty());
            recipeIngredients.setText(recipe.getIngredients());
            recipeRecipe.setText(recipe.getRecipe());
        }

        return convertView;
    }


}
