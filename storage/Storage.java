package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public interface Storage {

    int size();

    void save(Resume r);

    void update(Resume r);

    Resume get(String uuid);

    Resume[] getAll();

    void delete(String uuid);

    void clear();
}