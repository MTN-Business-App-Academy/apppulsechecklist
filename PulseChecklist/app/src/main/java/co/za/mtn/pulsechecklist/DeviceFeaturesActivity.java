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
import co.za.mtn.pulsechecklist.devicefeatures.GetLocationActivity;
import co.za.mtn.pulsechecklist.devicefeatures.PlaySoundActivity;
import co.za.mtn.pulsechecklist.devicefeatures.PlayVideoActivity;
import co.za.mtn.pulsechecklist.devicefeatures.SelectPhotoActivity;
import co.za.mtn.pulsechecklist.devicefeatures.ShowContactsActivity;

public class DeviceFeaturesActivity extends AppCompatActivity {

    private DeviceFeature[] features = {
            new DeviceFeature("Camera image", R.drawable.camera, 20, CaptureImageActivity.class),
            new DeviceFeature("Select image", R.drawable.gallery, 10, SelectPhotoActivity.class),
            new DeviceFeature("Play sound", R.drawable.playlist, 5, PlaySoundActivity.class),
            new DeviceFeature("Play video", R.drawable.video, 5, PlayVideoActivity.class),
            new DeviceFeature("Show contact list", R.drawable.contacts, 5, ShowContactsActivity.class),
            new DeviceFeature("Get location", R.drawable.marker, 10, GetLocationActivity.class)
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