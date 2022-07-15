package com.codedifferently.watertrackerapi.domain.log.models;

import com.codedifferently.watertrackerapi.domain.person.models.Person;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name= "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Double numberOfOz;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    private Person person;

    @PrePersist
    protected void onCreate(){
        date = new Date();
    }
}
