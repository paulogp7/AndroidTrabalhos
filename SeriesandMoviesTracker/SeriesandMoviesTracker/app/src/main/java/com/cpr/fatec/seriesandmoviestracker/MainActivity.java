package com.cpr.fatec.seriesandmoviestracker;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

/*@SuppressWarnings("deprecation")*/
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Codigo principal para utilizar o activity dentro do tab
         */
        TabHost tabhost = (TabHost) findViewById(android.R.id.tabhost);

        TabHost.TabSpec tab1 = tabhost.newTabSpec("Aba Um");
        TabHost.TabSpec tab2 = tabhost.newTabSpec("Aba Dois");

        tab1.setIndicator("Series");
        //tab1.setIndicator("", getResources().getDrawable(R.mipmap.ic_launcher));
        tab1.setContent(new Intent(this, Tab1.class));

        tab1.setIndicator("Movies");
        /**
         * Mostrar o icone com o codigo abaixo
         */
        //tab1.setIndicator("", getResources().getDrawable(R.mipmap.ic_launcher));
        tab1.setContent(new Intent(this, Tab2.class));

        tabhost.addTab(tab1);
        tabhost.addTab(tab2);


    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
