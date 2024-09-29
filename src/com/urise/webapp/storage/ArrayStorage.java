package com.urise.webapp.storage;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private final Resume[] storage = new Resume[10000];
    private int size;

    protected int size() {
        return size;
    }

    protected Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) return storage[i];
        }
        System.out.println("ERROR: resume " + uuid + " not found!");
        return null;
    }

    protected Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected void save(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume.uuid.equals(storage[i].uuid)) {
                System.out.println("ERROR: resume " + resume.uuid + " already exists!");
                return;
            }
        }
        if (size < storage.length) {
            storage[size] = resume;
            size++;
        } else {
            System.out.println("ERROR: resumes storage limit of " + storage.length + " reached");
        }
    }

    protected void update(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume.uuid.equals(storage[i].uuid)) {
                storage[i].uuid = resume.uuid;
                return;
            }
        }
        System.out.println("ERROR: resume " + resume.uuid + " not found!");
    }

    protected void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("ERROR: resume " + uuid + " not found!");
    }

    protected void clear() {
        Arrays.fill(storage, 0, size - 1, null);
        size = 0;
    }
}