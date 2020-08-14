package dev.valhala.slam.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Data de cadastro do dado
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Calendar createdAt;

    //Data de alteração do dado
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "altered_at")
    @LastModifiedDate
    private Calendar alteredAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public String getCreateAtString() {
        if(createdAt==null){
            return "noCreationDate";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(createdAt.getTime());
    }

    public Calendar getAlteredAt() {
        return alteredAt;
    }

    public void setAlteredAt(Calendar alterAt) {
        this.createdAt = alterAt;
    }

    public String getAlteredAtString() {
        if(alteredAt==null){
            return "noAlterDate";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(alteredAt.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id.equals(that.id) &&
                createdAt.equals(that.createdAt) &&
                Objects.equals(alteredAt, that.alteredAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, alteredAt);
    }
}