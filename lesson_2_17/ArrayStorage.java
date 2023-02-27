/**
 * Array based storage for Resumes
 */

package com.basejava.lesson_2_17;

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    int findIndex(String uuid) {
        for (int index = 0; index < size; index++) {
            if (storage[index].uuid.equals(uuid)) {
                return index;
            }
        }
        return -1;
    }

    void save(Resume resume) {
        if (findIndex(resume.uuid) != -1) {
            System.out.println("Resume " + resume.uuid + " already exist");
        } else {
            if (size < storage.length) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("The storage is full");
            }
        }
    }

    void update(Resume resume) {
        int index = findIndex(resume.uuid);
        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("Resume " + resume.uuid + " not found");
        }
    }

    Resume get(String uuid) {
        if (findIndex(uuid) != -1) {
            Resume r = new Resume();
            r.uuid = uuid;
            return r;
        } else {
            System.out.println("Resume " + uuid + " not found");
            return null;
        }
    }

    void delete(String uuid) {
        int index = findIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume " + uuid + " not found");
        }
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
