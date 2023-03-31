package com.websarva.wings.android.myapplication_test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.view.View;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.content.pm.PackageManager;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.websarva.wings.android.myapplication_test1.databinding.ActivityToiletMapsBinding;

public class toiletMapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private double _latitude = 0;
    private double _longitude = 0;
    private FusedLocationProviderClient _fusedLocationClient;
    private LocationRequest _locationRequest;
    public OnUpdateLocation _onUpdateLocation;
    private GoogleMap mMap;
    private ActivityToiletMapsBinding binding;
    private Marker mMarker;

    public class OnUpdateLocation extends LocationCallback {
        public void onLocationResult(@NonNull LocationResult locationResult) {
            //直近の位置情報を取得する。
            Location location = locationResult.getLastLocation();
            if (location != null) {
                _latitude = location.getLatitude();
                _longitude = location.getLongitude();
                LatLng latLng = new LatLng(_latitude, _longitude);
                if(mMarker==null){
                    //現在地を表示する。
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(_latitude, _longitude), 15));
                    mMarker=mMap.addMarker(new MarkerOptions().position(latLng).title("現在地"));}
                else{mMarker.setPosition(latLng);}




            }
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityToiletMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        _fusedLocationClient = LocationServices.getFusedLocationProviderClient(toiletMapsActivity.this);
        LocationRequest.Builder builder = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000);
        _locationRequest = builder.build();
        //位置情報が変更されたときの処理を行うコールバックオブジェクトを作成
        _onUpdateLocation = new OnUpdateLocation();
    }
    protected void onResume() {
        super.onResume();
        //位置情報の追跡開始
        if (ActivityCompat.checkSelfPermission(toiletMapsActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //許可をACCESS_FINE_LOCATIONとACCESS_COARSE_LOCATIONに設定
            String[] permissions={android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
            ActivityCompat.requestPermissions(toiletMapsActivity.this,permissions,1000);
            //onResume()メソッドを終了
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        _fusedLocationClient.requestLocationUpdates(_locationRequest, _onUpdateLocation, Looper.getMainLooper());



    }



    protected void onPause(){
        super.onPause();

        //位置情報の追跡を停止
        _fusedLocationClient.removeLocationUpdates(_onUpdateLocation);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng toilet1 = new LatLng(35.6788805, 139.6744167);
        mMap.addMarker(new MarkerOptions().position(toilet1).title("七号通り公園トイレ"));
        LatLng toilet2 = new LatLng(35.6470033, 139.7071389);
        mMap.addMarker(new MarkerOptions().position(toilet2).title("恵比寿公園 公衆トイレ"));
        LatLng toilet3 = new LatLng(35.6641552, 139.7020304);
        mMap.addMarker(new MarkerOptions().position(toilet3).title("神宮通公園トイレ「あまやどり」"));
        LatLng toilet4 = new LatLng(35.6596473, 139.6915147);
        mMap.addMarker(new MarkerOptions().position(toilet4).title("鍋島松濤公園トイレ"));
        LatLng toilet5 = new LatLng(35.6474265, 139.7094421);
        mMap.addMarker(new MarkerOptions().position(toilet5).title("恵比寿駅西口公衆トイレ"));
        LatLng toilet6 = new LatLng(35.6263022, 139.7235012);
        mMap.addMarker(new MarkerOptions().position(toilet6).title("五反田駅トイレ（多機能トイレ）"));
        LatLng toilet7 = new LatLng(35.4649794, 139.6234312);
        mMap.addMarker(new MarkerOptions().position(toilet7).title("横浜駅東口公衆トイレ"));
        LatLng toilet8 = new LatLng(35.6722444, 139.6910605);
        mMap.addMarker(new MarkerOptions().position(toilet8).title("はるのおがわコミュニティパーク 透明トイレ"));
        LatLng toilet9 = new LatLng(35.63026610000001, 139.7913703);
        mMap.addMarker(new MarkerOptions().position(toilet9).title("東京ビッグサイト駅トイレ"));
        LatLng toilet10 = new LatLng(35.6805524, 139.703938);
        mMap.addMarker(new MarkerOptions().position(toilet10).title("裏参道公衆トイレ"));
        LatLng toilet11 = new LatLng(35.7156059, 139.7971127);
        mMap.addMarker(new MarkerOptions().position(toilet11).title("浅草寺 公衆トイレ(北)"));
        LatLng toilet12 = new LatLng(35.6712614, 139.6929508);
        mMap.addMarker(new MarkerOptions().position(toilet12).title("代々木公園①トイレ"));
        LatLng toilet13 = new LatLng(35.6764325, 139.7640898);
        mMap.addMarker(new MarkerOptions().position(toilet13).title("お手洗"));
        LatLng toilet14 = new LatLng(35.6222948, 139.7289834);
        mMap.addMarker(new MarkerOptions().position(toilet14).title("御成橋公園 公衆トイレ"));
        LatLng toilet15 = new LatLng(35.6713621, 139.7049302);
        mMap.addMarker(new MarkerOptions().position(toilet15).title("スシニンジャトイレ"));
        LatLng toilet16 = new LatLng(35.690347, 139.84596);
        mMap.addMarker(new MarkerOptions().position(toilet16).title("都営新宿線東大島駅 多機能トイレ"));
        LatLng toilet17 = new LatLng(35.63491339999999, 139.7462362);
        mMap.addMarker(new MarkerOptions().position(toilet17).title("公衆トイレ"));
        LatLng toilet18 = new LatLng(35.6470698, 139.7498874);
        mMap.addMarker(new MarkerOptions().position(toilet18).title("公衆トイレ"));
        LatLng toilet19 = new LatLng(35.62974, 139.7425605);
        mMap.addMarker(new MarkerOptions().position(toilet19).title("こうなん星の公園公衆トイレ"));
        LatLng toilet20 = new LatLng(35.63468630000001, 139.7427796);
        mMap.addMarker(new MarkerOptions().position(toilet20).title("障害者用公衆トイレ"));
        LatLng toilet21 = new LatLng(35.6286112, 139.7507437);
        mMap.addMarker(new MarkerOptions().position(toilet21).title("港南緑水公園内公衆トイレ"));
        LatLng toilet22 = new LatLng(35.6481276, 139.7481119);
        mMap.addMarker(new MarkerOptions().position(toilet22).title("トイレ"));
        LatLng toilet23 = new LatLng(35.6548951, 139.7631777);
        mMap.addMarker(new MarkerOptions().position(toilet23).title("中央広場トイレ"));
        LatLng toilet24 = new LatLng(35.6571805, 139.7527701);
        mMap.addMarker(new MarkerOptions().position(toilet24).title("芝大門 公衆トイレ"));
        LatLng toilet25 = new LatLng(35.6288278, 139.7465429);
        mMap.addMarker(new MarkerOptions().position(toilet25).title("港南公園(Ａ面)内公衆トイレ"));
        LatLng toilet26 = new LatLng(35.6243345, 139.7469638);
        mMap.addMarker(new MarkerOptions().position(toilet26).title("港南公園(Ｄ面)内公衆トイレ"));
        LatLng toilet27 = new LatLng(35.73735920000001, 139.7858169);
        mMap.addMarker(new MarkerOptions().position(toilet27).title("公園トイレ"));
        LatLng toilet28 = new LatLng(35.7338904, 139.8084182);
        mMap.addMarker(new MarkerOptions().position(toilet28).title("公衆トイレ"));
        LatLng toilet29 = new LatLng(35.7296103, 139.7821232);
        mMap.addMarker(new MarkerOptions().position(toilet29).title("公園トイレ"));
        LatLng toilet30 = new LatLng(35.7417216, 139.786354);
        mMap.addMarker(new MarkerOptions().position(toilet30).title("荒川区立荒川自然公園内トイレ"));
        LatLng toilet31 = new LatLng(35.7406008, 139.785531);
        mMap.addMarker(new MarkerOptions().position(toilet31).title("トイレ"));
        LatLng toilet32 = new LatLng(35.7389386, 139.7736859);
        mMap.addMarker(new MarkerOptions().position(toilet32).title("荒川区立荒川五丁目児童遊園トイレ"));
        LatLng toilet33 = new LatLng(35.7364535, 139.7844065);
        mMap.addMarker(new MarkerOptions().position(toilet33).title("荒川区立荒川公園多機能トイレ（北側）"));
        LatLng toilet34 = new LatLng(35.7352677, 139.7840469);
        mMap.addMarker(new MarkerOptions().position(toilet34).title("荒川区立荒川公園トイレ（南側）"));
        LatLng toilet35 = new LatLng(35.7509381, 139.7574972);
        mMap.addMarker(new MarkerOptions().position(toilet35).title("荒川区立多機能公衆トイレ"));
        LatLng toilet36 = new LatLng(35.7376874, 139.7838392);
        mMap.addMarker(new MarkerOptions().position(toilet36).title("荒川区立荒川二丁目南公園公衆トイレ"));
        LatLng toilet37 = new LatLng(35.70072209999999, 139.7770803);
        mMap.addMarker(new MarkerOptions().position(toilet37).title("台東一丁目公衆トイレ"));
        LatLng toilet38 = new LatLng(35.7240965, 139.7983076);
        mMap.addMarker(new MarkerOptions().position(toilet38).title("台東区立日本堤公園 公衆トイレ"));
        LatLng toilet39 = new LatLng(35.710855, 139.7985322);
        mMap.addMarker(new MarkerOptions().position(toilet39).title("台東区立隅田公園 公衆トイレ"));
        LatLng toilet40 = new LatLng(35.7229432, 139.7985599);
        mMap.addMarker(new MarkerOptions().position(toilet40).title("下水ポンプ場脇 公衆トイレ"));
        LatLng toilet41 = new LatLng(35.7124639, 139.7822064);
        mMap.addMarker(new MarkerOptions().position(toilet41).title("龍谷寺脇 公衆トイレ"));
        LatLng toilet42 = new LatLng(35.7145122, 139.8022768);
        mMap.addMarker(new MarkerOptions().position(toilet42).title("台東区隅田公園 公衆トイレ"));
        LatLng toilet43 = new LatLng(35.7274241, 139.8022876);
        mMap.addMarker(new MarkerOptions().position(toilet43).title("台東区立玉姫公園公衆トイレ"));
        LatLng toilet44 = new LatLng(35.7037277, 139.7890232);
        mMap.addMarker(new MarkerOptions().position(toilet44).title("精華公園 公衆トイレ"));
        LatLng toilet45 = new LatLng(35.71937399999999, 139.8055467);
        mMap.addMarker(new MarkerOptions().position(toilet45).title("台東区立隅田公園 公衆トイレ(野球場)"));
        LatLng toilet46 = new LatLng(35.7170426, 139.7855703);
        mMap.addMarker(new MarkerOptions().position(toilet46).title("入谷南公園 公衆トイレ"));



    }

}