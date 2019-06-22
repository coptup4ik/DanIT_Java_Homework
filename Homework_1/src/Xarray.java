import java.util.Arrays;

public class Xarray {
    private int[] storage;
    private int index;

    public Xarray() {
        index = 0;
        storage = new int[1];
    }

    private void resizeArray() {
        int newLength = storage.length + 1;
        int[] newStorage = new int[newLength];
        System.arraycopy(storage, 0, newStorage, 0, storage.length);
        storage = newStorage;
    }

    public void push(int element) {
        if (index == storage.length) {
            resizeArray();
        }
        storage[index++] = element;
    }

    int[] get() {
        return storage;
    }
}
