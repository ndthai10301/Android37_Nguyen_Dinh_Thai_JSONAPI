package com.example.jsonexample_mr_thai;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadingJsonFile {
    // Đọc file raw/weather.json và chuyển thành đối tượng java.
    public static ObjectJson readFileJson(Context context) throws IOException, JSONException
    {
        // Đọc nội dung text của file raw/weather.json
        String jsonText=readText(context,R.raw.weather);
        // Đối tượng JSONObject gốc mô tả toàn bộ tài liệu JSON.
        JSONObject jsonRoot= new JSONObject(jsonText);
        String dt= jsonRoot.getString("dt");
        String id1=jsonRoot.getString("id");
        String name=jsonRoot.getString("name");
        String cod= jsonRoot.getString("cod");
        String base=jsonRoot.getString("base");
        //lay thong tin coord
        JSONObject jsonCoord=jsonRoot.getJSONObject("coord");
        String lon_temp=jsonCoord.getString("lon");
        String lat_temp=jsonCoord.getString("lat");
        Coord coord= new Coord(lon_temp,lat_temp);
        ObjectJson objectJson = new ObjectJson();
        //-------------Lấy thông tin mảng weathers-----------------------
        //JSONArray jsonArrayWeather= (JSONArray)jsonRoot.get("weather");
       // JSONArray jsonArrayWeather = jsonRoot.getJSONArray("weather");
        //JSONObject jsonWeather= jsonRoot.getJSONObject("weather");
       // String[] weathers = new String[jsonArrayWeather.length()];
        //String id,main,description,icon;
//        for (int i=0;i<jsonArrayWeather.length();i++)
//        {
//            JSONObject jsonObject = jsonArrayWeather.getJSONObject(i);
//            String id= jsonObject.getString("id");
//            String main=jsonObject.getString("main");
//            String description=jsonObject.getString("description");
//            String icon=jsonObject.getString("icon");
//           // Weather weather= new Weather(id,main,description,icon);
//        }
       // objectJson.setWeathers();
        //Lay thong tin main-----------------
        JSONObject jsonMain=jsonRoot.getJSONObject("main");
        String temp=jsonMain.getString("temp");
        String pressure=jsonMain.getString("pressure");
        String humidity=jsonMain.getString("humidity");
        String temp_min=jsonMain.getString("temp_min");
        String temp_max=jsonMain.getString("temp_max");
        String sea_level=jsonMain.getString("sea_level");
        String grnd_level=jsonMain.getString("grnd_level");
        Main main1= new Main(temp,pressure,humidity,temp_min,temp_max,sea_level,grnd_level);
        //-----------------Lay thong tin Wind-----------
        JSONObject jsonWind= jsonRoot.getJSONObject("wind");
        String speed= jsonWind.getString("speed");
        String deg=jsonWind.getString("deg");
        Wind wind= new Wind(speed,deg);
        //-------------Lay thong tin Clouds
        JSONObject jsonClouds=jsonRoot.getJSONObject("clouds");
        String all=jsonClouds.getString("all");
        Clouds clouds= new Clouds(all);
        //--------------Lay thong tin Sys----------------
        JSONObject jsonSys= jsonRoot.getJSONObject("sys");
        String message=jsonSys.getString("message");
        String country=jsonSys.getString("country");
        String sunrise=jsonSys.getString("sunrise");
        String sunset=jsonSys.getString("sunset");
        Sys sys= new Sys(message,country,sunrise,sunset);

        objectJson.setDt(dt);
        objectJson.setName(name);
        objectJson.setCod(cod);
        objectJson.setId(id1);
        objectJson.setBase(base);
        objectJson.setCoord(coord);
        objectJson.setMainob(main1);
        objectJson.setWind(wind);
        objectJson.setClouds(clouds);
        objectJson.setSys(sys);
       // objectJson.setWeathers();
        //objectJson.setWeathers(id);
        return  objectJson;
    }
    // Đọc nội dung text của một file nguồn.
    private static String readText(Context context,int id) throws IOException
    {
        InputStream is= context.getResources().openRawResource(id);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String temp=null;
        while((temp=br.readLine())!=null)
        {
            sb.append(temp);
            sb.append("\n");
        }
        return sb.toString();
    }

}
