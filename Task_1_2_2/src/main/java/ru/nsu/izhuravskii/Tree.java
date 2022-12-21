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
    private boolean search;

    public void treeInit (T val) {
        this.value = val;
        this.parent = null;
        this.children = new ArrayList<>();
    }
    public void setParent(Tree<T> parent) { this.parent = parent; };
    public Tree <T> getParent() {
        return this.parent;
    }
    public void setValue(T val) { this.value = val; }
    public T getValue() {
        return this.value;
    }
    public List<Tree <T>> getChildren () {
        return this.children;
    }
    public void setSearch(boolean type) {
        this.search = type;
    }
    public boolean getSearch() {
        return this.search;
    }

    public Tree<T> addChild (T val) {
        Tree <T> child = new Tree<>();
        child.value = val;
        child.parent = this;
        child.children = new ArrayList<>();
        this.children.add(child);
        return child;
    }

    public Tree<T> addChild (Tree<T> parentVertex, T val) {
        Tree <T> child = new Tree<>();
        child.value = val;
        child.parent = parentVertex;
        child.children = new ArrayList<>();
        parentVertex.children.add(child);
        return child;
    }

    public void removeChild (@NotNull Tree<T> vertex) {
        if (vertex.parent != null) {
            for (Tree<T> i : vertex.children) {
                i.setParent(vertex.parent);
                vertex.parent.addChild(i.value);
            }
            vertex.children = null;
            vertex.parent = null;
            vertex.value = null;
        }
    }

    public void removeChild (T val) {
        if (this.parent != null) {
            for (Tree<T> i : this.children) {
                i.setParent(this.parent);
                this.parent.addChild(i.value);
            }
            this.children = null;
            this.parent = null;
            this.value = null;
        }
    }


    public void removeChildren(@NotNull Tree<T> member) {
        for (Tree<T> t : member.children) {
            t.removeChild(t);
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
        if (this.search)
            return new DepthFirstSearchIterator<>(this);
        else
            return new BreadthFirstSearchIterator<>(this);
    }
}
