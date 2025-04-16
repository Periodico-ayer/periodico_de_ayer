package com.periodico.newspaper.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

  @Id

@SequenceGenerator(
  name = "category_id_sequence",
  sequenceName = "category_id_sequence",
  allocationSize = 1,
  initialValue = 1
)
@GeneratedValue(
  strategy = GenerationType.SEQUENCE,
  generator = "category_id"
)

  private Integer id;
  private String category;

  public Category() {
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }



  @OneToMany(
    mappedBy = "category", 
    cascade = CascadeType.ALL,
    orphanRemoval = true
    )
   private List<Article> articles;

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Category category = (Category) o;
      return id.equals(category.id);
  }



}
