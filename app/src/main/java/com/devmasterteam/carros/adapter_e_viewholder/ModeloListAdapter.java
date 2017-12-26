package com.devmasterteam.carros.adapter_e_viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devmasterteam.carros.R;
import com.devmasterteam.carros.entities.Modelo;
import com.devmasterteam.carros.listener.OnListClickInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Classe Adapter que extende a classe RecyclerView.Adapter
 * Necessária para implementação da RecyclerView
 */
public class ModeloListAdapter extends RecyclerView.Adapter<ModeloListAdapter.ModeloViewHolder> {

    // Lista de carros
    private List<Modelo> mListModelos;
    private Context context;

    // Interface que define as ações
    private OnListClickInteractionListener mOnListClickInteractionListener;

    /**
     * Construtor
     */
    public ModeloListAdapter(Context context ,List<Modelo> modelos, OnListClickInteractionListener listener) {
        this.context = context;
        this.mListModelos = modelos;
        this.mOnListClickInteractionListener = listener;
    }


    /**
     * Responsável pela criação de linha
     */
    @Override
    public ModeloViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Obtém o contexto
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Instancia o layout para manipulação dos elementos
        View carView = inflater.inflate(R.layout.row_modelo_list, parent, false);

        // Passa a ViewHolder
        return new ModeloViewHolder(carView);
    }

    /**
     * Responsável por atribuir valores após linha criada
     */
    @Override
    public void onBindViewHolder(ModeloViewHolder holder, int position) {
        Modelo modelo = this.mListModelos.get(position);
        holder.bindData(modelo, this.mOnListClickInteractionListener);


        //ACESSANDO O PICASSO
        Picasso.with(context).load( mListModelos.get(position).getUrl_imagem()).resize(340, 200).into(holder.mImgDetails);


    }

    @Override
    public int getItemCount() {
        return this.mListModelos.size();
    }




    /**
     * Responsável por fazer as manipulações de elementos de interface
     */
    public  class ModeloViewHolder extends RecyclerView.ViewHolder {

        // Elemento de interface

        private TextView mTextCarModel;
        private TextView mTextViewDetails;
        private ImageView mImgDetails;


        /**
         * Construtor
         */
        public ModeloViewHolder(View itemView) {
            super(itemView);

            this.mTextCarModel = (TextView) itemView.findViewById(R.id.text_car_model);
            this.mTextViewDetails = (TextView) itemView.findViewById(R.id.text_view_details);
            this.mImgDetails= (ImageView) itemView.findViewById(R.id.movieImage);


        }

        /**
         * Atribui valores aos elementos
         */
        public void bindData(final Modelo modelo, final OnListClickInteractionListener listener) {

            // Altera valor
            this.mTextCarModel.setText(modelo.model);

            //////////////////////////////////////////////////////////////////////
            /* PARTE PARA SETAR O VALOR DA IMAGEM SETANDO QUE NAO CONSEGUI */


            //////////////////////////////////////////////////////////////////





            // Adciona evento de click
            this.mTextViewDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(modelo.id);
                }
            });
        }

    }





}
