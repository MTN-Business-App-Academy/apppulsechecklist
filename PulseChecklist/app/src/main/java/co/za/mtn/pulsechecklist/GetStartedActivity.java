package co.za.mtn.pulsechecklist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        ImageView logoIcon = findViewById(R.id.logo_icon);

        TextView welcomeText = findViewById(R.id.welcome_text);

        welcomeText.setAnimation(fadeInAnimation);


        Button button = findViewById(R.id.button);

        button.setAnimation(fadeInAnimation);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(GetStartedActivity.this, ModulesActivity.class);

                GetStartedActivity.this.startActivity(mainIntent);
                GetStartedActivity.this.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.get_started_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Toast.makeText(this, "Go to mtn.co.za", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}