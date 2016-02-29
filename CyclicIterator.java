import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class CyclicIterator {
    Iterator<Integer>[] iterators;
    int pos;
    @SuppressWarnings("unchecked")
    public CyclicIterator(List... lists) {
        if (lists.length > 0 ) {
            iterators = new Iterator[lists.length];
            for (int i = 0; i < lists.length; i++) {
                iterators[i] = lists[i].iterator();
            }
        }
        pos = 0;
    }

    public int next() {
        int next = iterators[pos].next();
        pos = (pos == iterators.length - 1) ? 0 : pos + 1;
        return next;
    }
    public boolean hasNext() {
        if (iterators[pos].hasNext()) return true;

        // pos + 1 -> length
        for (int i = pos + 1; i < iterators.length; i++) {
            if (iterators[i].hasNext()) {
                pos = i;
                return true;
            }
        }
        // 0 -> pos
        for (int i = 0; i < pos; i++) {
            if (iterators[i].hasNext()) {
                pos = i;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        List<Integer> list3 = new ArrayList<>();
        list3.add(8);
        list3.add(9);
        CyclicIterator cyclicIterator = new CyclicIterator(list1, list2, list3);
        while (cyclicIterator.hasNext()) {
            System.out.println(cyclicIterator.next());
        }
    }
}
