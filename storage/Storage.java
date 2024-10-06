package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public interface Storage {

    int getSize();

    Resume get(String uuid);

    Resume[] getAll();

    void save(Resume r);

    void update(Resume r);

    void delete(String uuid);

    void clear();
}