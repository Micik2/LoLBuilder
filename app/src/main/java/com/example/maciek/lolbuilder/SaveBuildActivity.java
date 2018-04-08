package com.example.maciek.lolbuilder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Maciek on 2017-05-28.
 */

public class SaveBuildActivity extends AppCompatActivity {
    private EditText search;
    private Button confirm;
    private Button save;
    private ImageView selected;
    private ImageView item0;
    private ImageView item1;
    private ImageView item2;
    private ImageView item3;
    private ImageView item4;
    private ImageView item5;
    private TextView q_description;
    private TextView w_description;
    private TextView e_description;
    private TextView r_description;
    private TextView champion_display;
    String championTitle;
    MyDbHelper myDbHelper;
    String build;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_build);
        myDbHelper = new MyDbHelper(getApplicationContext());


        search = (EditText) findViewById(R.id.search_champion);
        confirm = (Button) findViewById(R.id.confirm_search);
        q_description = (TextView) findViewById(R.id.q_skill);
        w_description = (TextView) findViewById(R.id.w_skill);
        e_description = (TextView) findViewById(R.id.e_skill);
        r_description = (TextView) findViewById(R.id.r_skill);

        item0 = (ImageView) findViewById(R.id.item0);
        item1 = (ImageView) findViewById(R.id.item1);
        item2 = (ImageView) findViewById(R.id.item2);
        item3 = (ImageView) findViewById(R.id.item3);
        item4 = (ImageView) findViewById(R.id.item4);
        item5 = (ImageView) findViewById(R.id.item5);

        champion_display = (TextView) findViewById(R.id.champion_display);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                championTitle = search.getText().toString();
                SQLiteDatabase database = myDbHelper.getReadableDatabase();
                Cursor cursor = database.query("Skills", new String[]{"Q", "W", "E", "R",}, "ChampionName = ?", new String[]{championTitle}, null, null, null);
                //database = myDbHelper.getReadableDatabase();
                String Query = "Select * from Skills where ChampionName = '" + championTitle + "'";
                Cursor cursor2 = database.rawQuery(Query, null);
                if (cursor2.getCount() <= 0) {
                    cursor2.close();
                    Toast.makeText(getApplicationContext(), "Nie ma takiego bohatera", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), SaveBuildActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {


                    cursor.moveToPosition(0);
                    String q = cursor.getString(cursor.getColumnIndex("Q"));
                    String w = cursor.getString(cursor.getColumnIndex("W"));
                    String e = cursor.getString(cursor.getColumnIndex("E"));
                    String r = cursor.getString(cursor.getColumnIndex("R"));
                    q_description.setText(q);
                    //q_description.setTypeface(null, Typeface.BOLD);
                    w_description.setText(w);
                    e_description.setText(e);
                    r_description.setText(r);

                    selected = (ImageView) findViewById(R.id.selected_champion);
                    int id = getApplicationContext().getResources().getIdentifier("drawable/" + championTitle.toLowerCase(), null, getApplicationContext().getPackageName());
                    selected.setImageResource(id);

                    champion_display.setText(championTitle);

                    String[] titles = new String[]{"i1001", "i1004", "i1006", "i1027", "i1028", "i1033", "i1036", "i1037", "i1038", "i1042", "i1043", "i1051", "i1053", "i1054", "i1055", "i1083", "i2003", "i2010", "i2015", "i2031", "i2055", "i2140", "i3004", "i3006", "i3009", "i3022", "i3026", "i3031", "i3033", "i3034", "i3035", "i3036", "i3042", "i3043", "i3044", "i3046", "i3052", "i3053", "i3057", "i3067", "i3070", "i3071", "i3072", "i3074", "i3077", "i3078", "i3085", "i3086", "i3087", "i3094", "i3101", "i3123", "i3133", "i3134", "i3139", "i3140", "i3142", "i3144", "i3147", "i3155", "i3156", "i3508", "i3599", "i3812", "i3814"};

                    int j = 0;
                    int image = 0;
                    Random rand = new Random();
                    j = rand.nextInt(64);
                    image = getApplicationContext().getResources().getIdentifier("drawable/" + titles[j], null, getApplicationContext().getPackageName());
                    item0.setImageResource(image);
                    String firstItem = titles[j];

                    j = rand.nextInt(64);
                    image = getApplicationContext().getResources().getIdentifier("drawable/" + titles[j], null, getApplicationContext().getPackageName());
                    item1.setImageResource(image);
                    String secondItem = titles[j];

                    j = rand.nextInt(64);
                    image = getApplicationContext().getResources().getIdentifier("drawable/" + titles[j], null, getApplicationContext().getPackageName());
                    item2.setImageResource(image);
                    String thirdItem = titles[j];

                    j = rand.nextInt(64);
                    image = getApplicationContext().getResources().getIdentifier("drawable/" + titles[j], null, getApplicationContext().getPackageName());
                    item3.setImageResource(image);
                    String fourthItem = titles[j];

                    j = rand.nextInt(64);
                    image = getApplicationContext().getResources().getIdentifier("drawable/" + titles[j], null, getApplicationContext().getPackageName());
                    item4.setImageResource(image);
                    String fifthItem = titles[j];

                    j = rand.nextInt(64);
                    image = getApplicationContext().getResources().getIdentifier("drawable/" + titles[j], null, getApplicationContext().getPackageName());
                    item5.setImageResource(image);
                    String sixthItem = titles[j];

                    build = championTitle + "\n" +
                            "First item: " + firstItem + "\n" +
                            "Second item: " + secondItem + "\n" +
                            "Third item: " + thirdItem + "\n" +
                            "Fourth item: " + fourthItem + "\n" +
                            "Fifth item: " + fifthItem + "\n" +
                            "Sixth item: " + sixthItem;
                }
            }
        });

        save = (Button) findViewById(R.id.save_build);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                double r = random.nextDouble();

                String fileName = championTitle + r;

                File file = new File(getApplicationContext().getFilesDir(), fileName);

                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    fileOutputStream.write(build.getBytes());
                    fileOutputStream.close();

                    Toast.makeText(getApplicationContext(), "Zapisano zestaw przedmiotów dla bohatera!", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
