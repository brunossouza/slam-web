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

    @Column(name = "voltage")
    @JsonProperty("voltage")
    private double voltage;

    @Column(name = "current")
    @JsonProperty("current")
    private double current;

    @Column(name = "power")
    @JsonProperty("power")
    private double power;

    @Column(name = "energy")
    @JsonProperty("energy")
    private double energy;

    @Column(name = "angle")
    @JsonProperty("angle")
    private double angle;

    @ManyToOne
    private Devices devices;

    public Measures() {
    }

    public Measures(double voltage, double current, double power, double energy, double angle, Devices devices) {
        this.voltage = voltage;
        this.current = current;
        this.power = power;
        this.energy = energy;
        this.angle = angle;
        this.devices = devices;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Devices getDevices() {
        return devices;
    }

    public void setDevices(Devices devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Measures{" +
                "voltage=" + voltage +
                ", current=" + current +
                ", power=" + power +
                ", energy=" + energy +
                ", angle=" + angle +
                ", devices=" + devices +
                '}';
    }
}