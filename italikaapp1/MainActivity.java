package com.example.italikaapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Object;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import static oracle.net.aso.c12.e;

public class MainActivity extends AppCompatActivity {

    //Variables para la conexion a la base de datos
    private static final String DEFAULT_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DEFAULT_URL = "jdbc:oracle:thin:@192.168.137.1:1521:xe";
    private static final String DEFAULT_USERNAME = "administrador";
    private static final String DEFAULT_PASSWORD = "administrador";

    private Connection connection;

    //vaiables EditText
    EditText input_Correo;
    EditText input_Contraseña;

    //Variables Botones
    Button btn_iniciar;

    //Variables de Labels
    TextView txt_Registrarse;
    TextView txt_Invitado;

    //Variables String
    String Correo = null;
    String Contraseña = null;

    // Create an anonymous implementation of OnClickListener
    private View.OnClickListener btn_iniciarListener = new View.OnClickListener() {
        public void onClick(View v) {
            Correo = input_Correo.getText().toString();
            Contraseña = input_Contraseña.getText().toString();
            Intent iniciar_Sesion = new Intent(MainActivity.this,Inicio.class);
            // do something when the button is clicked
            if(Correo.isEmpty() == false && Contraseña.isEmpty() == false)
            {
                //Intento de conexion a la base de datos
                try{
                    connection = createConnection();
                    Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                    connection.close();
                }catch(Exception e){
                    //Toast.makeText(getApplicationContext(),"Incorrecto" + e.getMessage(),Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, ""+e,
                            Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                //Toast.makeText(getApplicationContext(),"Conectado con exito ", Toast.LENGTH_SHORT).show();
                //startActivity(iniciar_Sesion);
            }
            else
            {
                if(Correo.isEmpty())
                    Toast.makeText(getApplicationContext(),"Favor de ingresar correo", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Favor de ingresar contraseña", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private View.OnClickListener txt_RegistrarseListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent Registro = new Intent(MainActivity.this,activity_registro.class);
            // do something when the button is clicked
            startActivity(Registro);
        }
    };

    private View.OnClickListener txt_InvitadoListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent Invitados = new Intent(MainActivity.this,Inicio.class);
            // do something when the button is clicked
            startActivity(Invitados);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //Encontrando Variables de EditText
        input_Correo = (EditText) findViewById(R.id.input_Correo);
        input_Contraseña = (EditText) findViewById(R.id.input_Contraseña);

        //Encontrando Variables de TextView con su listener
        txt_Registrarse = (TextView) findViewById(R.id.txt_Registro);
        txt_Invitado = (TextView) findViewById(R.id.txt_invitado);
        txt_Registrarse.setOnClickListener(txt_RegistrarseListener);
        txt_Invitado.setOnClickListener(txt_InvitadoListener);

        //Encontrando variables de boton con su listener
        btn_iniciar = (Button) findViewById(R.id.btn_Iniciar);
        btn_iniciar.setOnClickListener(btn_iniciarListener);


    }

    //METODOS PARA CONEXION A BASE DE DATOS
    public static Connection createConnection(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException {

        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        return createConnection(DEFAULT_DRIVER, DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }


}
