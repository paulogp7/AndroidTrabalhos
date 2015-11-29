package com.fatec.paulo.kelvincelsiusfahrenheit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText temperatura1;
    private TextView temperatura2;
    private RadioButton c1;
    private RadioButton f1;
    private RadioButton c2;
    private RadioButton f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatura1 = (EditText) findViewById(R.id.edTxtTemperatura);
        temperatura2 = (TextView) findViewById(R.id.txtTempConvertida);
        c1 = (RadioButton) findViewById(R.id.rdBtnC);
        f1 = (RadioButton) findViewById(R.id.rdBtnF);
        c2 = (RadioButton) findViewById(R.id.rdBtnC2);
        f2 = (RadioButton) findViewById(R.id.rdBtnF2);

        c1.setChecked(true);
        c2.setChecked(true);
    }

    public void converterTemp(View v){
        if(temperatura1.length() == 0){ temperatura1.setText("0"); }
        float temp1 = Float.parseFloat(temperatura1.getText().toString());

        if(c1.isChecked()){
            if(c2.isChecked()){
                temperatura2.setText(String.format("%.1f", temp1));
            }else if(f2.isChecked()) {
                temperatura2.setText(String.format("%.1f", temp1 * 1.8 + 32));
            }else {
                temperatura2.setText(String.format("%.1f", temp1 + 273.15));
            }
        }else if(f1.isChecked()){
            if(c2.isChecked()){
                temperatura2.setText(String.format("%.1f", (temp1 - 32) / 1.8));
            }else if(f2.isChecked()) {
                temperatura2.setText(String.format("%.1f", temp1));
            }else {
                temperatura2.setText(String.format("%.1f", (temp1 + 459.67) / 1.8));
            }
        }else {
            if(c2.isChecked()){
                temperatura2.setText(String.format("%.1f", temp1 - 273.15));
            }else if(f2.isChecked()) {
                temperatura2.setText(String.format("%.1f", temp1 * 1.8 - 459.67));
            }else {
                temperatura2.setText(String.format("%.1f", temp1));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}
