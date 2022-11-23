package ru.nsu.izhuravskii;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstSearchIterator<T> implements Iterator<T> {

    private final Stack<Tree<T>> stack = new Stack<>();
    public DepthFirstSearchIterator(Tree<T> vertex) {
        stack.add(vertex);
    }

    @Override
    public boolean hasNext() {
        return stack.isEmpty();
    }

    @Override
    public T next() {
        Tree<T> currentVertex = stack.pop();
        stack.addAll(currentVertex.getChildren());
        return currentVertex.getValue();
    }
}
