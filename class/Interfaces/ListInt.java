package Interfaces;

import java.util.ArrayList;

public interface ListInt<T> {
    public ArrayList<T> getList();

    public void setList(ArrayList<T> list);

    public void add(T item);

    public void remove(T item);

    public String toString();

    // search method by id
    public T findByID(int id);

    // get item by index
    public T getInstance(int i);
}
