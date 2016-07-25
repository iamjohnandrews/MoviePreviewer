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
    private static final String youTubeAPIkey = "AIzaSyB86A2X3nfrMfN90JmnBP_qOy8xyN3glDg";

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflator = LayoutInflater.from(getContext());
            convertView = inflator.inflate(R.layout.item_movie, parent, false);
        }

       setContentOfUIElements(convertView, getItem(position));

        return convertView;
    }

    private void setContentOfUIElements(View convertView, Movie currentMovie) {
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        tvTitle.setText(currentMovie.getTitle());
        tvOverview.setText(currentMovie.getOverview());

        String currentMovieImageURL = currentMovie.getPosterPath();

        Picasso.with(getContext()).load(currentMovieImageURL).into(ivImage);
        Picasso.with(getContext()).load(currentMovieImageURL).transform(new RoundedCornersTransformation(50, 10)).into(ivImage);
    }
}
