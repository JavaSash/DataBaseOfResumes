import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[count] = r;
        count++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equalsIgnoreCase(uuid)) {
                return storage[i];
            } else {
                System.out.println("Нет такого uuid");
                break;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid == uuid) {
                shiftAfterDelete(storage, i, size());
            }
        }
    }

    void shiftAfterDelete(Resume[] r, int from, int to) {
        for (int i = from; i < to; i++) {
            storage[i] = storage[i + 1];
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                size++;
            } else {
                break;
            }
        }
        return size;
    }
}
