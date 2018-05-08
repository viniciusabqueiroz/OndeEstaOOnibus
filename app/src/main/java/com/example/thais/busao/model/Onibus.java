package com.example.thais.busao.model;

import java.util.Date;

/**
 * Created by thais on 08/05/18.
 */

public class Onibus {

    private Date dataHora;
    private String ordem;
    private String linha;
    private Double latitude;
    private Double longitude;

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Onibus{" +
                "dataHora=" + dataHora +
                ", ordem='" + ordem + '\'' +
                ", linha='" + linha + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
