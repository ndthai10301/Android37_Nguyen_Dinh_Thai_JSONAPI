package com.example.jsonexample_mr_thai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvcoord_lon,tvcoord_lat;
    TextView tvDt,tvId,tvName,tvCod,tvBase;
    TextView tvTemp,tvpressure,tvhumidity,tvtemp_min,tvtemp_max,tvsea_level,tvgrnd_level;
    TextView tvspeed,tvdeg;
    TextView tvclouds;
    TextView tvmessage,tvcountry,tvsunrise,tvsunset;
    TextView tvidweather;
    Button btnRunGetJSon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.title_str);
        tvDt= findViewById(R.id.tvdt);
        tvId=findViewById(R.id.tvId);
        tvName=findViewById(R.id.tvName);
        tvCod=findViewById(R.id.tvCod);
        //--------------------------------------
        tvcoord_lat=findViewById(R.id.tvLat);
        tvcoord_lon=findViewById(R.id.tvLon);
        //------------------------------------------
        tvBase=findViewById(R.id.tvBase);
        tvTemp=findViewById(R.id.tvTemp);
        tvpressure=findViewById(R.id.tvPresure);
        tvhumidity=findViewById(R.id.tvHumidity);
        tvtemp_min=findViewById(R.id.tvTemp_min);
        tvtemp_max=findViewById(R.id.tvTemp_max);
        tvsea_level=findViewById(R.id.tvSea_level);
        tvgrnd_level=findViewById(R.id.tvGrnd_level);
        //-------------------------
        tvspeed=findViewById(R.id.tvSpeed);
        tvdeg=findViewById(R.id.tvDeg);
        //-------------------------------------
        tvclouds=findViewById(R.id.tvCloud);
        //------------------------------------------
        tvmessage=findViewById(R.id.tvMessage);
        tvcountry=findViewById(R.id.tvCountry);
        tvsunrise=findViewById(R.id.tvSunrise);
        tvsunset=findViewById(R.id.tvSunset);
        //-----------------------------------------
        tvidweather=findViewById(R.id.tvIdWeather);
        btnRunGetJSon= findViewById(R.id.btnRun);
        btnRunGetJSon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            runGetJsonString(v);
            }
        });



    }
    public void runGetJsonString(View view)
    {
        try {
            // Đọc file: res/raw/company.json và trả về đối tượng Company.
            ObjectJson objectJson = ReadingJsonFile.readFileJson(this);
            tvDt.setText(objectJson.getDt());
            tvName.setText(objectJson.getName());
            tvId.setText(objectJson.getId());
            tvCod.setText(objectJson.getCod());
            tvBase.setText(objectJson.getBase());
            tvcoord_lon.setText(objectJson.getCoord().getLon());
            tvcoord_lat.setText(objectJson.getCoord().getLat());
            tvTemp.setText(objectJson.getMainob().getTemp());
            tvpressure.setText(objectJson.getMainob().getPressure());
            tvhumidity.setText(objectJson.getMainob().getHumidity());
            tvtemp_min.setText(objectJson.getMainob().getTemp_min());
            tvtemp_max.setText(objectJson.getMainob().getTemp_max());
            tvsea_level.setText(objectJson.getMainob().getSea_level());
            tvgrnd_level.setText(objectJson.getMainob().getGrnd_level());
            tvspeed.setText(objectJson.getWind().getSpeed());
            tvdeg.setText(objectJson.getWind().getDeg());
            tvclouds.setText(objectJson.getClouds().getAll());
            tvmessage.setText(objectJson.getSys().getMessage());
            tvcountry.setText(objectJson.getSys().getCountry());
            tvsunrise.setText(objectJson.getSys().getSunrise());
            tvsunset.setText(objectJson.getSys().getSunset());
           // tvidweather.setText(objectJson.getWeathers().toString();
            //jsontext.setText(company.toString());
            Toast.makeText(getBaseContext(),"Đọc dữ liệu thành công !",Toast.LENGTH_LONG).show();
        }catch(Exception e)  {
            Toast.makeText(getBaseContext(),"Error: "+ e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
