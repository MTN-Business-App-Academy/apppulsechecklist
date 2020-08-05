package co.za.mtn.pulsechecklist.devicefeatures;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import co.za.mtn.pulsechecklist.R;

public class PlayVideoActivity extends AppCompatActivity {
    MediaController mediaController;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        videoView = findViewById(R.id.videoView);

        videoView.setVideoURI( Uri.parse("android.resource://" + getPackageName() + "/" + "raw/video"));
        videoView.start();

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.start();
                Toast.makeText(view.getContext(), "Please wait", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}