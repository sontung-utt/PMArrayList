package manager;

import java.util.ArrayList;

public interface IManager<E> {
    void add(E e);
    void remove(int id);
    int findIndexById(int id);
    void update(int id, E e);
    ArrayList<E> getAll();
    ArrayList<Integer> getAllProductIds();
}
