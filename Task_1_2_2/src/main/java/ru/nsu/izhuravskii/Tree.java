package ru.nsu.izhuravskii;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;


public class Tree<T> implements Iterable <T> {

    private T value;
    private Tree<T> parent;
    private List<Tree<T>> children;
    private int modificationCounter;
    boolean search;

    public void treeInit (T val) {
        this.value = val;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public Tree <T> getParent() {
        return this.parent;
    }
    public List<Tree <T>> getChildren () {
        return this.children;
    }

    public T getValue() {
        return this.value;
    }

    public void addChild (@NotNull Tree<T> child, T val) {
        child.parent = this;
        child.value = val;
        children.add(child);
    }

    public void removeChild (@NotNull Tree<T> child) {
        if (child.children != null) {
            child.parent.children.addAll(child.children);
            for (Tree <T> t : child.children) {
                child.children.remove(t);
            }
        }
        child.parent.children.remove(child);
    }

    public void removeChildren(@NotNull Tree<T> member) {
        for (Tree<T> t : member.children) {
            member.children.remove(t);
        }
    }

    public void showChildren(@NotNull Tree <T> member) {
        for (Tree <T> t : member.children) {
            System.out.print(t);
        }
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
        if (search)
            return new DepthFirstSearchIterator<>(this);
        else
            return new BreadthFirstSearchIterator<>(this);
    }
}
