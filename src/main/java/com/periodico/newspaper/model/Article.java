package com.periodico.newspaper.model;

import java.time.LocalDateTime;
import java.util.UUID;

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
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String title;
    private String content;
    // private String date;
    @CreationTimestamp
    private LocalDateTime created_on;

    public Article() {
    }

    /*
     * public int getId() {
     * return this.id;
     * }
     * 
     * public void setId(int id) {
     * this.id = id;
     * }
     */
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

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Category getCategory() {
//        return this.category;
//    }

//    public void setCategory(Category category) {
//        this.category = category;
//    }

    @ManyToOne /* (targetEntity = User.class, optional = false, fetch = FetchType.EAGER) */
    @JoinColumn(name = "user_uuid")
    private User user;

   /* @ManyToOne /* (targetEntity = Category.class, optional = false, fetch = FetchType.EAGER) */
   /*  @JoinColumn(name = "category_uuid")
    private Category category;  */

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Article article = (Article) o;
        return uuid.equals(article.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();

    }
}
