package com.misiontic.Resevaciones.models;
import org.springframework.data.annotation.Id;

import java.util.Date;


public class Reserva {
    @Id
    private String username;
    private String reserUsurious;
    private String reserHabitation;
    private Date   fetchIngress;
    private Date   fetchSaida;

    public Reserva(String username, String reserUsurious, String reserHabitation, Date fetchIngress, Date fetchSaida){

        this.username = username;
        this.reserUsurious = reserUsurious;
        this.reserHabitation = reserHabitation;
        this.fetchIngress = fetchIngress;
        this.fetchSaida = fetchSaida;

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReserUsurious() {
        return reserUsurious;
    }

    public void setReserUsurious(String reserUsurious) {
        this.reserUsurious = reserUsurious;
    }

    public String getReserHabitation() {
        return reserHabitation;
    }

    public void setReserHabitation(String reserHabitation) {
        this.reserHabitation = reserHabitation;
    }

    public Date getFetchIngress() {
        return fetchIngress;
    }

    public void setFetchIngress(Date fetchIngress) {
        this.fetchIngress = fetchIngress;
    }

    public Date getFetchSaida() {
        return fetchSaida;
    }

    public void setFetchSaida(Date fetchSaida) {
        this.fetchSaida = fetchSaida;
    }
}
