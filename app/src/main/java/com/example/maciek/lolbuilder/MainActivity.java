package com.example.maciek.lolbuilder;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private Button rotation;
    private Button save;
    private Button load;
    private Button layoutInflater;
    private Context context;
    public static Map<Integer, String> map =  new HashMap<Integer, String>();
    InputStream inputStream = null;
    String result = "";
    HttpsURLConnection connection;
    public static SharedPreferences ADCChampions;
    //SQLiteDatabase databaseW;
    //SQLiteDatabase databaseR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
/*
        final String api_key = "RGAPI-46fc19d0-7740-4910-9ce9-ecd502a21d54";
        //System.out.println(isNetworkAvailable());
        final String urlChampionsFormat = "https://eun1.api.riotgames.com/lol/static-data/v3/champions?locale=en_US&tags=format&dataById=true&api_key=" + api_key;

        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlChampionsFormat);
            connection = (HttpsURLConnection) url.openConnection();
            InputStream input = new BufferedInputStream(connection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = reader.readLine()) != null)
                result.append(line);
        } catch (Exception e) {
            Log.e("Exception", "Error: " + e.toString());
        } finally {
            connection.disconnect();
        }

        try {
            JSONObject jsonObject = new JSONObject(result.toString()).getJSONObject("data");
            Iterator<String> ids = jsonObject.keys();
            while (ids.hasNext()) {
                String id = ids.hasNext();
                JSONObject innerJSONObject = jsonObject.getJSONObject(id);
                Iterator<String> names = innerJSONObject.keys();
                while (names.hasNext()) {
                    String name = names.next();
                    String title = innerJSONObject.getString("title");
                    String

                }
            }
            for (int i = 0; i < jsonObject.length(); i++) {

            }
            JSONObject championsFormat = jsonObject.getJSONArray("champions");
            int[] identitiesRotation = new int[12];
        } catch ()
*/
        // Na początku dla 1. poziomu
        Champion Ashe = new Champion(22, "Ashe", 1949.72, 15.324, 856, 14.172, 325, 97.868, 1.0304938, 600, 82.412, 39);
        Champion Caitlyn = new Champion(51, "Caitlyn", 604.4, 6.224, 348.7, 7.95, 325, 55.84, 0.543, 650, 26.38, 30.5);
        Champion Lucian = new Champion(236, "Lucian", 634.4, 6.842, 386.88, 8.876, 335, 59.87, 0.638, 500, 27.04, 30.5);
        Champion Twitch = new Champion(29, "Twitch", 606.08, 6.608, 327.2, 7.706, 330, 57.87, 0.679, 550, 26.04, 30.5);

        //Map<Integer, String> map =  new HashMap<Integer, String>();
        ADCChampions = this.getSharedPreferences("adc_champions", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ADCChampions.edit();
        editor.putString("22", "ashe").apply();
        editor.putString("136", "aurelionsol").apply();
        editor.putString("268", "azir").apply();
        editor.putString("432", "bard").apply();
        editor.putString("51", "caitlyn").apply();
        editor.putString("69", "cassiopeia").apply();
        editor.putString("42", "corki").apply();
        editor.putString("104", "graves").apply();
        editor.putString("126", "jayce").apply();
        editor.putString("202", "jhin").apply();
        editor.putString("222", "jinx").apply();
        editor.putString("429", "kalista").apply();
        editor.putString("203", "kindred").apply();
        editor.putString("96", "kogmaw").apply();
        editor.putString("11", "masteryi").apply();
        editor.putString("21", "missfortune").apply();
        editor.putString("267", "nami").apply();
        editor.putString("80", "pantheon").apply();
        editor.putString("133", "quinn").apply();
        editor.putString("92", "riven").apply();
        editor.putString("102", "shyvana").apply();
        editor.putString("15", "sivir").apply();
        editor.putString("17", "teemo").apply();
        editor.putString("18", "tristana").apply();
        editor.putString("29", "twitch").apply();
        editor.putString("6", "urgot").apply();
        editor.putString("110", "varus").apply();
        editor.putString("67", "vayne").apply();
        editor.putString("8", "vladimir").apply();
        editor.putString("498", "xayah").apply();
        editor.putString("157", "yasuo").apply();
        SharedPreferences test = this.getSharedPreferences("adc_champions", Context.MODE_PRIVATE);
        String testS = test.getString("157", null);
        System.out.println("CZY DZIALA??????????");
        System.out.println(testS);

        MyDbHelper myDbHelper = new MyDbHelper(context);
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        //db.execSQL("DROP TABLE IF EXISTS Skills");
        //db.delete("Skills", null, null);
        //db.execSQL("DROP TABLE IF EXISTS Skills");
        ContentValues values = new ContentValues();
        //MyDbHelper myDbHelper = new MyDbHelper(getApplicationContext());
        //SQLiteDatabase databaseW = myDbHelper.getWritableDatabase();
        //openOrCreateDatabase("lolbuilder.db", getApplicationContext().MODE_PRIVATE, null);
        //myDbHelper.onDelete(databaseW);
        //databaseW = myDbHelper.getWritableDatabase();
        //ContentValues values = new ContentValues();
        values.put("ChampionName", "Azir");
        values.put("ChampionId", 268);
        values.put("Q", "Azir sends all Sand Soldiers towards a location. Sand Soldiers deal 145 (+0.5) magic damage to enemies they pass through and apply a 25% slow for 1 second.\n" +
                "\n" +
                "Enemies hit by multiple Sand Soldiers will not take additional damage.");
        values.put("W", "Passive: Gains 60% attack speed.\n" +
                "\n" +
                "Active: Azir summons a Sand Soldier for 9 seconds. When Azir attacks an enemy in a soldier's range, the soldier attacks instead of Azir, dealing 60 (+0.6) magic damage to enemies in a line. If multiple soldiers strike the same target, each soldier after the first deals 25% damage.\n" +
                "\n" +
                "Azir can store up to undefined Sand Soldiers at a time. A new soldier becomes available every undefined seconds.\n" +
                "\n" +
                "Sand Soldiers can attack targets outside of Azir's basic attack range.\n" +
                "Sand Soldiers deactivate if they are too far away from Azir.\n" +
                "Sand Soldiers expire twice as fast when near an enemy turret.");
        values.put("E", "Azir dashes to one of his Sand Soldiers, damaging enemies hit for 180 (+0.4) magic damage.\n" +
                "\n" +
                "If Azir hits an enemy champion, his dash stops and he gains a shield for 4 seconds that absorbs up to 240 damage.");
        values.put("R", "Azir summons a wall of armored soldiers that charge forward, knocking back enemies and dealing 300 (+0.6) magic damage. The soldiers then remain as a wall for 3 seconds.\n" +
                "\n" +
                "Enemies will be stopped by Emperor's Divide, even if they attempt to dash over the wall, but Azir and his allies can pass freely through it.\n" +
                "\n" +
                "Emperor's Divide does not interact with Azir's basic attacks or spells.");
        values.put("CostQ", 70);
        values.put("CostW", 40);
        values.put("CostE", 60);
        values.put("CostR", 100);
        values.put("DamageQ", 145);
        values.put("DamageW", 60);
        values.put("DamageE", 180);
        values.put("DamageR", 300);
        values.put("ConverterQ", 0.5);
        values.put("ConverterW", 0.6);
        values.put("ConverterE", 0.4);
        values.put("ConverterR", 0.6);
        values.put("ConverterType", "AP");
        db.insert("Skills", null, values);

        ContentValues values2 = new ContentValues();
        values2.put("ChampionName", "Corki");
        values2.put("ChampionId", 42);
        values2.put("Q", "Corki lobs a bomb, dealing 70/115/160/205/250 (+0.5) (+0.5) magic damage to enemies in the target area. In addition, the blast reveals the area and champions hit by the blast for 6 seconds (does not reveal stealth).");
        values2.put("W", "Active: Corki flies a short distance, dealing 60/90/120/150/180 (+0.4) magic damage per second to enemies in the fire left along his path.\n" +
                "\n" +
                "Special Delivery: Corki flies a great distance, dropping bombs that knock aside enemies and leave a burning trail for 5 seconds. The trail slows enemies by 90% and burns them for undefined (+undefined) (+0.2) magic damage per second.");
        values2.put("E", "Corki's gatling gun fires continuously at targets in front of him for 4 seconds, dealing up to 80/140/200/260/320 (+1.6) damage and reducing up to 4/8/12/16/20 armor and magic resist.\n" +
                "\n" +
                "Gatling Gun's damage is 50% physical, 50% magic.\n" +
                "Defense reductions last for 2 seconds after last being damaged by Gatling Gun.");
        values2.put("R", "Active: Corki fires a missile that explodes at the first enemy it hits, dealing 75/100/125 (+2) (+0.2) magic damage to all nearby enemies.\n" +
                "\n" +
                "Corki can store up to 7 missiles, and every 3rd missile will be a Big One, dealing undefined% damage ().");
        values2.put("CostQ", 70);
        values2.put("CostW", 60);
        values2.put("CostE", 80);
        values2.put("CostR", 100);
        values2.put("DamageQ", 250);
        values2.put("DamageW", 180);
        values2.put("DamageE", 320);
        values2.put("DamageR", 125);
        values2.put("ConverterQ", 0.5);
        values2.put("ConverterW", 0.4);
        values2.put("ConverterE", 1.6);
        values2.put("ConverterR", 2.2);
        values2.put("ConverterType", "AP");
        db.insert("Skills", null, values2);

        SQLiteDatabase db1 = myDbHelper.getReadableDatabase();
        String[] tableColumns = new String[] {"ChampionId", "DamageW"};
        String whereClause = "ChampionId = ?";
        String[] whereArgs = new String[] {"268"};
        //Cursor cursor = databaseR.query("Skills", tableColumns, whereClause, whereArgs, null, null, "Skills");
        Cursor cursor = db1.query("Skills", null, null, null, null, null, null);
        String text = DatabaseUtils.dumpCursorToString(cursor);
        System.out.println("KURSOR: ");
        System.out.println(text);

        rotation = (Button) findViewById(R.id.rotation);
        rotation.setText(getResources().getString(R.string.rotation));
        save = (Button) findViewById(R.id.save);
        save.setText(getResources().getString(R.string.save_build));
        //load = (Button) findViewById(R.id.load);
        //load.setText(getResources().getString(R.string.load_build));
        layoutInflater = (Button) findViewById(R.id.layout_inflater);
        layoutInflater.setText(getResources().getString(R.string.layout_inflater));

        rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rotationIntent = new Intent(context, RotationActivity.class);
                startActivity(rotationIntent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saveIntent = new Intent(context, SaveBuildActivity.class);
                startActivity(saveIntent);
            }
        });

        /*load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadIntent = new Intent(context, LoadBuildActivity.class);
                startActivity(loadIntent);
            }
        });*/

        layoutInflater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadIntent = new Intent(context, LayoutInflaterActivity.class);
                startActivity(loadIntent);
            }
        });
    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
}
