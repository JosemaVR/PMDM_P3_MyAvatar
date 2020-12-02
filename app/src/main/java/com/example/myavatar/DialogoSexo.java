package com.example.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoSexo extends DialogFragment {

    Avatar avatar;
    OnNuevoDialogoListener mListener;

    public DialogoSexo(Avatar avatar) {
        this.avatar = avatar;
    }

    public Dialog onCreateDialog (@Nullable Bundle savedInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View vista = inflater.inflate(R.layout.dialogo_sexo, null);
        builder.setView(vista);
        builder.setTitle("Sexo del Avatar")
                .setPositiveButton("Siguiente", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        RadioGroup sexo = vista.findViewById(R.id.groupSexo);
                        int selectedId = sexo.getCheckedRadioButtonId();
                        RadioButton radioButton = (RadioButton) sexo.findViewById(selectedId);
                        avatar.setSexo((String) radioButton.getText());
                        dialog.dismiss();
                        mListener.siguiente("especie");
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
