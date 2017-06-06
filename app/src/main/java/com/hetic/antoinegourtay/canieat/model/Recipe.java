package com.hetic.antoinegourtay.canieat.model;

import java.util.List;

/**
 * Created by antoinegourtay on 06/06/2017.
 */

public class Recipe {

    private String name;
    private String duration;
    private String difficulty;
    private List<String> ingredients;
    private String recipe;

    public Recipe(){

    }

    public Recipe(String name, String duration, String difficulty, List<String> ingredients, String recipe) {
        this.name = name;
        this.duration = duration;
        this.difficulty = difficulty;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }

    public String getName() {
        
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
