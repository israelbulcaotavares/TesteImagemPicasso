package com.devmasterteam.carros.data;

import android.app.Activity;
import android.support.v4.content.ContextCompat;

import com.devmasterteam.carros.R;
import com.devmasterteam.carros.entities.Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe mock implementada para simular um repositório de dados
 * Ex: Banco de dados, chamada a serviço API
 */
public class ModeloMock {

    // Lista de carros
    private List<Modelo> mListModelos;

    /**
     * Construtor - Inicia Mock
     */
    public ModeloMock(Activity activity) {
        this.mListModelos = getCarMockList(activity);
    }

    /**
     * Retorna lista de carros
     */
    public List<Modelo> getList() {
        return this.mListModelos;
    }

    /**
     * Retorna carro de acordo com o Id
     */
    public Modelo get(int id) {
        return this.mListModelos.get(id);
    }

    private List<Modelo> getCarMockList(Activity activity) {
        List<Modelo> mMockList = new ArrayList<>();
        int id = 0;

        Modelo audiR8 = new Modelo(id, "Audi R8","https://media.caranddriver.com/images/10q2/339155/audi-r8-spyder-news-audi-r8-spyder-v8-car-and-driver-photo-357099-s-450x274.jpg");
        mMockList.add(audiR8);

        Modelo bugattiChiron = new Modelo(++id, "Bugatti Chiron","https://assets.bugatti.com/fileadmin/user_upload/Web/Pages/Models/Super_Sport/BUG_super_sport_02.jpg");
        mMockList.add(bugattiChiron);

        Modelo civicTypeR = new Modelo(++id, "Civic Type R","https://www.honda.com.au/content/dam/honda/cars/models/civic-typer-2017/prelaunch/civic-type-r-style.jpg");
        mMockList.add(civicTypeR);

        Modelo corolla = new Modelo(++id, "Corolla","http://www.toyota.com.br/wp-content/themes/toyota/monte-o-seu/corolla/car-page/ciclo/gli_at_couro_040.png");
        mMockList.add(corolla);

        Modelo ferrari458Italia = new Modelo(++id, "Ferrari 458 Itália","https://www.cstatic-images.com/stock/900x600/1426624348628.jpg");
        mMockList.add(ferrari458Italia);

        Modelo ferrariF60America = new Modelo(++id, "Ferrari F60 América","https://www.topgear.com/sites/default/files/styles/16x9_1280w/public/news/image/2015/04/Large%20Image_10571.jpg?itok=zrnob-JY");
        mMockList.add(ferrariF60America);

        // e assim em diante

        return mMockList;
    }

}
