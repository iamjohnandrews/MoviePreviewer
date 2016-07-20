package codepath.movies.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import java.util.List;

import codepath.movies.Model.Movie;

/**
 * Created by andrj148 on 7/19/16.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);

    }
}
