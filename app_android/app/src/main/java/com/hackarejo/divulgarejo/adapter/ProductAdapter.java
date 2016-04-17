package com.hackarejo.divulgarejo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hackarejo.divulgarejo.vo.ProductVO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by bruno on 17/04/16.
 */
public class ProductAdapter  extends ArrayAdapter<ProductVO> {

    private Context context;

    private int resource;

    private List<ProductVO> productsList;

    public ProductAdapter(Context context, int resource, List<ProductVO> objects) {

        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.productsList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Obtem o objeto do serviço de interpretaçao de layout. Este serviço permitira converter o layout XML do item da lista em um objeto Java que poderá
        // ser manipulado para valorização dos campos do item da lista.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        RelativeLayout item = (RelativeLayout)inflater.inflate(resource, null);

        ProductVO trabalho = productsList.get(position);

        TextView lblTitulo = (TextView) item.findViewById(R.id.lblTitulo);
        lblTitulo.setText(trabalho.getTitulo());

        TextView lblDisciplina = (TextView) item.findViewById(R.id.lblDisciplina);
        lblDisciplina.setText(trabalho.getDisciplina());

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        TextView lblData = (TextView) item.findViewById(R.id.lblData);
        lblData.setText(df.format(trabalho.getDataEntrega()));

        if(trabalho.isEntregue()){
            item.setBackgroundColor(Color.parseColor("#39A652"));
        }else {
            Date hoje = new Date();

            Calendar cal = Calendar.getInstance();

            cal.setTime(trabalho.getDataEntrega());

            cal.add(Calendar.DATE, -3);

            if (hoje.after(cal.getTime())) {
                item.setBackgroundColor(Color.parseColor("#E2413E"));
            } else {
                cal.add(Calendar.DATE, -2);

                if (hoje.after(cal.getTime())) {
                    item.setBackgroundColor(Color.parseColor("#F9EE5C"));
                }
            }
        }
        return item;
    }
}