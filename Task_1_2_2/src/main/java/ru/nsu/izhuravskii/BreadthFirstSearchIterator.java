package ru.nsu.izhuravskii;

import java.util.ArrayDeque;
import java.util.ConcurrentModificationException;
import java.util.Queue;
import java.util.Iterator;

public class BreadthFirstSearchIterator<T> implements Iterator<T> {

    Queue<Tree<T>> queue = new ArrayDeque<>();
    private final int modificationCounter;

    public BreadthFirstSearchIterator(Tree<T> vertex) {
        queue.add(vertex);
        modificationCounter = vertex.getModificationCounter();
    }

    @Override
    public boolean hasNext() {
        return !(this.queue.isEmpty());
    }

    @Override
    public T next() {
        Tree<T> currentVertex = queue.remove();
        if (modificationCounter != currentVertex.getModificationCounter()) {
            throw new ConcurrentModificationException("DON'T ADD CHANGES IN COLLECTION WHILE ITERATOR IS WORKING!");
        }
        queue.addAll(currentVertex.getChildren());
        return currentVertex.getValue();
    }
}
