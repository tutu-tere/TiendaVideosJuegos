package com.canderosi.tienda.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.canderosi.tienda.models.Usuario;

@Controller
public class ControladorUsuarios {
  private ArrayList<Usuario> usuarios;

  public ControladorUsuarios() {
    super();
    this.usuarios = new ArrayList<>();
  }

  @GetMapping("/")
  public String inicio() {
    return "login.jsp";
  }

  @PostMapping("/login")
  public String login(@RequestParam String email, @RequestParam String password) {
    Usuario u = buscar(email);
    if (u != null) {
      return "redirect:/getAll";
    }
    return "redirect:/";
  }

  @PostMapping("/register")
  public String register(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String email,
      @RequestParam String password) {
    Long nuevoId = this.usuarios.size() + 1l;
    Usuario u = new Usuario(nuevoId, nombre, apellido, email, password);
    this.usuarios.add(u);
    return "redirect:/getAll";
  }

  private Usuario buscar(String email) {
    Usuario u = null;
    for (int i = 0; i < this.usuarios.size(); i++) {
      if (this.usuarios.get(i).getEmail().equalsIgnoreCase(email)) {
        u = this.usuarios.get(i);
      }
    }
    return u;
  }

}
