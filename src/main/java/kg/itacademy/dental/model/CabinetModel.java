package kg.itacademy.dental.model;

import kg.itacademy.dental.entity.Dentist;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Getter
@Setter
public class CabinetModel {

    private Long id;
    private String codeCabinet;

    @ManyToMany
    @JoinColumn(name = "dentist_id")
    Dentist dentist;
}