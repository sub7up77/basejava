/**
 * Array based storage for Resumes
 */

package com.urise.basejava.storage;

import com.urise.basejava.model.Resume;

public interface Storage {

    void clear();

    void save(Resume resume);

    void update(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    int size();
}
