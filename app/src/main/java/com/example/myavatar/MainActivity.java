package com.example.myavatar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnNuevoDialogoListener {

    Button btnCrear;
    ImageButton btnCerrar;
    static Avatar avatar = new Avatar();
    FragmentManager fm = getSupportFragmentManager();
    Fragment mostrar;
    FragmentTransaction ft;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(this);
        btnCrear.setTextSize(25);

        btnCerrar = findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(this);
        btnCerrar.setVisibility(View.INVISIBLE);
    }

    public void onClick(View v) {
        if(v.equals(btnCrear)){
            DialogoNombre dialogoNombre = new DialogoNombre(avatar);
            dialogoNombre.show(getSupportFragmentManager(), "Dialogo del nombre");
        }
        if(v.equals(btnCerrar)){
            btnCerrar.setVisibility(View.INVISIBLE);
            getSupportFragmentManager().beginTransaction().
                    remove(getSupportFragmentManager().findFragmentById(R.id.contenedorFragmento)).commit();
            avatar = new Avatar();
            btnCrear.setVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void siguiente(String dialogo) {
        switch (dialogo) {
            case "nombre":
                DialogoNombre dialogoNombre = new DialogoNombre(avatar);
                dialogoNombre.show(getSupportFragmentManager(), "Dialogo del nombre");
                break;
            case "sexo":
                DialogoSexo dialogoSexo = new DialogoSexo(avatar);
                dialogoSexo.show(getSupportFragmentManager(), "Dialogo del sexo");
                break;
            case "especie":
                DialogoEspecie dialogoEspecie = new DialogoEspecie(avatar);
                dialogoEspecie.show(getSupportFragmentManager(), "Dialogo de la especie");
                break;
            case "profesion":
                DialogoProfesion dialogoProfesion = new DialogoProfesion(avatar);
                dialogoProfesion.show(getSupportFragmentManager(), "Dialogo de la profesión");
                break;
            default:
                btnCrear.setVisibility(View.INVISIBLE);
                btnCerrar.setVisibility(View.VISIBLE);
                mostrar = fm.findFragmentByTag("mostrar");
                if (null == mostrar) {
                    ft = fm.beginTransaction();
                    Bundle datosAEnviar = new Bundle();
                    datosAEnviar.putString("nombre", avatar.getNombre());
                    datosAEnviar.putString("sexo", avatar.getSexo());
                    datosAEnviar.putString("especie", avatar.getEspecie());
                    datosAEnviar.putString("profesion", avatar.getProfesion());
                    datosAEnviar.putInt("vida", avatar.getVida());
                    datosAEnviar.putInt("magia", avatar.getMagia());
                    datosAEnviar.putInt("fuerza", avatar.getFuerza());
                    datosAEnviar.putInt("velocidad", avatar.getVelocidad());
                    Fragment fragmento = new Mostrar();
                    fragmento.setArguments(datosAEnviar);
                    ft.replace(R.id.contenedorFragmento, fragmento);
                    ft.commit();
                }
                break;
        }
    }

    @Override
    public void resetear() {
        avatar.setNombre("");
        avatar.setEspecie("");
        avatar.setSexo("");
        avatar.setProfesion("");
    }
}