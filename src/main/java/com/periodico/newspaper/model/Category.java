package com.periodico.newspaper.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

  @Id
  //@GeneratedValue(strategy = GenerationType.AUTO)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID uuid;


  //private int id;
  private String category;

  public Category() {
  }

  /*public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }*/

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  /*@OneToMany(
    mappedBy = "category", 
    cascade = CascadeType.ALL, 
    fetch = FetchType.EAGER
    )
  private Set<Category> categories = new HashSet<>();*/

  @OneToMany(
    mappedBy = "category", 
    cascade = CascadeType.ALL, 
    fetch = FetchType.EAGER
)
private Set<Article> articles = new HashSet<>();

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Category category = (Category) o;
    return uuid.equals(category.uuid);
}

@Override
public int hashCode() {
    return uuid.hashCode();
}

}
