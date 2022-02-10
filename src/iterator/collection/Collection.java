package iterator.collection;

public interface Collection<T> {
    public void add(T t);
    public int size();
    Iterator iterator();
}
