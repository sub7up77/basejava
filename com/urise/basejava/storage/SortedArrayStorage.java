package com.urise.basejava.storage;

import com.urise.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    public void save(Resume r) {
        if (size >= storage.length) {
            System.out.println("The storage is full");
        } else if (getIndex(r.getUuid()) >= 0) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else {
            int index = getInsIndex(r);
            if (index < size) {
                System.arraycopy(storage, index, storage, index + 1, size - index);
            }
            storage[index] = r;
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not found");
        } else {
            if (index == size - 1) {
                storage[index] = null;
            } else {
                System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
                storage[size - 1] = null;
            }
            size--;
        }
    }

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
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