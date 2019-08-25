package com.example.italikaapp1;

import android.app.Application;
import android.widget.Toast;

import java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class db extends Application {

    //Variables para la conexion a la base de datos
    Connection Conn;
    String url="jdbc:oracle:thin:@localhost:1521:xe";
    String DBName="Hackathon_CA";
    String UserName="administrador";
    String Password="administrador";
    String Servername="xe";
    Statement st;
    public void Open()
    {
        /*try{
            //Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            //Conn = DriverManager.getConnection(url,UserName,Password);
        } catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }*/
    }
    public void save(String sql)
    {
        try{
            st= Conn.createStatement();
            st.executeQuery(sql);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
