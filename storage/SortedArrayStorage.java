package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    protected void insertItem(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            index = -index - 1;
        }
        if (size == 0) {
            storage[0] = resume;
        } else {
            for (int i = size; i > index; i--) {
                storage[i] = storage[i - 1];
            }
            storage[index] = resume;
        }
    }

    protected void removeItem(int index) {
        for (int i = index; i < size; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size] = null;
    }
}