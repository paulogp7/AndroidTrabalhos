package com.fatec.paulo.calculaimc10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText peso;
    private EditText altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = (EditText)findViewById(R.id.edTxtNome);
        peso = (EditText)findViewById(R.id.edTxtPeso);
        altura = (EditText)findViewById(R.id.edTxtAltura);
    }

    public void abrirTelaResultado(View v){
        String n = nome.getText().toString();
        float p = Float.parseFloat(peso.getText().toString());
        float a = Float.parseFloat(altura.getText().toString());
        float imc = 0;

        if(a!=0){
            imc = p/(a*a);
        }

        Intent it = new Intent(this, ResultadoActivity.class);
        it.putExtra("nome",n);
        it.putExtra("imc",imc);
        startActivity(it);
    }

    @Override
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
    }
}
