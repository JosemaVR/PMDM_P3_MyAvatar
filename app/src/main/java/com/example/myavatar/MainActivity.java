package com.example.myavatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnNuevoDialogoListener {

    Button btnCrear;
    Button btnVer;
    ImageView imgEspecie, imgProfesion;
    TextView lblVida, lblFuerza, lblVelocidad, lblMagia, lblNombre,
            lblVidaRes, lblFuerzaRes, lblMagiaRes, lblVelocidadRes;
    ProgressBar pgVida, pgFuerza, pgVelocidad, pgMagia;
    static Avatar avatar = new Avatar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(this);

        imgEspecie = findViewById(R.id.imgEspecie);
        imgEspecie.setVisibility(View.INVISIBLE);

        imgProfesion = findViewById(R.id.imgProfesion);
      //  imgProfesion.setVisibility(View.INVISIBLE);

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

        btnVer = findViewById(R.id.btnVer);
        btnVer.setOnClickListener(this);
    }

    public void onClick(View v) {
        if(v.equals(btnCrear)){
            DialogoNombre dialogoNombre = new DialogoNombre(avatar);
            dialogoNombre.show(getSupportFragmentManager(), "Dialogo del nombre");
        }
        if(v.equals(btnVer)){
            Toast.makeText(this, avatar.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void siguiente(String dialogo) {
        if(dialogo=="nombre"){
            DialogoNombre dialogoNombre = new DialogoNombre(avatar);
            dialogoNombre.show(getSupportFragmentManager(), "Dialogo del nombre");
        } else if(dialogo=="sexo"){
            DialogoSexo dialogoSexo = new DialogoSexo(avatar);
            dialogoSexo.show(getSupportFragmentManager(), "Dialogo del sexo");
        } else if (dialogo=="especie"){
            DialogoEspecie dialogoEspecie = new DialogoEspecie(avatar);
            dialogoEspecie.show(getSupportFragmentManager(), "Dialogo de la especie");
        } else if (dialogo=="profesion"){
            DialogoProfesion dialogoProfesion = new DialogoProfesion(avatar);
            dialogoProfesion.show(getSupportFragmentManager(), "Dialogo de la profesión");
        } else {
            btnCrear.setVisibility(View.INVISIBLE);

            lblNombre.setText(avatar.getNombre());
            lblNombre.setVisibility(View.VISIBLE);

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

            if(avatar.getSexo()=="hombre"){
                if(avatar.getEspecie()=="humano"){
                    imgEspecie.setImageDrawable(getResources().getDrawable(R.drawable.ic_hombre_humano));
                } else if(avatar.getEspecie()=="elfo"){
                    imgEspecie.setImageResource(R.drawable.ic_hombre_elfo);
                } else if(avatar.getEspecie()=="enano"){
                    imgEspecie.setImageResource(R.drawable.ic_hombre_enano);
                } else if(avatar.getEspecie()=="hobbit"){
                    imgEspecie.setImageResource(R.drawable.ic_hombre_hobbit);
                }
            } else if (avatar.getSexo()=="mujer"){
                if(avatar.getEspecie()=="humano"){
                    imgEspecie.setImageResource(R.drawable.ic_mujer_humana);
                } else if(avatar.getEspecie()=="elfo"){
                    imgEspecie.setImageResource(R.drawable.ic_mujer_elfa);
                } else if(avatar.getEspecie()=="enano"){
                    imgEspecie.setImageResource(R.drawable.ic_mujer_enana);
                } else if(avatar.getEspecie()=="hobbit"){
                    imgEspecie.setImageResource(R.drawable.ic_mujer_hobbit);
                }
            }
            imgEspecie.setVisibility(View.VISIBLE);
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