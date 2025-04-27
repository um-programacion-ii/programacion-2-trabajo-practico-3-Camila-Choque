package org.example;

import Class.*;
import Enum.Estado;

public class Main {
    public static void main(String[] args) {

        Libro libro = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");

        // Mostrar los datos del libro
        System.out.println("ISBN: " + libro.getISBN());
        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("Estado: " + libro.getEstado());

        // Cambiar el estado del libro a PRESTADO
        libro.setEstado(Estado.PRESTADO);

        // Mostrar los datos del libro después de cambiar el estado
        System.out.println("\nDespués de cambiar el estado:");
        System.out.println("Estado: " + libro.getEstado());
    }
}
