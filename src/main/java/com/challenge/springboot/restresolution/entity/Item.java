package com.challenge.springboot.restresolution.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
@ApiModel(description = "Item Model")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @ApiModelProperty(notes = "Id of the Item", name = "id", required = true, value = "1")
  private int id;

  @Column(name = "name")
  @ApiModelProperty(notes = "Name of the Item", name = "name", required = true, value = "Notebook")
  private String name;

  @Column(name = "description")
  @ApiModelProperty(notes = "Description of the Item", name = "description", value = "Lenovo")
  private String description;

  @Column(name = "owner_id_fk")
  @ApiModelProperty(notes = "Reference to the owner of the Item", name = "ownerIdFk", required = true, value = "7")
  private long ownerIdFk;

  @Column(name = "creation_date")
  @ApiModelProperty(notes = "Creation date of the Item", name = "creationDate", required = true, value = "DEFAULT")
  private java.sql.Timestamp creationDate;

  @Column(name = "modification_date")
  @ApiModelProperty(notes = "Modification date of the Item", name = "modificationDate", required = true, value = "DEFAULT")
  private java.sql.Timestamp modificationDate;

  @Column(name = "state")
  @ApiModelProperty(notes = "Represents the state of the Item", name = "state", required = true, value = "Published")
  private String state;

  @Column(name = "price")
  @ApiModelProperty(notes = "Price of the Item", name = "price", required = true, value = "123.45")
  private double price;

  @Column(name = "currency")
  @ApiModelProperty(notes = "Currency of the Item", name = "currency", required = true, value = "ARS")
  private String currency;

  @Column(name = "active")
  @ApiModelProperty(notes = "Represents if the Item is active", name = "active", required = true, value = "true")
  private Boolean active;


  public Item() {}

  public Item(String name, String description, long ownerIdFk, Timestamp creationDate,
              Timestamp modificationDate, String state, double price,
              String currency, Boolean active) {
    this.name = name;
    this.description = description;
    this.ownerIdFk = ownerIdFk;
    this.creationDate = creationDate;
    this.modificationDate = modificationDate;
    this.state = state;
    this.price = price;
    this.currency = currency;
    this.active = active;
  }

  public long getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public long getOwnerIdFk() {
    return ownerIdFk;
  }

  public void setOwnerIdFk(long ownerIdFk) {
    this.ownerIdFk = ownerIdFk;
  }


  public java.sql.Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(java.sql.Timestamp creationDate) {
    this.creationDate = creationDate;
  }


  public java.sql.Timestamp getModificationDate() {
    return modificationDate;
  }

  public void setModificationDate(java.sql.Timestamp modificationDate) {
    this.modificationDate = modificationDate;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }


  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", ownerIdFk=" + ownerIdFk +
        ", creationDate=" + creationDate +
        ", modificationDate=" + modificationDate +
        ", state='" + state + '\'' +
        ", price=" + price +
        ", currency='" + currency + '\'' +
        ", active=" + active +
        '}';
  }
}
