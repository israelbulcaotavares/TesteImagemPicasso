package com.devmasterteam.carros.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.devmasterteam.carros.R;
import com.devmasterteam.carros.adapter_e_viewholder.ModeloListAdapter;
import com.devmasterteam.carros.contants.ModelosContants;
import com.devmasterteam.carros.data.ModeloMock;
import com.devmasterteam.carros.entities.Modelo;
import com.devmasterteam.carros.listener.OnListClickInteractionListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Variáveis da classe
    private ViewHolder mViewHolder = new ViewHolder();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Instancia variáveis
        this.mContext = this;

        // Instacia mock
        ModeloMock modeloMock = new ModeloMock(this);
        List<Modelo> modeloList = new ArrayList<>();
        modeloList.addAll(modeloMock.getList());

        // 1 - Obter a recyclerview
        this.mViewHolder.mRecyclerModelos = (RecyclerView) this.findViewById(R.id.recycler_modelos);

        // Implementa o evento de click para passar por parâmetro para a ViewHolder
        OnListClickInteractionListener listener = new OnListClickInteractionListener() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(ModelosContants.MODELO_ID, id);

                Intent intent = new Intent(mContext, DetalhesActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        };

        // 2 - Definir adapter passando listagem de carros e listener
        ModeloListAdapter modeloListAdapter = new ModeloListAdapter( getApplicationContext() , modeloList , listener);
        this.mViewHolder.mRecyclerModelos.setAdapter(modeloListAdapter);

        // 3 - Definir um layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewHolder.mRecyclerModelos.setLayoutManager(linearLayoutManager);

    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        RecyclerView mRecyclerModelos;
    }

}
