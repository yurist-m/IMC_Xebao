package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtPeso,txtAltura;
    ImageView imgResultadoImc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAltura = (EditText)findViewById(R.id.txtAltura);
        txtPeso = (EditText)findViewById(R.id.txtPeso);
        imgResultadoImc = (ImageView)findViewById(R.id.imgResultadoImc);
    }

    public void calcularImc(View v){
        float peso=0,altura=0,imc=0;
        if((txtPeso.getText().toString().length()>0)&&(txtAltura.getText().toString().length()>0)){
            peso = Float.parseFloat(txtPeso.getText().toString());
            altura = Float.parseFloat(txtAltura.getText().toString());
            if ((peso>0)&&(altura>0)){
                imc=(peso/(altura*altura));
                if(imc<=18.5){
                    imgResultadoImc.setImageResource(R.drawable.abaixopeso);
                }
                else if((imc>=18.6)&&(imc<=24.9)){
                    imgResultadoImc.setImageResource(R.drawable.normal);
                }
                else if((imc>=25.0)&&(imc<=29.9)){
                    imgResultadoImc.setImageResource(R.drawable.sobrepeso);
                }
                else if((imc>=30.0)&&(imc<=34.9)){
                    imgResultadoImc.setImageResource(R.drawable.obesidade1);
                }
                else if((imc>=35.0)&&(imc<=39.9)){
                    imgResultadoImc.setImageResource(R.drawable.obesidade2);
                }
                else if(imc>=40.0){
                    imgResultadoImc.setImageResource(R.drawable.obesidade3);
                }
            }
            else{
                Toast.makeText(this, "Peso ou altura inválidos", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Você deve preencher todos os campos para continuar", Toast.LENGTH_SHORT).show();
        }
    }
}
