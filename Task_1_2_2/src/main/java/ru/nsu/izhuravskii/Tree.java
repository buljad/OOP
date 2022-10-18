package ru.nsu.izhuravskii;

import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;


public class Tree<T> {

    private T value;
    private Tree<T> parent;
    private List<Tree<T>> children;

    public void treeInit (T val) {
        this.value = val;
        this.parent = null;
        this.children = new ArrayList<>();
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

    public Tree <T> getParent(Tree <T> p) {
        return p.parent;
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
        return Objects.hash(value, children);
    }
}


