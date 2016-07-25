package codepath.movies;

import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by andrj148 on 7/24/16.
 */
public class QuickPlayActivity extends YouTubeBaseActivity {
    private static final String youTubeAPIkey = "AIzaSyB86A2X3nfrMfN90JmnBP_qOy8xyN3glDg";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.item_movie);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youTubeView);

        youTubePlayerView.initialize(youTubeAPIkey, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("5xVh-7ywKpE");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("", "No video to play");
            }
        });
    }
}
