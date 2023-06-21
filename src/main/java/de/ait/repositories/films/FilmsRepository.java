package de.ait.repositories.films;

import de.ait.models.Film;
import de.ait.repositories.CrudRepository;

import java.util.List;

public interface FilmsRepository extends CrudRepository<Film> {
    @Override
    List<Film> findAll();

    @Override
    void save(Film model);

    @Override
    Film findById(String id);
}