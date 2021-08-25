package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.models.Contacto;

import java.util.List;

public class ContactoAdapter extends BaseAdapter {

    private List<Contacto> contactos;

    public ContactoAdapter(List<Contacto> contacos) {
        this.contactos = contacos;
    }

    @Override
    public int getCount() {
        return contactos.size();
    }

    @Override
    public Object getItem(int position) {
        return contactos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contactos.get(position).getTelefono();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        //optimizacion de reutilizacion de recursos
        if(convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacto_item,parent,false);
        }else{
            view = convertView;
        }

        Contacto contacto = (Contacto)getItem(position);

        TextView textViewTelefono = (TextView) view.findViewById(R.id.textViewTelefono);
        TextView textViewNombre = (TextView) view.findViewById(R.id.textViewNombre);
        TextView textViewApellido = (TextView) view.findViewById(R.id.textViewApellido);

        textViewTelefono.setText(String.valueOf(contacto.getTelefono()));
        textViewNombre.setText(contacto.getNombre());
        textViewApellido.setText(contacto.getApellido());

        return view;
    }
}
