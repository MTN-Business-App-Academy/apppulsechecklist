package co.za.mtn.pulsechecklist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
<<<<<<< Updated upstream
=======
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
>>>>>>> Stashed changes
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        // Get relative layout
        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout);
        // Get image view
        ImageView imageView = findViewById(R.id.imageView);

        // Click on relative layout
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Pulse Checklist", Toast.LENGTH_SHORT).show();
            }
        });

        // Long click for logo
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mtnPop();
                return false;
            }
        });

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                //Create an Intent that will start the GetStartedActivity.
                Intent mainIntent = new Intent(SplashActivity.this, GetStartedActivity.class);

<<<<<<< Updated upstream
                SplashActivity.this.startActivity(mainIntent);
=======
                Pair[] animationPairs = new Pair[1];
                animationPairs[0] = new Pair<View, String>(imageView, "logo_icon");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this, animationPairs);

                startActivity(mainIntent, options.toBundle());
>>>>>>> Stashed changes

                // Kill activity
                finish();
            }
        }, 3000);
    }

    public void mtnPop() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("About");
        alertBuilder.setMessage("Go to https://www.mtn.co.za to learn more.");

        alertBuilder.setPositiveButton("Later", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        alertBuilder.setCancelable(true);
        alertBuilder.create().show();
    }
}