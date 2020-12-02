package com.example.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import static com.example.myavatar.R.layout.activity_main;

public class DialogoNombre extends DialogFragment {

    Avatar avatar;
    OnNuevoDialogoListener mListener;

    public DialogoNombre(Avatar avatar) {
        this.avatar = avatar;
    }

    @NonNull
    public Dialog onCreateDialog (@Nullable Bundle savedInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View vista = inflater.inflate(R.layout.dialogo_nombre, null);
        builder.setView(vista);
        builder.setTitle("Nombre del Avatar")
                .setPositiveButton("Siguiente", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText edit = vista.findViewById(R.id.txtNombre);
                        String nombre = edit.getText().toString();
                        avatar.setNombre(nombre);
                        if(avatar.getNombre().equals("")){
                            dialog.dismiss();
                            mListener.siguiente("nombre");
                        } else {
                            dialog.dismiss();
                            mListener.siguiente("sexo");
                        }
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.resetear();
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }

    public void onAttach(Context context){
        super.onAttach(context);
        try{
            mListener = (OnNuevoDialogoListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + " debe implementar OnNuevoDialogoListener");
        }
    }
}
