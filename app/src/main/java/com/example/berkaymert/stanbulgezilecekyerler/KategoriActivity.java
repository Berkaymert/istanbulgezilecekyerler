package com.example.berkaymert.stanbulgezilecekyerler;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

public class KategoriActivity extends AppCompatActivity {


    Toolbar mToolbar;
    ListView mListView;
    String[] yerler;
    TypedArray iconlar;
    TypedArray resimler;   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            mToolbar.setTitle(getResources().getString(R.string.app_name));
            mListView = (ListView) findViewById(R.id.listview);

            yerler = getResources().getStringArray(R.array.YerlerXmlArray);
            iconlar  = getResources().obtainTypedArray(R.array.İconlarXmlArray);
            resimler = getResources().obtainTypedArray(R.array.ResimlerXmlArray);

            MyAdapter myAdapter = new MyAdapter(KategoriActivity.this, yerler, iconlar);

            mListView.setAdapter(myAdapter);


            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int tiklanan_sira, long id) {

                    Intent mIntent = new Intent(KategoriActivity.this, DetayActivity.class);
                    mIntent.putExtra("tiklanan_sira",tiklanan_sira);
                    startActivity(mIntent);
                }
            });

    }
}
