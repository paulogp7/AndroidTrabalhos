package com.fatec.paulo.calculaimc10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private String nome;
    private float imc;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Intent it = getIntent(); //captura o que for passado pelo Intent de quem chamou a classe
        if(it.hasExtra("nome") && it.hasExtra("imc") && it.getFloatExtra("imc",0)!=0 ){
            nome = it.getStringExtra("nome");
            imc = it.getFloatExtra("imc", 0);
            t = (TextView)findViewById(R.id.txtOla);
            t.append(nome);
            t = (TextView)findViewById(R.id.txtResultado);
            t.append(""+imc);

            String res=".";
            if(imc<16){
                res="com Magreza grave.";
            }else if(imc<17){
                res="com Magreza moderada.";
            }else if(imc<18.5){
                res="com Magreza leve.";
            }else if(imc<25){
                res="Saudável.";
            }else if(imc<30){
                res="com Sobrepeso.";
            }else if(imc<35){
                res="com Obesidade grau I.";
            }else if(imc<40) {
                res="com Obesidade grau II.";
            }else{
                res="com Obesidade grau III.";
            }
            t = (TextView)findViewById(R.id.txtSituacao);
            t.setText("Você está "+res);

            Log.v("Aula", "olá" + nome);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultado, menu);
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
