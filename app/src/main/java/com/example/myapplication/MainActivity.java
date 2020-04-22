package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();
    }

    private void clearValues() {
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.textDolar.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calculate){
            String value = this.mViewHolder.editValue.getText().toString();
            if ("".equals(value)){
                Toast.makeText(this, this.getString(R.string.infome_valor), Toast.LENGTH_LONG).show();
            }
            else{
                Double real = Double.valueOf(value);
                Double dolar = real/5;
                Double euro = real/6;
                this.mViewHolder.textDolar.setText(String.format("%.2f", dolar));
                this.mViewHolder.textEuro.setText(String.format("%.2f", euro));
            }
        }
    }

    private static class ViewHolder{
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }
}
