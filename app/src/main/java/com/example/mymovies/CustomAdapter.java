package com.example.mymovies;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movies> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movies> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        ImageView ivRating = rowView.findViewById(R.id.imageViewRating);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);

        Movies currentMovies = movieList.get(position);
        tvTitle.setText(currentMovies.getTitle());
        tvGenre.setText(currentMovies.getGenre());
        tvYear.setText(String.valueOf(currentMovies.getYear()));


        if (currentMovies.getRating().equalsIgnoreCase("G")){
            ivRating.setImageResource(R.drawable.rating_g);
        }
        else if (currentMovies.getRating().equalsIgnoreCase("PG")){
            ivRating.setImageResource(R.drawable.rating_pg);
        }
        else if (currentMovies.getRating().equalsIgnoreCase("PG13")){
            ivRating.setImageResource(R.drawable.rating_pg13);
        }
        else if (currentMovies.getRating().equalsIgnoreCase("NC16")){
            ivRating.setImageResource(R.drawable.rating_nc16);
        }
        else if (currentMovies.getRating().equalsIgnoreCase("M18")){
            ivRating.setImageResource(R.drawable.rating_m18);
        }
        else if (currentMovies.getRating().equalsIgnoreCase("R21")){
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        return rowView;

    }
}