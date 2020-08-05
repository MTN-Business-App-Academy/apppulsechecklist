package co.za.mtn.pulsechecklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import co.za.mtn.pulsechecklist.data.Module;

public class ModuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = findViewById(R.id.moduleImage);
        TextView moduleName = findViewById(R.id.moduleName);
        TextView moduleLabel = findViewById(R.id.moduleLabel);

        Module module = (Module) getIntent().getSerializableExtra(ModulesActivity.MODULE);

        toolbar.setTitle(module.getName());
        moduleName.setText(module.getName());
        imageView.setImageResource(module.getImageReference());
        moduleLabel.setText(module.getLabel());
    }
}