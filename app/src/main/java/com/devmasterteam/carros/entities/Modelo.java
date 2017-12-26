package com.devmasterteam.carros.entities;

import android.graphics.drawable.Drawable;

/**
 * Entidade de carros
 */
public class Modelo {

    public int id;
    public String model;
    public String url_imagem;
    public Drawable picture;

    public Modelo(Drawable picture) {
        this.picture = picture;
    }

    public Modelo(int id, String model, String url_imagem) {
        this.id = id;
        this.model = model;
        this.url_imagem = url_imagem;
    }

    public String getUrl_imagem() {
        return url_imagem;
    }

    public void setUrl_imagem(String url_imagem) {
        this.url_imagem = url_imagem;
    }
}