package dev.valhala.slam.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "measures")
@JsonDeserialize
public class Measures extends AbstractEntity implements Serializable {

    @Column(name = "tensao")
    @JsonProperty("tensao")
    private double tensao;

    @Column(name = "corrente")
    @JsonProperty("corrente")
    private double corrente;

    @Column(name = "potencia")
    @JsonProperty("potencia")
    private double potencia;

    @Column(name = "energia")
    @JsonProperty("energia")
    private double energia;

    @Column(name = "angulo")
    @JsonProperty("angulo")
    private double angulo;

    @ManyToOne
    private Devices devices;

    public Measures() {
    }

    public Measures(double tensao, double corrente, double potencia, double energia, double angulo, Devices devices) {
        this.tensao = tensao;
        this.corrente = corrente;
        this.potencia = potencia;
        this.energia = energia;
        this.angulo = angulo;
        this.devices = devices;
    }

    public double getTensao() {
        return tensao;
    }

    public void setTensao(double tensao) {
        this.tensao = tensao;
    }

    public double getCorrente() {
        return corrente;
    }

    public void setCorrente(double corrente) {
        this.corrente = corrente;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public Devices getDevices() {
        return devices;
    }

    public void setDevices(Devices devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Mensure{" +
                "tensao=" + tensao +
                ", corrente=" + corrente +
                ", potencia=" + potencia +
                ", energia=" + energia +
                ", angulo=" + angulo +
                ", device=" + devices.toString() +
                '}';
    }
}
