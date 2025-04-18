package com.periodico.newspaper.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "articles")
public class Article {

    @Id

    @SequenceGenerator(name = "article_id_sequence", sequenceName = "article_id_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_id_sequence")
    private Integer id;

    @Column
    @NotBlank(message = "[ERROR!] El campo de título no puede estar vacio y tampoco tener espacios")
    @Size(max = 255, message = "[ERROR!] Máximo de 255 caracteres permitidos en este campo")
    private String title;

    @Column
    @NotBlank(message = "[ERROR!] El campo de contenido no puede estar vacio y tampoco tener espacios")
    @Size(min = 50, max = 2000, message = "[ERROR!] Mínimo de 50 y máximo de 2000 caracteres permitidos en este campo")
    private String content;

    @CreationTimestamp
    private LocalDateTime created_on;

    @UpdateTimestamp
    private LocalDateTime updated_on;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Article() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return this.created_on;
    }

    public void setDate(LocalDateTime createdOn) {
        this.created_on = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return this.updated_on;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updated_on = updatedOn;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Article article = (Article) o;
        return id.equals(article.id);
    }

}
