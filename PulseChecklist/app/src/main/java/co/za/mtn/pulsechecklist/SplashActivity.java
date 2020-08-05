package co.za.mtn.pulsechecklist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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