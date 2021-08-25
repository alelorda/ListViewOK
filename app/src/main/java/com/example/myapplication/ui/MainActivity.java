package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ContactoAdapter;
import com.example.myapplication.models.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listaContactos;
    private ArrayList<Contacto> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<Contacto>();
        lista.add(new Contacto(1,"2","3"));

        listaContactos = findViewById(R.id.lvContacto);
        listaContactos.setAdapter(new ContactoAdapter(lista));

        listaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contacto item = lista.get(position);

                Toast.makeText(view.getContext(), item.getNombre() + " " + item.getApellido(), Toast.LENGTH_LONG).show();
            }
        });
    }
}