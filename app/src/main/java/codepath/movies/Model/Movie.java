package codepath.movies.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by andrj148 on 7/19/16.
 */
public class Movie {
    String posterPath;
    String title;
    String overview;
    String releaseDate;
    private static final String basePosterPathURL = "https://image.tmdb.org/t/p/w342";


    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return basePosterPathURL + posterPath;
    }

    public String getTitle() {
        return title;
    }

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.releaseDate = jsonObject.getString("release_date");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {

            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return results;
    }
}
