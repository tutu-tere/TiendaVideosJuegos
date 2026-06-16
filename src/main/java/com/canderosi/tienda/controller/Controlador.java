package com.canderosi.tienda.controller;

import java.util.ArrayList;

import com.canderosi.tienda.interfaces.ManejoDeFechas;
import com.canderosi.tienda.models.Videojuego;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class Controlador implements ManejoDeFechas {
  private ArrayList<Videojuego> videojuegos;

  public Controlador() {
    this.videojuegos = new ArrayList<>();

    Videojuego v1 = new Videojuego(1l, "Silent Hill 2",
        "Having received a letter from his deceased wife, James heads to where they shared so many memories, in the hope of seeing her one more time: Silent Hill.",
        "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/2124490/capsule_616x353.jpg?t=1744248682",
        formatoFecha("2024-10-08"), 4.8);
    Videojuego v2 = new Videojuego(2l, "Outlast",
        "Outlast follows the story of investigative journalist Miles Upshur, that got the lead on the inhuman experiments, performed on the asylum patients.",
        "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/238320/header.jpg?t=1666817106",
        formatoFecha("2013-09-03"), 4.5);
    Videojuego v3 = new Videojuego(3l, "Resident Evil",
        "The story follows the survivors of a zombie virus outbreak in the fictional Raccoon City.",
        "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/883710/capsule_616x353.jpg?t=1779433152",
        formatoFecha("2019-01-25"), 4.3);

    this.videojuegos.add(v1);
    this.videojuegos.add(v2);
    this.videojuegos.add(v3);

  }

  // creacion de rutas
  // @RequestMapping(value = "/getAll", method = RequestMethod.GET)
  @GetMapping("/getAll")
  public String inicio() {
    String str = "";
    for (int i = 0; i < this.videojuegos.size(); i++) {
      str += this.videojuegos.get(i).toString() + " \n";
    }
    return str;
  }

  // Parametros de consulta, ejemplo: /search?name=Oustlast aqui se busca un valor
  // por un string clave-valor
  @GetMapping("/search")

  public String getVideojuegoPorNombre(@RequestParam("name") String nombre) {
    String str = this.buscar(nombre, null).toString();
    return str;
  }

  // Variables de ruta, ejemplo: /search/2/rating ->Path variable

  @GetMapping("/search/{id}")
  public String getVideojuegoPorId(@PathVariable("id") Long id) {
    String str = this.buscar(null, id).toString();
    return str;
  }

  private Videojuego buscar(String nombre, Long id) {
    Videojuego v = null;
    for (int i = 0; i < this.videojuegos.size(); i++) {
      if (nombre != null && this.videojuegos.get(i).getNombre().equalsIgnoreCase(nombre)) {
        v = this.videojuegos.get(i);
      } else if (id != null && this.videojuegos.get(i).getId() == id) {
        v = this.videojuegos.get(i);
      }
    }
    return v;
  }

  @GetMapping("/form/add")
  public String formAgregar() {
    return "agregar.jsp";
  }

  @PostMapping("/add")
  public String guardar(@RequestParam String nombre,
      @RequestParam String descripcion,
      @RequestParam String portada,
      @RequestParam String fecha_lanzamiento,
      @RequestParam String rating) { // coincidir el nombre del parametro con el name

    Long nuevoId = this.videojuegos.size() + 1l;
    Videojuego v = new Videojuego(nuevoId,
        nombre,
        descripcion,
        portada,
        formatoFecha(fecha_lanzamiento),
        Double.parseDouble(rating)); // para recibir parametros necesitamos una anotacion
    this.videojuegos.add(v);
    return "redirect:/getAll";
  }

  // devolver el detalle
  @PutMapping("/detail/{id}")
  public String detalle(@PathVariable("id") Long id, Model modelo) {
    Videojuego v = buscar(null, id);
    modelo.addAttribute("videojuego", v);
    return "detalle.jsp";
  }

}
