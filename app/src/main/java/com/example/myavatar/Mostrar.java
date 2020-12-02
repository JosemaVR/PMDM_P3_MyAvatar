package com.example.myavatar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Mostrar extends Fragment {

    ImageView imgEspecie, imgProfesion;
    TextView lblVida, lblFuerza, lblVelocidad, lblMagia, lblNombre,
            lblVidaRes, lblFuerzaRes, lblMagiaRes, lblVelocidadRes, lblTipo;
    ProgressBar pgVida, pgFuerza, pgVelocidad, pgMagia;
    String nombre, sexo, especie, profesion;
    int vida, magia, fuerza, velocidad;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_avatar, container, false);
    }

    public void onViewCreated(View v, Bundle b){
        Bundle datosRecuperados = getArguments();

        nombre = datosRecuperados.getString("nombre");
        sexo = datosRecuperados.getString("sexo");
        especie = datosRecuperados.getString("especie");
        profesion = datosRecuperados.getString("profesion");
        vida = datosRecuperados.getInt("vida");
        magia = datosRecuperados.getInt("magia");
        fuerza = datosRecuperados.getInt("fuerza");
        velocidad = datosRecuperados.getInt("velocidad");

        imgEspecie = v.findViewById(R.id.imgEspecie);
        imgProfesion = v.findViewById(R.id.imgProfesion);
        lblVida = v.findViewById(R.id.lblVida);
        lblFuerza = v.findViewById(R.id.lblFuerza);
        lblVelocidad = v.findViewById(R.id.lblVelocidad);
        lblMagia = v.findViewById(R.id.lblMagia);
        lblNombre = v.findViewById(R.id.lblNombre);
        lblTipo = v.findViewById(R.id.lblTipo);
        pgVida = v.findViewById(R.id.progressBarVida);
        pgFuerza = v.findViewById(R.id.progressBarFuerza);
        pgMagia = v.findViewById(R.id.progressBarMagia);
        pgVelocidad = v.findViewById(R.id.progressBarVelocidad);
        lblVidaRes = v.findViewById(R.id.lblVidaRes);
        lblFuerzaRes = v.findViewById(R.id.lblFuerzaRes);
        lblMagiaRes = v.findViewById(R.id.lblMagiaRes);
        lblVelocidadRes = v.findViewById(R.id.lblVelocidadRes);

        hacerVisible();
        mostrarAvatar();
    }



    private void mostrarAvatar() {
        if(sexo.equals("Hombre")){
            switch (especie) {
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
        } else if (sexo.equals("Mujer")){
            switch (especie) {
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

        switch (profesion) {
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
    }

    @SuppressLint("SetTextI18n")
    private void hacerVisible() {

        lblNombre.setText(nombre);

        lblTipo.setText(especie + " - " + sexo + " - " + profesion);

        pgVida.setMax(100);
        pgVida.setProgress(vida);
        pgVida.getProgressDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        pgFuerza.setMax(100);
        pgFuerza.setProgress(fuerza);
        pgFuerza.getProgressDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        pgMagia.setMax(100);
        pgMagia.setProgress(magia);
        pgMagia.getProgressDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        pgVelocidad.setMax(100);
        pgVelocidad.setProgress(velocidad);
        pgVelocidad.getProgressDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        lblVidaRes.setText(vida+"");
        lblFuerzaRes.setText(fuerza+"");
        lblMagiaRes.setText(magia+"");
        lblVelocidadRes.setText(velocidad+"");
    }
}