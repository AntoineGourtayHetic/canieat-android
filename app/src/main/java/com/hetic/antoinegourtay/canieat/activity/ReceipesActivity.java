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


        Recipe recipe2 = new Recipe("Pizza aux aubergines", "30 minutes", "Facile",
                "300g de farine blanche, deux pincés de sel, 1 sachet de levure, 20cl d'eau tiède, 3 cuillère à soupe d'huile d'olive, herbes de provence, coulis de tomate, 1 poivron rouge, & gousse d'ail, 100g de champignons de Paris, 2 aubergines",
                "Préparer la pâte :\n" +
                        "\n" +
                        "Dans un grand saladier verser les 300 g de farine. Verser successivement le sel, la levure boulangère, le sucre et l’huile d’olive. Vous pouvez aussi ajouter des herbes de Provence. Mélanger à la cuillère en bois et verser petit à petit l’eau tiède. Remuer jusqu’à ce que la pâte se détache du saladier. Ne pas hésiter à rajouter un peu de farine. Pétrir la pâte pendant 10 minutes. Recouvrir le saladier d’un torchon et laisser reposer la pâte pendant au moins 30 minutes dans un endroit chaud. Astuce : vous pouvez placer votre saladier — s’il est en verre — dans votre four au minimum (40°C).\n" +
                        "\n" +
                        "Pendant que la pâte lève, préparer la garniture.\n" +
                        "\n" +
                        "La garniture :\n" +
                        "\n" +
                        "Émincer la gousse d’ail.\n" +
                        "\n" +
                        "Couper de fine lamelles d’aubergines, salez-les et faites-les revenir dans une poêle généreusement huilée à feu moyen. N’hésitez pas à rajouter de l’huile d’olive en cours de cuisson. Placez vos lamelles d’aubergines frits dans une assiette et parsemez-les d’ail.\n" +
                        "\n" +
                        "Émincer un poivron rouge et faites-les revenir aussi dans de l’huile d’olive avec un peu de sel.\n" +
                        "\n" +
                        "Émincer très finement les champignons.\n" +
                        "\n" +
                        "Dans un bol, verser le coulis de tomate, saler, vous pouvez aussi ajouter une cuillère à café de sucre (ou le sirop d’érable). Remuer.\n" +
                        "\n" +
                        "Déposer sur votre plaque de four du papier cuisson et parsemer de farine. Une fois que la pâte à pizza a doublé, déposer-la et façonner-la à la taille de votre plaque ou en cercle.\n" +
                        "\n" +
                        "Préchauffez votre four à 200°C.\n" +
                        "\n" +
                        "Avec une cuillère à soupe, répartir la sauce tomate. Déposer des lamelles de fromage puis celles d’aubergines, les poivrons et en dernier, les champignons sur toute la pizza.\n" +
                        "Enfourner votre pizza pour 10-15 minutes.\n" +
                        "\n" +
                        "Une fois prête, sortir la pizza du four. Couper les feuilles de basilic et les placer sur la pizza.\n" +
                        "\n" +
                        "Bon appétit !");

        Recipe recipe3 = new Recipe("Gâteau à la carotte et aux amandes", "15 minutes", "Moyen", "250 g de carottes\n" +
                "120 g d’amandes pelées\n" +
                "170 g de farine blanche de blé ou d’épeautre\n" +
                "50 g de fécule de pomme de terre\n" +
                "100 g de sucre semoule de canne\n" +
                "200 ml de lait d’amande\n" +
                "60 ml d’huile végétale neutre en goût\n" +
                "Le zeste d’1 citron\n" +
                "1/2 càc. de bicarbonate\n" +
                "8 g de levure chimique (1/2 sachet)\n" +
                "1 pincée de sel\n" +
                "1 càc de cannelle\n" +
                "Un peu de sucre glace à saupoudrer sur le gâteau une fois cuit (facultatif)", "Préchauffer le four à 180° C.\n" +
                "\n" +
                "Mixer finement les amandes.\n" +
                "\n" +
                "Dans un grand saladier, verser les amandes mixées, la farine, la fécule, le sucre, le zeste de citron, le bicarbonate, le sel et la cannelle. Mélanger.\n" +
                "\n" +
                "Éplucher les carottes, les couper grossièrement et les verser dans le bol du mixeur. Mixer finement.\n" +
                "\n" +
                "Mélanger les carottes avec le reste des ingrédients.\n" +
                "\n" +
                "Mélanger le lait et l’huile et verser sur les ingrédients solides. Mélanger.\n" +
                "\n" +
                "Insérer enfin la levure, mélanger rapidement et verser la préparation dans un moule huilé et légèrement enfariné pour que le gâteau se démoule facilement après la cuisson.\n" +
                "\n" +
                "Enfourner dans un four à 180° pendant 40-45 minutes.\n" +
                "\n" +
                "Faites la preuve du couteau pour voir si le gâteau est cuit : si la lame ressort sèche, sortir le gâteau du four, sinon prolonger la cuisson de quelques minutes.\n" +
                "\n" +
                "Faire tiédir avant de démouler et saupoudrer de sucre glace.");

        Recipe recipe4 = new Recipe("Steak de bétrave et quinoa", "30 minutes", "Facile", "100 g betteraves crues hachées grossièrement\n" +
                "4 càs (100 g)  de quinoa rouge cuit (ou quinoa blanc)\n" +
                "2 càs d’arrow root 20g avec 80 ml d’eau\n" +
                "1 càs de sauce soja\n" +
                "1/2 oignon émincé (50 g)\n" +
                "1 gousse d’ail hachée\n" +
                "3 à 4 càs de chapelure (40 g)\n" +
                "2 càs d’huile", "Nastasia Froloff \n" +
                " Nastasia Froloff\n" +
                " Nastasia Froloff\n" +
                "Découvrez d'autres recettes par tags\n" +
                "\n" +
                "bluffantviande végétale\n" +
                "Préparation\n" +
                "\n" +
                "Éplucher la betterave et la hacher (par exemple avec un mixeur).\n" +
                "\n" +
                "Émincer l’oignon et le faire revenir dans 1 càs d’huile.\n" +
                "\n" +
                "Dans un saladier, mettre l’arrow root avec l’eau, le quinoa, 1 gousse d’ail, la chapelure et 1 càs de sauce soja, poivrer et mélanger le tout. Rajouter la betterave et l’oignon et mélanger à nouveau.\n" +
                "\n" +
                "Avec la pâte, former 2 steaks.\n" +
                "\n" +
                "Les cuire dans la poêle huilée pendant 5 min de chaque côté.\n" +
                "\n" +
                "Total pour 1 steak\n" +
                "Énergie = 303 Kcal\n" +
                "Protéines = 6 g\n" +
                "Lipides = 12 g\n" +
                "Glucides = 42 g\n" +
                "\n" +
                "Équivalence pour 1 steak = 1/2 portion d’aliments protéinés  + 200 g de féculents + 1 càs de matières grasses + ½ portion de légumes\n" +
                "\n" +
                " \n" +
                "\n" +
                "Note de l’équipe de L214 :\n" +
                "\n" +
                "N’hésitez pas à ajouter vos épices préférées dans la préparation pour assaisonner les steaks à votre goût !");

        Recipe recipe5 = new Recipe("Muffins Streusel aux myrilles", "45 minutes", "Moyen", "200 g de farine\n" +
                "120 g de sucre en poudre\n" +
                "1 càc de levure chimique\n" +
                "1/2 càc de bicarbonate\n" +
                "1 càc de jus de citron\n" +
                "100 g de compote de fruits\n" +
                "100 ml de lait de soja\n" +
                "100 g de myrtille\n" +
                "65 g d’huile végétale\n" +
                "Pour le crumble :\n" +
                "\n" +
                "2 càs de sucre\n" +
                "2 càs de farine\n" +
                "1 càs de margarine végétale",
                "Préchauffez votre four à 180°C. Dans un saladier, fouettez le sucre, l’huile et la compote. Ajoutez ensuite le lait de soja et le jus de citron. Mélangez à nouveau, puis incorporez délicatement les myrtilles.\n" +
                        "\n" +
                        "Enfin, versez la levure chimique, le bicarbonate et la farine. Mélangez puis à l’aide d’une cuillère à soupe, versez la préparation dans vos moules à muffins.\n" +
                        "\n" +
                        "Dans un bol, mélangez la farine et le sucre pour le crumble. Ajoutez la margarine puis mélangez du bout des doigts jusqu’à obtenir une pâte sableuse. Saupoudrez-en ensuite vos muffins puis enfournez pendant 20 minutes.\n" +
                        "\n" +
                        "Sortez vos muffins, laissez-les refroidir ou dégustez-les tièdes. J’aime beaucoup ajouter un petit filet de sucre glace mélangé à un peu d’eau pour qu’ils soient encore plus jolis !");
        //Adding all the recipes
        recipeAdapter.add(recipe1);
        recipeAdapter.add(recipe2);
        recipeAdapter.add(recipe3);
        recipeAdapter.add(recipe4);
        recipeAdapter.add(recipe5);

    }
}
