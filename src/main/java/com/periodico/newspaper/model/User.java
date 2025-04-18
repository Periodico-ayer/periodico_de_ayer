package com.periodico.newspaper.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "user_id_sequence", sequenceName = "user_id_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_sequence")
    private Integer id;

    @Column
    @NotBlank(message = "[ERROR!] El campo de nombre no puede estar vacio y tampoco tener espacios")
    @Pattern(regexp = "^[^\\/:*?\\\"<>|]+$", message = "[ERROR!] No está permitido el uso de caracteres especiales")
    @Size(max = 20, message = "[ERROR!] Máximo de 20 caracteres permitidos en este campo")
    private String name;

    @Column
    @NotBlank(message = "[ERROR!] El campo de apellido no puede estar vacio y tampoco tener espacios")
    @Pattern(regexp = "^[^\\/:*?\\\"<>|]+$", message = "[ERROR!] No está permitido el uso de caracteres especiales")
    @Size(max = 20, message = "[ERROR!] Máximo de 20 caracteres permitidos en este campo")
    private String lastName;

    @Column
    @Email(message = "[ERROR!] Por favor, ingrese un formato válido de email")
    @NotBlank(message = "[ERROR!] El campo de email no puede estar vacio y tampoco tener espacios")
    @Size(max = 50, message = "[ERROR!] Máximo de 50 caracteres permitidos en este campo")
    private String email;

    public User() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return id.equals(user.id);
    }

}
