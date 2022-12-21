package ru.nsu.izhuravskii;

import java.util.Iterator;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;


public class Tree<T> implements Iterable <T> {
    private T value;
    private Tree<T> parent;
    private List<Tree<T>> children;
    private int modificationCounter;
    private boolean search;

    public void treeInit (T val) {
        this.value = val;
        this.parent = null;
        this.children = new ArrayList<>();
    }
    public void setParent(Tree<T> parent) { this.parent = parent; };
    public Tree <T> getParent() { return this.parent; }
    public void setValue(T val) { this.value = val; }
    public T getValue() { return this.value; }
    public List<Tree <T>> getChildren () { return this.children; }
    public void setSearch(boolean type) { this.search = type; }
    public boolean getSearch() { return this.search; }

    public Tree<T> addChild (T val) {
        Tree <T> child = new Tree<>();
        child.setValue(val);
        child.setParent(this);
        child.children = new ArrayList<>();
        this.children.add(child);
        return child;
    }

    public int getModificationCounter() {
        return modificationCounter;
    }

    public Tree<T> addChild (Tree<T> parentVertex, T val) {
        Tree <T> child = new Tree<>();
        child.value = val;
        child.parent = parentVertex;
        child.children = new ArrayList<>();
        parentVertex.children.add(child);
        return child;
    }

    public void removeChild (int index) {
        for (Tree<T> i : children.get(index).getChildren()) {
            i.setParent(parent);
            this.addChild(i.value);
        }
        children.remove(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tree<?> obj = (Tree<?>) o;
        return Objects.equals(value, obj.value)
                && Objects.equals(children, obj.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, parent, children);
    }

    public Iterator<T> iterator() {
        if (this.search)
            return new DepthFirstSearchIterator<>(this);
        else
            return new BreadthFirstSearchIterator<>(this);
    }
}
