package dev.valhala.slam.models;

import dev.valhala.slam.enuns.DeviceStatus;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

@Entity(name = "devices")
public class Devices extends AbstractEntity {

    @Column(name="local")
    private String local;

    @Column(name="device")
    private String device;

    @Column(name="token")
    private String token;

    @Column(name="status")
    private DeviceStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_last_alter")
    private Calendar dateLastAlter;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_activation")
    private Calendar dateActivation;

    public Devices() {
    }

    public Devices(String local, String device, String token, DeviceStatus status, Calendar dateLastAlter, Calendar dateActivation) {
        this.local = local;
        this.device = device;
        this.token = token;
        this.status = status;
        this.dateLastAlter = dateLastAlter;
        this.dateActivation = dateActivation;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public Calendar getDateLastAlter() {
        return dateLastAlter;
    }

    public void setDateLastAlter(Calendar dateLastAlter) {
        this.dateLastAlter = dateLastAlter;
    }

    public Calendar getDateActivation() {
        return dateActivation;
    }

    public void setDateActivation(Calendar dateActivation) {
        this.dateActivation = dateActivation;
    }

    //TODO: verificar o calculo do uptime "to fazendo merda"
    public String getUptime(){
        if(dateActivation == null){
            return "Inativo";
        }
        if(DeviceStatus.OFFLINE == status || DeviceStatus.DESATIVADO == status){
            return "Inativo";
        }
        long days =  Calendar.getInstance().getTimeInMillis() - dateActivation.getTimeInMillis() ;

        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(days);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(time.getTime());
    }

    @PreUpdate
    public void alterData(){
        this.dateLastAlter = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("America/Sao_Paulo")));
    }

    @Override
    public String toString() {
        return "Devices{" +
                "id='" + getId() + '\'' +
                ", local='" + local + '\'' +
                ", device='" + device + '\'' +
                ", token='" + token + '\'' +
                ", status=" + status +
                ", dateLastAlter=" + dateLastAlter +
                ", dateActivation=" + dateActivation +
                '}';
    }

}
