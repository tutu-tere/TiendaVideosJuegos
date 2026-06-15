package com.canderosi.tienda.interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface ManejoDeFechas {
  static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  default LocalDate formatoFecha(String fecha) {
    LocalDate fechaformateada = LocalDate.parse(fecha, formato);
    return fechaformateada;

  }
}
