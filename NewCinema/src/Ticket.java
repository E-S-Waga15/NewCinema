import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ticket implements Serializable, List<Ticket> {

    private static final long serialVersionUID = 4404087943572037389L;

    int id;

    String name;

    String movieName;

    String date;

    String Stage;

    int counter = 0;

    public String getId(){
        return Integer.toString(id);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Ticket> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Ticket ticket) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Ticket> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Ticket> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Ticket get(int index) {
        return null;
    }

    @Override
    public Ticket set(int index, Ticket element) {
        return null;
    }

    @Override
    public void add(int index, Ticket element) {

    }

    @Override
    public Ticket remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Ticket> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Ticket> listIterator(int index) {
        return null;
    }

    @Override
    public List<Ticket> subList(int fromIndex, int toIndex) {
        return null;
    }
}
