import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        if (size < storage.length) {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        if (size != 0) {
            for (int index = 0; index < size; index++) {
                if (storage[index].uuid.equals(uuid)) return storage[index];
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (size != 0) {
            for (int index = 0; index < size; index++) {
                if (storage[index].uuid.equals(uuid)) {
                    if (index == size - 1) {
                        storage[index] = null;
                    } else {
                        System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
                        storage[size - 1] = null;
                    }
                    size--;
                    return;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
