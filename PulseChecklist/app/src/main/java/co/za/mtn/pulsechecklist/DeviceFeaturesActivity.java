package co.za.mtn.pulsechecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import co.za.mtn.pulsechecklist.adapters.DeviceFeaturesArrayAdapter;
import co.za.mtn.pulsechecklist.adapters.ModulesArrayAdapter;
import co.za.mtn.pulsechecklist.data.DeviceFeature;
import co.za.mtn.pulsechecklist.devicefeatures.CaptureImageActivity;
import co.za.mtn.pulsechecklist.devicefeatures.PlaySoundActivity;
import co.za.mtn.pulsechecklist.devicefeatures.SelectPhotoActivity;

public class DeviceFeaturesActivity extends AppCompatActivity {

    private DeviceFeature[] features = {
            new DeviceFeature("Camera image", R.drawable.pulse_logo, 10, CaptureImageActivity.class),
            new DeviceFeature("Select image", R.drawable.pulse_logo, 10, SelectPhotoActivity.class),
            new DeviceFeature("Play sound", R.drawable.pulse_logo, 10, PlaySoundActivity.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_features);
        ListView listView = findViewById(R.id.listView);

        DeviceFeaturesArrayAdapter adapter = new DeviceFeaturesArrayAdapter(this, R.layout.layout_device_feature_item_view, features);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DeviceFeature feature = features[i];
                Intent mainIntent = new Intent(DeviceFeaturesActivity.this, feature.getaClass());

                DeviceFeaturesActivity.this.startActivity(mainIntent);
            }
        });
    }
}