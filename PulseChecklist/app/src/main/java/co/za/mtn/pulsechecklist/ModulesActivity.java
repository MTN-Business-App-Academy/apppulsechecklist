package co.za.mtn.pulsechecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import co.za.mtn.pulsechecklist.adapters.ModulesArrayAdapter;
import co.za.mtn.pulsechecklist.data.Module;

public class ModulesActivity extends AppCompatActivity {

    private Module[] modules = {
            new Module("Module: Let's build", R.drawable.pulse_logo),
            new Module("Module: TBC", R.drawable.pulse_logo)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);
        ListView listView = findViewById(R.id.listView);

        ModulesArrayAdapter adapter = new ModulesArrayAdapter(this, R.layout.layout_module_item_view, modules);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(), modules[i].getName() + " clicked", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(), modules[i].getName() + " long click", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}