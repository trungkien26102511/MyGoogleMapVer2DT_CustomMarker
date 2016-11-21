package com.example.kien.mygooglemapver2dt;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by Kien on 11/21/2016.
 */

public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

//============================================================================
    private Activity context;
    private Bitmap btmp;
    public MyInfoWindowAdapter(Activity context,Bitmap result)
    {
        this.context=context;
        this.btmp=result;
    }
    @Override
    public View getInfoContents(Marker arg0) {
// Getting view from the layout file info_window_layout
        View v = this.context.getLayoutInflater().inflate(R.layout.custom_info, null);

// Getting the position from the marker
        LatLng latLng = arg0.getPosition();

// Getting reference to the TextView to set latitude
        TextView tvLat = (TextView) v.findViewById(R.id.tv_lat);

// Getting reference to the TextView to set longitude
        TextView tvLng = (TextView) v.findViewById(R.id.tv_lng);

        TextView tvTitle = (TextView) v.findViewById(R.id.tv_title);

        TextView tvSnippet = (TextView) v.findViewById(R.id.tv_snippet);

        ImageView imgdrthanh=(ImageView) v.findViewById(R.id.img_drthanh);

// Setting the latitude
        tvLat.setText("Latitude:" + latLng.latitude);

// Setting the longitude
        tvLng.setText("Longitude:"+ latLng.longitude);

        tvTitle.setText(arg0.getTitle());
        tvSnippet.setText(arg0.getSnippet());
        imgdrthanh.setImageBitmap(btmp);
        return v;
    }

    @Override
    public View getInfoWindow(Marker arg0) {

        return null;
    }

}
