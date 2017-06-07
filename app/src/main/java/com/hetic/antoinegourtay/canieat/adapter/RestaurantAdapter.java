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

import org.w3c.dom.Text;

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

        TextView restaurantName = (TextView) convertView.findViewById(R.id.restaurant_name);
        TextView restaurantAdresse = (TextView) convertView.findViewById(R.id.restaurant_adresse);
        TextView restaurantIsOpen = (TextView) convertView.findViewById(R.id.restaurant_isopen);

        if (restaurant != null) {
            restaurantName.setText(restaurant.getName());
            restaurantAdresse.setText(restaurant.getVincinity());

            if (restaurant.getOpenning_hours().isOpen_now()){
                restaurantIsOpen.setText("Ouvert");
            } else {
                restaurantIsOpen.setText("Fermé");
            }
        }

        return convertView;
    }


}
