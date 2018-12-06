package com.example.berkaymert.stanbulgezilecekyerler;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;


public class DetayActivity extends AppCompatActivity {


    Toolbar mToolbar;
    ImageView mImageView;
    TextView txt_detay,txt_adres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        mImageView = (ImageView) findViewById(R.id.detay_resim);
        txt_detay =(TextView)  findViewById(R.id.txt_detay);
        mToolbar =(Toolbar)  findViewById(R.id.toolbar);
        txt_adres = (TextView) findViewById(R.id.txt_adres);
        Bundle mBundle = getIntent().getExtras();

        if(mBundle != null) {

            int tiklanan_sira = mBundle.getInt("tiklanan_sira", -1);
            mToolbar.setTitle(getResources().getStringArray(R.array.YerlerXmlArray)[tiklanan_sira]);

            String html_text=getResources().getStringArray(R.array.DetaylarXmlArray)[tiklanan_sira];
            String html_texxt=getResources().getStringArray(R.array.AdreslerXmlArray)[tiklanan_sira];
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                txt_detay.setText(Html.fromHtml(html_text, Html.FROM_HTML_MODE_COMPACT));
                txt_adres.setText(Html.fromHtml(html_texxt, Html.FROM_HTML_MODE_COMPACT));
            } else {
                txt_detay.setText(Html.fromHtml(html_text));
                txt_adres.setText(Html.fromHtml(html_texxt));
            }

            mImageView.setImageResource(getResources().obtainTypedArray(R.array.ResimlerXmlArray).getResourceId(tiklanan_sira, -1));


        }
    }
}
