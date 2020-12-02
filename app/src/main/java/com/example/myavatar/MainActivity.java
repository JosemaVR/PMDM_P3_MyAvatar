package com.example.myavatar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnNuevoDialogoListener {

    Button btnCrear;
    ImageView imgEspecie, imgProfesion;
    TextView lblVida, lblFuerza, lblVelocidad, lblMagia, lblNombre,
            lblVidaRes, lblFuerzaRes, lblMagiaRes, lblVelocidadRes, lblTipo;
    ProgressBar pgVida, pgFuerza, pgVelocidad, pgMagia;
    static Avatar avatar = new Avatar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(this);

        imgEspecie = findViewById(R.id.imgEspecie);
        imgEspecie.setImageResource(R.drawable.ic_espada);
        imgEspecie.setVisibility(View.INVISIBLE);

        imgProfesion = findViewById(R.id.imgProfesion);
        imgProfesion.setImageResource(R.drawable.ic_hombre_enano);
        imgProfesion.setVisibility(View.INVISIBLE);

        lblVida = findViewById(R.id.lblVida);
        lblVida.setVisibility(View.INVISIBLE);

        lblFuerza = findViewById(R.id.lblFuerza);
        lblFuerza.setVisibility(View.INVISIBLE);

        lblVelocidad = findViewById(R.id.lblVelocidad);
        lblVelocidad.setVisibility(View.INVISIBLE);

        lblMagia = findViewById(R.id.lblMagia);
        lblMagia.setVisibility(View.INVISIBLE);

        lblNombre = findViewById(R.id.lblNombre);
        lblNombre.setVisibility(View.INVISIBLE);

        lblTipo = findViewById(R.id.lblTipo);
        lblTipo.setVisibility(View.INVISIBLE);

        pgVida = findViewById(R.id.progressBarVida);
        pgVida.setVisibility(View.INVISIBLE);

        pgFuerza = findViewById(R.id.progressBarFuerza);
        pgFuerza.setVisibility(View.INVISIBLE);

        pgMagia = findViewById(R.id.progressBarMagia);
        pgMagia.setVisibility(View.INVISIBLE);

        pgVelocidad = findViewById(R.id.progressBarVelocidad);
        pgVelocidad.setVisibility(View.INVISIBLE);

        lblVidaRes = findViewById(R.id.lblVidaRes);
        lblVidaRes.setVisibility(View.INVISIBLE);

        lblFuerzaRes = findViewById(R.id.lblFuerzaRes);
        lblFuerzaRes.setVisibility(View.INVISIBLE);

        lblMagiaRes = findViewById(R.id.lblMagiaRes);
        lblMagiaRes.setVisibility(View.INVISIBLE);

        lblVelocidadRes = findViewById(R.id.lblVelocidadRes);
        lblVelocidadRes.setVisibility(View.INVISIBLE);
    }

    public void onClick(View v) {
        if(v.equals(btnCrear)){
            DialogoNombre dialogoNombre = new DialogoNombre(avatar);
            dialogoNombre.show(getSupportFragmentManager(), "Dialogo del nombre");
        }
    }

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
                hacerVisible();
                mostrarAvatar();
                break;
        }
    }

    private void mostrarAvatar() {
        if(avatar.getSexo().equals("Hombre")){
            switch (avatar.getEspecie()) {
                case "Humano":
                    imgEspecie.setImageResource(R.drawable.ic_hombre_humano);
                    break;
                case "Elfo":
                    imgEspecie.setImageResource(R.drawable.ic_hombre_elfo);
                    break;
                case "Enano":
                    imgEspecie.setImageResource(R.drawable.ic_hombre_enano);
                    break;
                case "Hobbit":
                    imgEspecie.setImageResource(R.drawable.ic_hombre_hobbit);
                    break;
            }
        } else if (avatar.getSexo().equals("Mujer")){
            switch (avatar.getEspecie()) {
                case "Humano":
                    imgEspecie.setImageResource(R.drawable.ic_mujer_humana);
                    break;
                case "Elfo":
                    imgEspecie.setImageResource(R.drawable.ic_mujer_elfa);
                    break;
                case "Enano":
                    imgEspecie.setImageResource(R.drawable.ic_mujer_enana);
                    break;
                case "Hobbit":
                    imgEspecie.setImageResource(R.drawable.ic_mujer_hobbit);
                    break;
            }
        }
        imgEspecie.setVisibility(View.VISIBLE);

        switch (avatar.getProfesion()) {
            case "Arquero":
                imgProfesion.setImageResource(R.drawable.ic_arco);
                break;
            case "Guerrero":
                imgProfesion.setImageResource(R.drawable.ic_espada);
                break;
            case "Mago":
                imgProfesion.setImageResource(R.drawable.ic_magia);
                break;
            case "Herrero":
                imgProfesion.setImageResource(R.drawable.ic_herrero);
                break;
            case "Minero":
                imgProfesion.setImageResource(R.drawable.ic_minero);
                break;
        }
        imgProfesion.setVisibility(View.VISIBLE);
    }

    @SuppressLint("SetTextI18n")
    private void hacerVisible() {
        btnCrear.setVisibility(View.INVISIBLE);

        lblNombre.setText(avatar.getNombre());
        lblNombre.setVisibility(View.VISIBLE);

        lblTipo.setText(avatar.getEspecie() + " - " + avatar.getSexo() + " - " + avatar.getProfesion());
        lblTipo.setVisibility(View.VISIBLE);

        pgVida.setMax(100);
        pgVida.setProgress(avatar.getVida());
        pgVida.setVisibility(View.VISIBLE);
        pgVida.getProgressDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        pgFuerza.setMax(100);
        pgFuerza.setProgress(avatar.getFuerza());
        pgFuerza.setVisibility(View.VISIBLE);
        pgFuerza.getProgressDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        pgMagia.setMax(100);
        pgMagia.setProgress(avatar.getMagia());
        pgMagia.setVisibility(View.VISIBLE);
        pgMagia.getProgressDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        pgVelocidad.setMax(100);
        pgVelocidad.setProgress(avatar.getVelocidad());
        pgVelocidad.setVisibility(View.VISIBLE);
        pgVelocidad.getProgressDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        lblVidaRes.setText(avatar.getVida()+"");
        lblVidaRes.setVisibility(View.VISIBLE);

        lblFuerzaRes.setText(avatar.getFuerza()+"");
        lblFuerzaRes.setVisibility(View.VISIBLE);

        lblMagiaRes.setText(avatar.getMagia()+"");
        lblMagiaRes.setVisibility(View.VISIBLE);

        lblVelocidadRes.setText(avatar.getVelocidad()+"");
        lblVelocidadRes.setVisibility(View.VISIBLE);

        lblVida.setVisibility(View.VISIBLE);

        lblMagia.setVisibility(View.VISIBLE);

        lblFuerza.setVisibility(View.VISIBLE);

        lblVelocidad.setVisibility(View.VISIBLE);
    }

    @Override
    public void resetear() {
        avatar.setNombre("");
        avatar.setEspecie("");
        avatar.setSexo("");
        avatar.setProfesion("");
    }
}