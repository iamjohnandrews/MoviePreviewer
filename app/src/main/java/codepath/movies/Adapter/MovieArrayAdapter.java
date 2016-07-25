package codepath.movies.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import codepath.movies.Model.Movie;
import codepath.movies.R;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by andrj148 on 7/19/16.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        TextView movieTitle;
        TextView movieOverview;
    }

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflator = LayoutInflater.from(getContext());
            convertView = inflator.inflate(R.layout.item_movie, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.movieTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.movieOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

       setContentOfUIElements(convertView, getItem(position));
        Movie currentMovie = getItem(position);
        viewHolder.movieTitle.setText(currentMovie.getTitle());
        viewHolder.movieOverview.setText(currentMovie.getOverview());

        return convertView;
    }

    private void setContentOfUIElements(View convertView, Movie currentMovie) {
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        ivImage.setImageResource(0);

        Picasso.with(getContext()).load(currentMovie.getPosterPath()).fit().placeholder(R.drawable.coming_soon_placeholder).transform(new RoundedCornersTransformation(50, 10)).into(ivImage);
    }
}
