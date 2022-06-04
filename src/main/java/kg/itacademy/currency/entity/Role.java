package kg.itacademy.currency.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "currency_role")
@Entity
@Getter
@Setter
public class Role extends BaseEntity {
    @Column(name = "name_role", nullable = false, unique = true)
    private String nameRole;
}
