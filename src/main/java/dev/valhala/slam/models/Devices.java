package dev.valhala.slam.models;

import dev.valhala.slam.enuns.DeviceStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
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
    @Column(name="date_activation")
    private Calendar dateActivation;

    public Devices() {
    }

    public Devices(String local, String device, String token, DeviceStatus status, Calendar dateActivation) {
        this.local = local;
        this.device = device;
        this.token = token;
        this.status = status;
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

    public Calendar getDateActivation() {
        return dateActivation;
    }

    public void setDateActivation(Calendar dateActivation) {
        this.dateActivation = dateActivation;
    }

    //TODO: verificar o calculo do uptime "to fazendo merda"
    public String getUptime(){
        if(dateActivation == null){
            return "no activation date";
        }
        if(DeviceStatus.OFFLINE == status || DeviceStatus.DESATIVADO == status){
            return DeviceStatus.OFFLINE.name();
        }

//        ZoneId zid = dateActivation.getTimeZone() == null ? ZoneId.systemDefault() : dateActivation.getTimeZone().toZoneId();
        LocalDate dateTime = LocalDate.of(dateActivation.get(Calendar.YEAR),dateActivation.get(Calendar.MONTH) + 1 ,dateActivation.get(Calendar.DATE));

        Long daysActive = ChronoUnit.DAYS.between(dateTime,LocalDate.now());

        return daysActive.toString();
    }

    @Override
    public String toString() {
        return "Devices{" +
                "id='" + getId() + '\'' +
                ", local='" + local + '\'' +
                ", device='" + device + '\'' +
                ", token='" + token + '\'' +
                ", status=" + status +
                ", dateActivation=" + dateActivation +
                '}';
    }

}
