/**
 * Array based storage for Resumes
 */

package com.urise.basejava.storage;

import com.urise.basejava.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume r) {
        if (size >= storage.length) {
            System.out.println("The storage is full");
        } else if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else {
            storage[size++] = r;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not found");
        } else {
            storage[index] = storage[size - 1];
            storage[size-- - 1] = null;
        }
    }

    protected int getIndex(String uuid) {
        for (int index = 0; index < size; index++) {
            if (storage[index].getUuid().equals(uuid)) {
                return index;
            }
        }
        return -1;
    }
}