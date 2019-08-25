package com.example.italikaapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class activity_registro extends AppCompatActivity {

    //Variables TextInput
    EditText input_Nombre;
    EditText input_Correo;
    EditText input_Contraseña;
    EditText input_VerificarContraseña;

    //Variable Checklist
    CheckBox checkBox;

    //Variables botones
    Button btn_Registro;

    //Variables String
    String Nombre = null;
    String Correo = null;
    String Contraseña = null;
    String VerificarContraseña = null;

    //Intent para cambio de Actividad
    Intent Registrarse = new Intent(this, MainActivity.class);

    private View.OnClickListener btn_RegistroListener = new View.OnClickListener() {
        public void onClick(View view) {
            Nombre = input_Nombre.getText().toString();
            Correo = input_Correo.getText().toString();
            Contraseña = input_Contraseña.getText().toString();
            VerificarContraseña = input_VerificarContraseña.getText().toString();

            //Intent Registrado = new Intent(activity_registro.this,MainActivity.class);

            if(Nombre.isEmpty() == false && Correo.isEmpty() == false && Contraseña.isEmpty() == false)
            {
                if(Contraseña.equals(VerificarContraseña))
                {
                    if(checkBox.isChecked())
                    {
                        Toast.makeText(getApplicationContext(),"Registro Completado", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Acepta los terminos y condiciones", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(Nombre.isEmpty() == true)
                Toast.makeText(getApplicationContext(),"Favor de ingresar Nombre", Toast.LENGTH_SHORT).show();
                else if(Correo.isEmpty() == true)
                    Toast.makeText(getApplicationContext(),"Favor de ingresar Correo", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Favor de ingresar Contraseña", Toast.LENGTH_SHORT).show();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Buscando TextInputs
        input_Nombre = (EditText) findViewById(R.id.input_Registro_Nombre);
        input_Correo = (EditText) findViewById(R.id.input_Registro_Correo);
        input_Contraseña = (EditText) findViewById(R.id.input_Registro_Contraseña);
        input_VerificarContraseña = (EditText) findViewById(R.id.input_Registro_Verificar_Contraseña);

        checkBox = (CheckBox) findViewById(R.id.Registro_checkBox);

        //Buscando Botones y Set de Listeners
        btn_Registro = (Button) findViewById(R.id.btn_Registrarse);
        btn_Registro.setOnClickListener(btn_RegistroListener);
    }
}
