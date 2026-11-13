package org.example.Repository;

import java.util.List;

public interface Repository<T> {
    void guardar(T objeto);

    T buscarPorId(int id);

    List<T> listar();

    void actualizar(T objeto);

    void eliminar(int id);
}