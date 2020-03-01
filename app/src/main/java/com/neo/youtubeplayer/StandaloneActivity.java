package com.neo.youtubeplayer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        Button btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        Button btnPlaylist = (Button) findViewById(R.id.btnPlayList);

//        "this" means that we are using an instance of the View.OnClickListener interface
        btnPlayVideo.setOnClickListener(this);
        btnPlaylist.setOnClickListener(this);

//        View.OnClickListener ourListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        };
//        btnPlayVideo.setOnClickListener(ourListener);
//        btnPlaylist.setOnClickListener(ourListener);
//
//        btnPlayVideo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch(view.getId()){
            case R.id.btnPlayVideo:
                // uses the intent.create video method to play videos
                // creating an Intent is not need since the YoutubeStandalonePlayer class does it.
//              uses overloaded version of the createVideoIntent method # context, dev key, videoid, timeinto video for playback, autoplay boolean and lightboxMode boolean(set to false for fullscreen display).
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0, true, false);
                break;

            case R.id.btnPlayList:
                //  uses the intent.cretaePlaylist method to create a playlist of videos.
//              uses overloaded version of the createVideoIntent method # context, dev key, videoid, startIndex set to 0 to start playing from first vif in playlist, timeinto video for playback, autoplay boolean and lightboxMode boolean.
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST,0, 0, true, true);
                break;
            default:
        }

//
        if(intent != null){
            startActivity(intent);
        }


    }
}
