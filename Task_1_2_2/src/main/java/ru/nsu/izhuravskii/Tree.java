package ru.nsu.izhuravskii;

import java.util.Iterator;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of Tree on java language.
 * @param <T> - generic type of nodes int Tree.
 */
public class Tree<T> implements Iterable <T> {
    private T value;
    private Tree<T> parent;
    private List<Tree<T>> children;
    private int modificationCounter;
    private boolean search;

    /**
     * Method for the Tree initializing.
     * @param val - value of the Tree's root
     */
    public void treeInit (T val) {
        this.value = val;
        this.parent = null;
        this.children = new ArrayList<>();
        this.modificationCounter = 0;
    }

    /**
     * Method for setting or changing a parent of node.
     * @param parent - new parent's node.
     */
    public void setParent(Tree<T> parent) { this.parent = parent; }

    /**
     * Method for getting vertex's parent node.
     * @return - returns node of the vertex's parent.
     */
    public Tree <T> getParent() { return this.parent; }

    /**
     * Sets a new value for the node.
     * @param val - new value.
     */
    public void setValue(T val) { this.value = val; }

    /**
     * Gets a value of the node.
     * @return - returns value of the node.
     */
    public T getValue() { return this.value; }

    /**
     * Method for getting a list of node's children.
     * @return - returns list of children.
     */
    public List<Tree <T>> getChildren () { return this.children; }

    /**
     * Setting a type of search for Iterator(true - BFS, false - DFS)
     * @param type - return only true or false because we have only 2 variants of search.
     */
    public void setSearch(boolean type) { this.search = type; }

    /**
     * Getting a type of search for the tree.
     * @return - returns boolean value for choosing a type of search.
     */
    public boolean getSearch() { return this.search; }

    /**
     * Choosing a type of search for iterator (default it is BFS).
     * @return - returns type of search for Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        if (this.getRoot().getSearch()) {
            return new BreadthFirstSearchIterator<>(this);
        }
        return new DepthFirstSearchIterator<>(this);
    }

    /**
     * Method for getting a modification counter for controlling changes in tree.
     * @return - returns quantity of actions with tree.
     */
    public int getModificationCounter() {
        Tree<T> root = getRoot();
        return root.modificationCounter;
    }

    /**
     * Gets root of the tree.
     * @return - returns the root.
     */
    public Tree<T> getRoot() {
        Tree<T> step = this;
        while (step.getParent() != null) {
            step = step.getParent();
        }
        return step;
    }


    /**
     * Method for adding a new node to the tree.
     * @param val - value of the new node.
     * @return - returns new node.
     */
    public Tree<T> addChild (T val) {
        Tree <T> child = new Tree<>();
        child.setValue(val);
        child.setParent(this);
        child.children = new ArrayList<>();
        this.children.add(child);
        this.modificationCounter ++;
        this.getRoot().modificationCounter ++;
        return child;
    }

    /**
     * Same as previous, but with this method we can add a new child-node to some exact parent.
     * @param parentVertex - parent of the new node.
     * @param val - value of the child-node.
     * @return - returns new child-node.
     */
    public Tree<T> addChild (Tree<T> parentVertex, T val) {
        Tree <T> child = new Tree<>();
        child.setValue(val);
        child.setParent(parentVertex);
        child.children = new ArrayList<>();
        parentVertex.children.add(child);
        parentVertex.getRoot().modificationCounter ++;
        return child;
    }

    /**
     * Method for removing a node from the tree.
     * @param index - index in the list of children of this parent vertex.
     */
    public void removeChild (int index) {
        for (Tree<T> i : children.get(index).getChildren()) {
            i.setParent(parent);
            this.addChild(i.value);
        }
        children.remove(index);
        this.getRoot().modificationCounter ++;
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
}
