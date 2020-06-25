package dev.valhala.slam.models;


import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Objects;
import java.util.TimeZone;

@MappedSuperclass
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registry_date")
    private Calendar registryDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRegistryDate(Calendar registryDate) {
        this.registryDate = registryDate;
    }

    public Calendar getRegistryDate() {
        return registryDate;
    }

    public String getDataCadastroString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(registryDate.getTime());
    }

    @PrePersist
    public void loadData(){
        this.registryDate = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("America/Sao_Paulo")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id+registryDate.toString());
    }
}
