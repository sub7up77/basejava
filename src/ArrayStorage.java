import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, size(), null);
    }

    void save(Resume r) {
        int len = size();
        if (len < storage.length) storage[len] = r;
    }

    Resume get(String uuid) {
        int len = size();
        if (len != 0) {
            for (int index = 0; index < len; index++) {
                if (storage[index].uuid.equals(uuid)) {
                    Resume r = new Resume();
                    r.uuid = storage[index].uuid;
                    return r;
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        int len = size();
        if (len != 0) {
            for (int index = 0; index < len; index++) {
                if (storage[index].uuid.equals(uuid)) {
                    if (index == len - 1) {
                        storage[index] = null;
                    } else {
                        System.arraycopy(storage, index + 1, storage, index, len - 1 - index);
                        storage[len - 1] = null;
                    }
                    return;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int len = 0;
        while (len < storage.length && storage[len] != null) len++;
        return len;
    }
}
