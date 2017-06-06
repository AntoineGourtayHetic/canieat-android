package com.hetic.antoinegourtay.canieat.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.hetic.antoinegourtay.canieat.R;
import com.hetic.antoinegourtay.canieat.adapter.RecipeAdapter;
import com.hetic.antoinegourtay.canieat.model.Recipe;

import java.util.ArrayList;

public class ReceipesActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipes);

        ArrayList<Recipe> recipeArrayList = new ArrayList<Recipe>();
        RecipeAdapter recipeAdapter = new RecipeAdapter(this, recipeArrayList);
        ListView listView = (ListView) findViewById(R.id.recipes_listview);

        listView.setAdapter(recipeAdapter);

        Recipe recipe1 = new Recipe("Tarte aux poivrons", "20 minutes", "Facile",
                "1 pâte brisée végétale, 2 gros poivrons, 200 ml de soja, 1 cuillère à soupe de moutarde, 1 cuillère à café de bouillon de légume en poudre, Poivre",
                "Nettoyer et couper les poivrons en lamelles." +
                        "\n" +
                        "Faire fondre les lamelles de poivrons dans une poêle avec un peu d’huile d’olive.\n" +
                        "\n" +
                        "Dans un grand bol, mélanger la crème, la moutarde, le bouillon de légume et le poivre.\n" +
                        "\n" +
                        "Dérouler la pâte et l’étaler sur le moule à tarte, y mettre les poivrons, puis verser la préparation sur l’ensemble.\n" +
                        "\n" +
                        "Enfourner à four moyen (180° C/thermostat 6) une bonne demi-heure en surveillant la cuisson.\n" +
                        "\n" +
                        "Déguster avec une bonne salade verte ou une salade de tomates.");

        //Adding all the recipes
        recipeAdapter.add(recipe1);

    }
}
