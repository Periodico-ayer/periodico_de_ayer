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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table( name = "users")
public class User {
    @Id
    @SequenceGenerator(
        name="user_id_sequence",
        sequenceName = "user_id_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_id_sequence"
    )
    private Integer id;
    @Column
    @NotNull(message="El campo del nombre no puede estar vacío")
    @Pattern(regexp = "^[^\\/:*?\\\"<>|]+$", message = "No está permitido el uso de caracteres especiales")
    @Size(max=20, message = "Máximo de 20 caracteres permitidos en este campo")
    private String name;
    @Column
    @NotNull(message ="El campo del apellido no puede estar vacio")
    @Pattern(regexp = "^[^\\/:*?\\\"<>|]+$", message = "No está permitido el uso de caracteres especiales")
    @Size(max =20, message = "Máximo de 20 caracteres permitidos en este campo")
    private String lastName;
    @Column
    @Email(message="Por favor, ingrese un formato válido de email")
    @NotNull(message="El campo del correo no puede estar vacio")
    @Size(max =50, message = "Máximo de 50 caracteres permitidos en este campo")
    private String email;

        public User(){}

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
        
    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Article> articles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    

 }

