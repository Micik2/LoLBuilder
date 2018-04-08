package com.example.maciek.lolbuilder;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


/**
 * Created by Maciek on 2017-05-28.
 */

public class RotationActivity extends AppCompatActivity {
    public final String api_key = "RGAPI-46fc19d0-7740-4910-9ce9-ecd502a21d54";
    //Rotation rotation = new Rotation();
    private ImageView imageView;
    SharedPreferences ADCChampions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);

        new Rotation().execute("");
        //rotation.execute();
    }

    private class Rotation extends AsyncTask<String, Void, String> {
        private ProgressDialog progressDialog = new ProgressDialog(RotationActivity.this);
        InputStream inputStream = null;
        String result = "";
        HttpsURLConnection connection;

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Downloading current rotation...");
            progressDialog.show();
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    Rotation.this.cancel(true);
                }
            });
        }

        @Override
        protected String doInBackground(String... params) {
            //android.os.Debug.waitForDebugger();

            final String urlRotation = "https://eun1.api.riotgames.com/lol/platform/v3/champions?freeToPlay=true&api_key=" + api_key;
            StringBuilder result = new StringBuilder();
            try {
                URL url = new URL(urlRotation);
                connection = (HttpsURLConnection) url.openConnection();
                InputStream input = new BufferedInputStream(connection.getInputStream());

                //System.out.println("CONNECTION: ");
                //System.out.println(connection);
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String line;
                while ((line = reader.readLine()) != null)
                    result.append(line);
            } catch (Exception e) {
                Log.e("Exception", "Error: " + e.toString());
            } finally {
                connection.disconnect();
            }
            //System.out.println("RESULT: ");
            //System.out.println(result.toString());
            return result.toString();
        }

        @Override
        protected void onPostExecute(String result) {
        //protected void onPostExecute(Void v) {
            //System.out.println("HALO?");
            try {
                //System.out.println("HALO2?");
                JSONObject jsonObject = new JSONObject(result);
                JSONArray champs = jsonObject.getJSONArray("champions");
                String[] identitiesRotation = new String[14];

                for(int i = 0; i < 14; i++) {
                    JSONObject champ = champs.getJSONObject(i);
                    identitiesRotation[i] = champ.getString("id");

                }
                //System.out.println("TU jeszcze jest! ");
                //System.out.println();
                this.progressDialog.dismiss();
                //System.out.println("TU NIE POWINNO BYC juz tego dialogu: ");

                //String vlad = MainActivity.map.get(identitiesRotation[7]);
                ADCChampions = getApplicationContext().getSharedPreferences("adc_champions", Context.MODE_PRIVATE);

                String vlad = ADCChampions.getString(identitiesRotation[7], "null");
                System.out.println("Vladimir???????????");
                JSONObject champ = champs.getJSONObject(7);
                System.out.println(champ.getInt("id"));
                System.out.println(vlad);

                String[] championsImg = new String[14];
                int imageResource = 0;
                for(int j = 0; j < 14; j++) {
                    //String champName = MainActivity.map.get(identitiesRotation[j]);
                    String champName = ADCChampions.getString(identitiesRotation[j], "null");
                    System.out.println(champName);
                    championsImg[j] = "drawable/" + champName;
                    System.out.println("Bohaterowie?");
                    System.out.println(championsImg[j]);
                }
                System.out.println("Bohaterowie dostępni w rotacji: ");
                for (int k = 0; k < 14; k++)
                    System.out.println(championsImg[k]);
                //System.out.println(championsImg[4]);
                //System.out.println(championsImg[7]);
                //Drawable image;
                Context context = getApplicationContext();
                int id = 0;

                id = context.getResources().getIdentifier(championsImg[0], null, context.getPackageName());
                //System.out.println(id);
                imageView = (ImageView) findViewById(R.id.img_champion0);
                //System.out.println(imageView);
                imageView.setImageResource(id);
                //System.out.println(R.id.img_champion0);

                id = context.getResources().getIdentifier(championsImg[1], null, context.getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion1);
                imageView.setImageResource(id);

                id = context.getResources().getIdentifier(championsImg[2], null, context.getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion2);
                imageView.setImageResource(id);

                id = context.getResources().getIdentifier(championsImg[3], null, context.getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion3);
                imageView.setImageResource(id);

                id = context.getResources().getIdentifier(championsImg[4], null, context.getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion4);
                imageView.setImageResource(id);

                id = context.getResources().getIdentifier(championsImg[5], null, context.getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion5);
                imageView.setImageResource(id);

                id = context.getResources().getIdentifier(championsImg[6], null, context.getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion6);
                imageView.setImageResource(id);

                id = context.getResources().getIdentifier(championsImg[7], null, context.getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion7);
                imageView.setImageResource(id);

                id = context.getResources().getIdentifier(championsImg[8], null, context.getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion8);
                imageView.setImageResource(id);

                id = context.getResources().getIdentifier(championsImg[9], null, context.getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion9);
                imageView.setImageResource(id);

                id = context.getResources().getIdentifier(championsImg[10], null, context.getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion10);
                imageView.setImageResource(id);

                id = context.getResources().getIdentifier(championsImg[11], null, context.getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion11);
                imageView.setImageResource(id);

/*
                //imageView.setImageResource(MainActivity.getImageId(this, ));
                //imageResource = getResources().getIdentifier(championsImg[0], null, getPackageName());
                //imageView = (ImageView) findViewById(R.id.img_champion0);
                //image = getResources().getDrawable(imageResource);
                //imageView.setImageDrawable(image);

                imageResource = getResources().getIdentifier(championsImg[1], null, getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion1);
                image = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(image);

                imageResource = getResources().getIdentifier(championsImg[2], null, getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion2);
                image = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(image);

                imageResource = getResources().getIdentifier(championsImg[3], null, getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion3);
                image = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(image);

                imageResource = getResources().getIdentifier(championsImg[4], null, getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion4);
                image = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(image);

                imageResource = getResources().getIdentifier(championsImg[5], null, getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion5);
                image = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(image);

                imageResource = getResources().getIdentifier(championsImg[6], null, getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion6);
                image = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(image);

                imageResource = getResources().getIdentifier(championsImg[7], null, getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion7);
                image = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(image);

                imageResource = getResources().getIdentifier(championsImg[8], null, getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion8);
                image = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(image);

                imageResource = getResources().getIdentifier(championsImg[9], null, getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion9);
                image = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(image);

                imageResource = getResources().getIdentifier(championsImg[10], null, getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion10);
                image = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(image);

                imageResource = getResources().getIdentifier(championsImg[11], null, getPackageName());
                imageView = (ImageView) findViewById(R.id.img_champion11);
                image = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(image);
*/
            } catch (JSONException e) {
                Log.e("JSONException", "Error: " + e.toString());
            }
        }

    }
}
