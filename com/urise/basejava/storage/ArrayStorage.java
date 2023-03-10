/**
 * Array based storage for Resumes
 */

package com.urise.basejava.storage;

import com.urise.basejava.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    protected int getIndex(String uuid) {
        for (int index = 0; index < size; index++) {
            if (storage[index].getUuid().equals(uuid)) {
                return index;
            }
        }
        return -1;
    }

    protected void insertElement(Resume r) {
        storage[size] = r;
    }

    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
    }
}