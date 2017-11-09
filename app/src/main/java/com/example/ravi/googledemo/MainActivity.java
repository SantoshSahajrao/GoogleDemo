package com.example.ravi.googledemo;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesUtil;

public class MainActivity extends AppCompatActivity implements LocationListener {

    Button btnMap, mbtnPosiotn;

    TextView mTxtLat, mTxtLog;
    LocationManager locationManager;
    Location location;
    double mtemlat,mtemlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        setContentView(R.layout.activity_main);
        btnMap = findViewById(R.id.btnMap);
        mTxtLat = findViewById(R.id.lat);
        mTxtLog = findViewById(R.id.lag);
        mbtnPosiotn = findViewById(R.id.btnPo);
        mbtnPosiotn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return ;
                }
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,0,MainActivity.this);





            }
        });


        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {

        if (location !=null) {
            double lat = location.getLatitude();


            double lag = location.getLongitude();

                Toast.makeText(MainActivity.this, "lat =" + lat, Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "log =" + lag, Toast.LENGTH_LONG).show();

        }


        }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
