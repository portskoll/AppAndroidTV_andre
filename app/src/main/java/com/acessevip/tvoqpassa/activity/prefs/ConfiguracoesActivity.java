package com.acessevip.tvoqpassa.activity.prefs;

import android.os.Bundle;

import com.acessevip.tvoqpassa.R;

/**
 * Created by Henrique on 02/12/2015.
 */
@SuppressWarnings("deprecation")
public class ConfiguracoesActivity extends android.preference.PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //carrega as configurações
        addPreferencesFromResource(R.xml.preferences);
    }
}
