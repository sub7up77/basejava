import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        while (i < size()) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        int i = size();
        if (i < storage.length) storage[i] = r;
    }

    Resume get(String uuid) {
        int i = 0;
        while (i < size()) {
            if (uuid.equals(storage[i].uuid)) return storage[i];
            i++;
        }
        return null;
    }

    void delete(String uuid) {
        int i = 0;
        while (i < size()) {
            if (uuid.equals(storage[i].uuid)) {
                while (i < size() - 1) {
                    storage[i] = storage[i + 1];
                    i++;
                }
                storage[size() - 1] = null;
                return;
            }
            i++;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int i = 0;
        while (i < storage.length - 1 & storage[i] != null) {
            i++;
        }
        return i;
    }
}
