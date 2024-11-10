package com.example.currencyconvertcalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);

        //ViewHolder
        this.mViewHolder.et_real = findViewById(R.id.et_real);
        this.mViewHolder.tv_dolar= findViewById(R.id.et_dolar);
        this.mViewHolder.tv_euro = findViewById(R.id.et_euro);
        this.mViewHolder.converter = findViewById(R.id.converter);

        this.mViewHolder.converter.setOnClickListener(this);

        this.clearValues();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.converter){
            String value = this.mViewHolder.et_real.getText().toString();
            if("".equals(value)) {


            } else {
                Double real = Double.valueOf(value);
                this.mViewHolder.tv_dolar.setText("$" + String.format("%.2f", (real / 5.74)));
                this.mViewHolder.tv_euro.setText(String.format("%.2f", (real / 6.14)) + "€" );

            }
        }
    }

    private void clearValues(){
        this.mViewHolder.tv_dolar.setText("");
        this.mViewHolder.tv_euro.setText("");

    }

    private static class ViewHolder {
        EditText et_real;
        TextView tv_dolar;
        TextView tv_euro;
        Button converter;
    }
}