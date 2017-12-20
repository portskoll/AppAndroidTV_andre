package com.acessevip.tvoqpassa.activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.acessevip.tvoqpassa.R;


import livroandroid.lib.utils.AndroidUtils;

public class Splash extends AppCompatActivity implements Runnable{

    private Handler h;
    private int progresso=6;
    TextView status;
    int mudalogo=0;
    String Rede = "";
    //private AdcashInterstitial mInterstitial;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //mInterstitial.loadAd();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if(AndroidUtils.isNetworkAvailable(this)){


            Rede = "OK";
        }
        h = new Handler();
        h.post(this);




    }
    @Override
    public void run() {
        ImageView logo = (ImageView)findViewById(R.id.Splash_img);
        avancar();

        if(mudalogo==1) {

           status = (TextView)findViewById(R.id.txtStatus);
            status.setText(Integer.toString(mudalogo).toString());
            logo.setImageResource(R.drawable.splash1);



        }

        if(mudalogo==2) {

            status = (TextView)findViewById(R.id.txtStatus);
            status.setText(Integer.toString(mudalogo).toString());
            logo.setImageResource(R.drawable.splash2);



        }

        if(mudalogo == 3) {
            mudalogo=0;

        }


        if (progresso > 6 && progresso < 20) {
            avancar();
           status = (TextView)findViewById(R.id.txtStatus);
            status.setText("Verificando Conexão...");


        }

        if (progresso >= 20 && progresso < 30) {

            if (Rede.equals("OK")) {
               status = (TextView)findViewById(R.id.txtStatus);
                status.setText("Rede OK");
                progresso = 30;
                //if(PrefUser.getUserID(this,"id") == -1) {
                 //   Intent it = new Intent(this,Cadastro.class);
                  //  startActivity(it);
                  //  finish();
               // }else {
                    Intent it = new Intent(this,FilmeProgTv.class);
                    startActivity(it);
                    finish();
               // }

            }else {

                progresso = 19;

                status.setText("Sem conexão com a Internet.\nConecte-se a Internet e tente novamente.");
            }

        }

    }

    public void avancar() {

        h.postDelayed(this,600);
        mudalogo++;
        progresso++;

    }
}
