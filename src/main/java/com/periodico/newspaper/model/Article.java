package com.periodico.newspaper.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "articles")
public class Article {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String content;
    // private String date;
    @CreationTimestamp
    private LocalDateTime created_on;

    public Article() {}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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

    @ManyToOne(
        targetEntity = User.class,
        optional = false,
        fetch = FetchType.EAGER
    )
    @JoinColumn(name="user_id")
    private User user;

}
