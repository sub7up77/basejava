package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private static final int STORAGE_LIMIT = 10000;
    private static final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size;

    protected int size() {
        return size;
    }

    protected Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("ERROR: resume " + uuid + " not found!");
            return null;
        }
    }

    protected Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected void save(Resume resume) {
        int index = getIndex(resume.uuid);
        if (index >= 0) {
            System.out.println("ERROR: resume " + resume.uuid + " already exists!");
        } else if (size == storage.length) {
            System.out.println("ERROR: resumes storage limit of " + storage.length + " reached");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    protected void update(Resume resume) {
        int index = getIndex(resume.uuid);
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR: resume " + resume.uuid + " not found!");
        }
    }

    protected void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: resume " + uuid + " not found!");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    protected void clear() {
        Arrays.fill(storage, 0, size - 1, null);
        size = 0;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}