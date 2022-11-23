package ru.nsu.izhuravskii;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Iterator;

public class BreadthFirstSearchIterator<T> implements Iterator<T> {

    private final Queue<Tree<T>> queue = new ArrayDeque<>();

    public BreadthFirstSearchIterator(Tree<T> vertex) {
        queue.add(vertex);
    }

    @Override
    public boolean hasNext() {
        return !(this.queue.isEmpty());
    }

    @Override
    public T next() {
        Tree<T> currentVertex = queue.remove();
        queue.addAll(currentVertex.getChildren());
        return currentVertex.getValue();
    }
}
