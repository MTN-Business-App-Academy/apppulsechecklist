package co.za.mtn.pulsechecklist.devicefeatures;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import co.za.mtn.pulsechecklist.R;

public class GetLocationActivity extends AppCompatActivity implements LocationListener {
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        findViewById(R.id.getLocation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(GetLocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(GetLocationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                    return;
                }
                Toast.makeText(view.getContext(), "Please wait", Toast.LENGTH_SHORT).show();
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, GetLocationActivity.this);
            }
        });
    }

    private void requestPermission() {
        String[] PERMISSIONS = {android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION};
        ActivityCompat.requestPermissions(GetLocationActivity.this, PERMISSIONS, 0);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 0: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }

                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, GetLocationActivity.this);
                } else {
                    Toast.makeText(this, "The app was not allowed to access your location", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        String longitude = "Longitude: " + location.getLongitude();
        String latitude = "Latitude: " + location.getLatitude();

        String cityName = null;

        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = gcd.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            cityName = addresses.get(0).getLocality();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String stringAddress = longitude + "\n" + latitude + "\n\nMy Current City is: " + cityName;

        TextView textView = findViewById(R.id.textView);

        textView.setText(stringAddress);
    }
}