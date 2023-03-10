package com.urise.basejava.storage;

import com.urise.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
    protected void insertElement(Resume r) {
        int index = getInsIndex(r);
        if (index < size) {
            System.arraycopy(storage, index, storage, index + 1, size - index);
        }
        storage[index] = r;
    }

    protected void fillDeletedElement(int index) {
        if (index < size - 1) {
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
        }
    }

    private int getInsIndex(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().compareTo(r.getUuid()) > 0) {
                return i;
            }
        }
        return size;
    }
}