package com.devmasterteam.carros.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.devmasterteam.carros.R;
import com.devmasterteam.carros.contants.ModelosContants;
import com.devmasterteam.carros.data.ModeloMock;
import com.devmasterteam.carros.entities.Modelo;
import com.squareup.picasso.Picasso;

public class DetalhesActivity extends AppCompatActivity {

    // Variáveis da classe
    private ViewHolder mViewHolder = new ViewHolder();
    private ModeloMock mModeloMock;
    private Modelo mModelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Instancia variáveis
        this.mModeloMock = new ModeloMock(this);

        // Instancia elementos de interfacew
        this.mViewHolder.imgCarPicture = (ImageView) this.findViewById(R.id.movieImage);
        this.mViewHolder.textModel = (TextView) this.findViewById(R.id.text_model);


        // Obtém o valor passado por parâmetro
        this.getDataFromActivity();

        // Atribui os valores aos elementos de interface
        this.setData();

    }

    /**
     * Atribui os valores aos elementos de interface
     */
    private void setData() {

        this.mViewHolder.textModel.setText(this.mModelo.model);

        /* PARTE PARA RECEBER A IMAGEM PICASSO QUE NAO CONSEGUI PARA A DETALHE ACTIVITY QUE NAO CONSEGUE*/


    }

    /**
     * Obtém o valor passado por parâmetro
     */
    private void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mModelo = this.mModeloMock.get(extras.getInt(ModelosContants.MODELO_ID));
        }
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        ImageView imgCarPicture;
        TextView textModel;

    }

}
