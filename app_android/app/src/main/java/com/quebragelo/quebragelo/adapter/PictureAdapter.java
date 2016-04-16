package com.quebragelo.quebragelo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Jhony on 09/06/2015.
 */
public class PictureAdapter extends BaseAdapter {

    private Context context;
    private int[] lista;

    public PictureAdapter(Context context, int[] lista) {
        this.context = context;
        this.lista = lista;

    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int position) {
        return lista[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView iv = new ImageView(context);
        iv.setImageResource(lista[position]);
        //Ajusta o tamanho do imageview com o tamanho da colona
        iv.setAdjustViewBounds(true);


        return iv;
    }
}
