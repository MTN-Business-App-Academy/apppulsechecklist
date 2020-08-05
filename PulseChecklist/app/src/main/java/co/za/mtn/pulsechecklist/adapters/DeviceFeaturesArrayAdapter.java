package co.za.mtn.pulsechecklist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import co.za.mtn.pulsechecklist.R;
import co.za.mtn.pulsechecklist.data.DeviceFeature;
import co.za.mtn.pulsechecklist.data.Module;

public class DeviceFeaturesArrayAdapter extends ArrayAdapter<DeviceFeature> {
    private Context context;
    private DeviceFeature[] features;

    public DeviceFeaturesArrayAdapter(@NonNull Context context, int resource, @NonNull DeviceFeature[] features){
        super(context, resource, features);
        this.context = context;
        this.features = features;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_device_feature_item_view, parent, false);

        DeviceFeature feature = features[position];

        ImageView featurePicture = rowView.findViewById(R.id.featurePicture);
        TextView featureName = rowView.findViewById(R.id.featureName);
        TextView featurePoints = rowView.findViewById(R.id.featurePoints);

        featurePicture.setImageResource(feature.getImageReference());
        featureName.setText(feature.getName());
        featurePoints.setText(feature.getPoints() + " points");

        return rowView;
    }
}
