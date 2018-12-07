# istanbulgezilecekyerler
İstanbul'da gezip görebileceğiniz birbirinden farklı ve güzel yerlerden oluşan bir uygulama.

# Başlangıç ekranından menüye giriş (SPLASH EKRANI)
 Bu ekranda başlangıç ekranından uygulamanın menü ekranına geçişini göreceğiz.

    private static int gosterim_suresi = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

             new Handler().postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     Intent i = new Intent(SplashActivity.this,KategoriActivity.class);
                    startActivity(i);
                    finish();
                 }
             },gosterim_suresi);

        }

    }
   .
   # Seçeneklerin bulunduğu ekran (KategoriActivity)
   Bu kısımda splash ekranının geçişinden sonra açılan seçeneklerin bulunduğu ekrandaki kodlar:
  
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
# Detayların bulunduğu ekran (DetayActivity)
Bu ekranda kategori ekranında seçmiş bulunduğumuz ekranın bilgilerini xml'ler aracılığıyla sırasıyla istediğimiz yerdir.
    
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
