package com.acessevip.tvoqpassa.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.acessevip.tvoqpassa.activity.WebViewVideo;
import com.acessevip.tvoqpassa.util.AvaliarAPP;
import com.squareup.picasso.Picasso;

import com.acessevip.tvoqpassa.R;
import com.acessevip.tvoqpassa.domain.Carro;

import livroandroid.lib.utils.IntentUtils;

/**
 * Created by Henrique on 18/11/2015.
 */
public class CarroFragment extends BaseFragment{

    private String tipo_play = "";
    private String URL_video = "";

    private Carro carro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_carro,container,false);
        setHasOptionsMenu(true);//Informando o android que o fragmente contem menu


        return view;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_play, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_video) {
            AvaliarAPP.agora(getActivity());
            if (tipo_play.equals("0")) {//player local
                Intent intent = new Intent(getActivity(),WebViewVideo.class);
                intent.putExtra("carro",carro);
                startActivity(intent);
                return true;
            }else if (tipo_play.equals("1")){//player nativo
                IntentUtils.showVideo(getContext(),URL_video);
                return true;
            }else {// player para vk, youtube e html ou php
                IntentUtils.openBrowser(getContext(), URL_video);
                return true;
            }

        }
        return super.onOptionsItemSelected(item);

    }

    /*public void setCarro(String img) {

                    TextView textView = (TextView) getView().findViewById(R.id.tDesc);
                    textView.setText("oreia seca");
                    //setTextString(R.id.tDesc,"oreia seca");
                    ImageView imageView = (ImageView) getView().findViewById(R.id.fragment_carro_img);
                    Picasso.with(getContext()).load(img).fit().into(imageView);

            }*/
   public void setCarro(Carro carro) {
        if(carro != null){
            this.carro = carro;
            tipo_play = carro.tipo_play.toString();
            //tipo_play = "2";
            URL_video = carro.urlVideo.toString();
            Log.d("CarroFragment", tipo_play);
            final ImageView img_t_play = (ImageView) getView().findViewById(R.id.img_tipo_play);

           //altera a imagem do tipo de play
            if (tipo_play.equals("0")) {//player local

                img_t_play.setImageResource(R.drawable.android_play);

            }else if (tipo_play.equals("1")){//player nativo

                img_t_play.setImageResource(R.drawable.player_nativo);

            }else if (tipo_play.equals("2")){//player vk

                img_t_play.setImageResource(R.drawable.vk);

            }else if (tipo_play.equals("3")){//player youtube

                img_t_play.setImageResource(R.drawable.youtube);

            }else {//player no browser

                img_t_play.setImageResource(R.drawable.html);
            }
            setTextString(R.id.tDesc, carro.desc);
            final ImageView imageView = (ImageView) getView().findViewById(R.id.fragment_carro_img);
            Picasso.with(getContext()).load(carro.urlFoto).fit().into(imageView);
        }else toast("carro zerado");
    }


}
