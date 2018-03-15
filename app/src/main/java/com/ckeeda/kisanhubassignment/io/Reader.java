package com.ckeeda.kisanhubassignment.io;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.ckeeda.kisanhubassignment.Model.WeatherData;
import com.ckeeda.kisanhubassignment.RealmController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import io.realm.Realm;

public class Reader
{
    private String TAG = getClass().getName();
    private String regionCode[]= {"UK","England","Wales","Scotland"};
    private String weatherParameters[]= {"Tmax","Tmin","Tmean","Sunshine","Rainfall"};
    private HashMap<String,String> parameterMap = weatherParameterMap();
    private ArrayList<WeatherData> weatherModels= new ArrayList<WeatherData>();
    private URL url;
    private BufferedReader bufferedReader;
    private Realm realm;

    public void read(Context context)
    {
         realm = RealmController.with((Application) context).getRealm();
        try
        {
            for(int rc=0;rc<regionCode.length;rc++)
            {
                for(int wp=0;wp<weatherParameters.length;wp++)
                {
                    String dynamicUrl="https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/"+weatherParameters[wp]+"/date/"+regionCode[rc]+".txt";
                    url=new URL(dynamicUrl);

                    try
                    {
                        bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                        ignoreLines();
                        readingData(rc, wp);
                        bufferedReader.close();
                    }
                    catch (UnknownHostException e) {
                        System.out.println("Invlid URL "+url);
                    }

                    catch (FileNotFoundException e) {
                        System.out.println("File Not Found "+url);
                    }

                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                }
            }
        }

        catch (MalformedURLException e)
        {
            System.out.println("URL is MALFORMED:  " + url);
        }



    }


    private void readingData(int rc, int wp) throws IOException
    {
        String inputLine;
        long  realm_id = 0;
        ArrayList<String> values = new ArrayList<>();
        while( (inputLine=bufferedReader.readLine())!=null)
        {
            values.clear();
            WeatherData data = new WeatherData();
            //Log.v(TAG,"B4:" + inputLine.length() + "Line:" + inputLine);

            String year = inputLine.substring(0, 4);
            String lineWithoutYear = inputLine.substring(4, inputLine.length());
            values = splitStringInFixedSizeChunks(lineWithoutYear, 17,year);

            Log.v(TAG,"Size of Arraylist :" + values.size());
            realm_id++;
         //   data.setId((int) realm_id);
            data.setRegion(regionCode[rc]);
            data.setWeather(weatherParameterMap().get(weatherParameters[wp]));
            data.setYear(Integer.parseInt(year));
            data.setJan_data( values.size() < 1 ? "N/A" : values.get(0));
            data.setFeb_data(values.size() < 2 ? "N/A" : values.get(1));
            data.setMar_data(values.size() < 3 ? "N/A" : values.get(2));
            data.setApr_data(values.size() < 4 ? "N/A" : values.get(3));
            data.setMay_data(values.size() < 5 ? "N/A" : values.get(4));
            data.setJun_data(values.size() < 6 ? "N/A" : values.get(5));
            data.setJul_data(values.size() < 7 ? "N/A" : values.get(6));
            data.setAug_data(values.size() < 8 ? "N/A" : values.get(7));
            data.setSep_data(values.size() < 9 ? "N/A" : values.get(8));
            data.setOct_data(values.size() < 10 ? "N/A" : values.get(9));
            data.setNov_data(values.size() < 11 ? "N/A" : values.get(10));
            data.setDec_data(values.size() < 12 ? "N/A" : values.get(11));
            data.setWin_data(values.size() < 13 ? "N/A" : values.get(12));
            data.setSpr_data(values.size() < 14 ? "N/A" : values.get(13));
            data.setSum_data(values.size() < 15 ? "N/A" : values.get(14));
            data.setAut_data(values.size() < 16 ? "N/A" : values.get(15));
            data.setAnn_data(values.size() < 17 ? "N/A" : values.get(16));

            realm.beginTransaction();
            realm.copyToRealm(data);
            realm.commitTransaction();

        }
    }


    private void ignoreLines()
    {
        Log.v(TAG, "Ignoring Lines...");
        for(int i=0;i<8;i++)
        {
            try
            {
                bufferedReader.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private ArrayList<String> splitStringInFixedSizeChunks(String string, int maxSubStringsToTake,String year) {
        ArrayList<String> subStrings = null;
        int j = 0;
        int lengthOfChunk = 0;
        for (int i = 0; i < string.length() && j < maxSubStringsToTake; i += lengthOfChunk) {
            if(j == 12 || j == 16)
                 lengthOfChunk = 8;
            else
                lengthOfChunk = 7;
            j++;
            int endIndex = i + lengthOfChunk;
            if (endIndex > string.length() - 1) {
                endIndex = string.length();
            }
            String subString = string.substring(i, endIndex);
            if (subStrings == null) {
                subStrings = new ArrayList<>();
            }
         //   subString = subString.trim();
            if(subString.isEmpty()|| subString.contains("---") || subString.equals("       ")) {
                subString = "N/A";
            }

            subStrings.add(subString);
        }
        return subStrings;
    }

    public HashMap<String,String> weatherParameterMap()
    {
        HashMap<String,String> hashmap=new HashMap<String,String>();
        hashmap.put("Tmax", "Max Temp");
        hashmap.put("Tmin", "Min Temp");
        hashmap.put("Tmean", "Mean Temp");
        hashmap.put("Sunshine", "Sunshine");
        hashmap.put("Rainfall", "Rainfall");
        return hashmap;
    }

}

