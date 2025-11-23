import java.util.*;

public class LeakyBucket<T> {

    private final int capacity;
    private final Deque<T> queue;

    public LeakyBucket(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayDeque<>();
    }
    public void enqueue(T item) {
        if (queue.size() == capacity) {
            queue.pollFirst();
        }
        queue.offerLast(item);
    }
    public List<T> process(int k) {
        List<T> result = new ArrayList<>();

        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            result.add(queue.pollFirst());
        }

        return result;
    }
}
