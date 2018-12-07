# istanbulgezilecekyerler
İstanbul'da gezip görebileceğiniz birbirinden farklı ve güzel yerlerden oluşan bir uygulama.

# Başlangıç ekranından menüye giriş (SPLASH EKRANI)
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
