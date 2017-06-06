package com.hetic.antoinegourtay.canieat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hetic.antoinegourtay.canieat.R;
import com.hetic.antoinegourtay.canieat.model.Recipe;
import com.hetic.antoinegourtay.canieat.model.Restaurant;

import java.util.ArrayList;

/**
 * Created by antoinegourtay on 06/06/2017.
 */

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    public RestaurantAdapter(Context context, ArrayList<Restaurant> restaurants) {
        super(context, 0, restaurants);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Restaurant restaurant = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_maps_cards, parent, false);
        }

        //Ici tu créées ce que tu veux selon ce que tu as mis dans le item_maps_cards

       // EXEMPLE : TextView restaurantName = (TextView) convertView.findViewById(R.id.recipe_name);

        if (restaurant != null) {
            //EXEMPLE restaurantName.setText(restaurant.getName());
        }

        return convertView;
    }


}
