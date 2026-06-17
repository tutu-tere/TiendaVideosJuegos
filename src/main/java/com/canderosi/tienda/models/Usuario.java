package com.canderosi.tienda.models;

public class Usuario {
  private Long id;
  private String nombre;
  private String apellido;
  private String email;
  private String password;
  private Double coins;

  public Usuario(Long id, String nombre, String apellido, String email, String password) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.password = password;
    this.coins = 200.0;
  }

  public Long getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Double getCoins() {
    return coins;
  }

  public void setCoins(Double coins) {
    this.coins = coins;
  }

  @Override
  public String toString() {
    return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", password="
        + password + ", coins=" + coins + "]";
  }

}
