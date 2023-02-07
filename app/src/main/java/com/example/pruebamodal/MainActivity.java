package com.example.pruebamodal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private Button btnModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnModal = (Button) findViewById(R.id.btn_modal);

        btnModal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirDialog(3);
            }
        });
    }

    public void abrirDialog(int opcion) {
        switch (opcion) {
            case 1:
                mostrarDialogo();
                break;
            case 2:
                showDialogPersonalizado();
                break;
            case 3:
                showDialogoList();
                break;
            default:
                mostrarDialogo();
        }
    }

    public void mostrarDialogo() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.styleDialog);
        builder.setTitle("Dialogo")
                .setMessage("mensaje")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Clic Sí", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Clic No", Toast.LENGTH_SHORT).show();
                    }
                })
                // .setCancelable(false)// este es para que no s epueda dar click fuera del dialogo o no lo cierre
                .show();
    }

    public void showDialogPersonalizado() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater layoutInflater = getLayoutInflater();

        View view = layoutInflater.inflate(R.layout.dialog_personalizado, null);

        builder.setView(view);

        AlertDialog dialog = builder.create();

        dialog.show();
    }

    public void showDialogoList(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Lista de Opciones")
                .setItems(R.array.list_opciones_menu, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        Toast.makeText(MainActivity.this, "which: "+which, Toast.LENGTH_SHORT).show();
                    }
                });
        //builder.create();

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}