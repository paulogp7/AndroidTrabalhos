package com.fatec.paulo.dividircontas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText preco;
    private EditText pessoas;
    private TextView subtotal;
    private TextView total;
    private float acumSubtotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preco = (EditText) findViewById(R.id.edTxtPreco);
        pessoas = (EditText) findViewById(R.id.edTxtPessoas);
        subtotal = (TextView) findViewById(R.id.txtViewSubtotalValor);
        total = (TextView) findViewById(R.id.txtViewTotalValor);
    }

    public void calcularSubtotal(View v){

        float prc = Float.parseFloat(preco.getText().toString());
        int pess = Integer.parseInt(pessoas.getText().toString());

        if(pess==0){
            pessoas.setText("1");
            pess=1;
        }

        acumSubtotal += prc;
        subtotal.setText(String.format("%.2f",acumSubtotal));

        total.setText(String.format("%.2f",acumSubtotal/pess));
    }

    public void dividirSubtotal(View v){

        int pess = Integer.parseInt(pessoas.getText().toString());

        if(pess==0){
            pessoas.setText("1");
            pess=1;
        }
        total.setText(String.format("%.2f",acumSubtotal/pess));
    }

    public void subtrairDoSubtotal(View v){
        float prc = Float.parseFloat(preco.getText().toString());
        acumSubtotal = (prc>acumSubtotal) ? 0 : (acumSubtotal - prc);
        subtotal.setText(String.format("%.2f",acumSubtotal));
        dividirSubtotal(v);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
