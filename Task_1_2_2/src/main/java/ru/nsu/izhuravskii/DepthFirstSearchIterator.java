package ru.nsu.izhuravskii;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Stack;


/**
 * DFS Iterator realization for iterating my tree.
 * @param <T> - generic type of nodes' values.
 */
public class DepthFirstSearchIterator<T> implements Iterator<T> {

    private final Stack<Tree<T>> stack = new Stack<>();
    private final int modificationCounter;
    public DepthFirstSearchIterator(Tree<T> vertex) {
        stack.add(vertex);
        modificationCounter = vertex.getModificationCounter();
    }

    @Override
    public boolean hasNext() {
        return !(stack.isEmpty());
    }

    @Override
    public T next() {
        Tree<T> currentVertex = stack.pop();
        if (modificationCounter != currentVertex.getModificationCounter()) {
            throw new ConcurrentModificationException("DON'T ADD CHANGES IN COLLECTION WHILE ITERATOR IS WORKING!");
        }
        stack.addAll(currentVertex.getChildren());
        return currentVertex.getValue();
    }
}
