package com.example.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoEspecie extends DialogFragment {

    OnNuevoDialogoListener mListener;
    Avatar avatar;

    public DialogoEspecie(Avatar avatar) {
        this.avatar = avatar;
    }

    @NonNull
    public Dialog onCreateDialog (@Nullable Bundle savedInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(
                new ContextThemeWrapper(getActivity(), R.style.tema_dialogos));
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View vista = inflater.inflate(R.layout.dialogo_especie, null);
        builder.setView(vista);
        builder.setTitle("Especie del Avatar")
                .setPositiveButton("Siguiente", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        RadioGroup especie = vista.findViewById(R.id.groupProfesion);
                        int selectedId = especie.getCheckedRadioButtonId();
                        RadioButton radioButton = (RadioButton) especie.findViewById(selectedId);
                        avatar.setEspecie((String) radioButton.getText());
                        dialog.dismiss();
                        mListener.siguiente("profesion");
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
