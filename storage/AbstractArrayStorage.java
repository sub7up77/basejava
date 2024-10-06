package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected static final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public int getSize() {
        return size;
    }

    protected abstract int getIndex(String uuid);

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("ERROR: resume " + uuid + " not found!");
            return null;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract void insertItem(Resume resume);

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("ERROR: resume " + resume.getUuid() + " already exists!");
        } else if (size == storage.length) {
            System.out.println("ERROR: resumes storage limit of " + storage.length + " reached");
        } else {
            insertItem(resume);
            size++;
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR: resume " + resume.getUuid() + " not found!");
        }
    }

    protected abstract void removeItem(int index);

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("ERROR: resume " + uuid + " not found!");
        } else {
            removeItem(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public void clear() {
        if (size != 0) {
            Arrays.fill(storage, 0, size - 1, null);
            size = 0;
        }
    }
}