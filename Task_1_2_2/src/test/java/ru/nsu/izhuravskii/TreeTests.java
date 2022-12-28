package ru.nsu.izhuravskii;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeTests {

    @Test
    public void simpleAddChildTest() {
        Tree<Integer> t1 = new Tree<>();
        t1.treeInit(1);

        Tree<Integer> t2 = new Tree<>();
        t2.treeInit(1);

        t1.addChild(2);
        t1.addChild(3);

        t2.addChild(2);
        t2.addChild(3);

        Assertions.assertEquals(t1,t2);
    }

    @Test
    public void parentAddChildTest() {
        Tree<Integer> t1 = new Tree<>();
        t1.treeInit(1);

        Tree<Integer> t2 = new Tree<>();
        t2.treeInit(1);

        Tree<Integer> t1Vertex1 = t1.addChild(1);
        Tree<Integer> t1Vertex2 = t1.addChild(t1Vertex1, 2);
        t1Vertex2.addChild(3);

        Tree<Integer> t2Vertex1 = t2.addChild(1);
        Tree<Integer> t2Vertex2 = t2.addChild(t2Vertex1, 2);
        t2Vertex2.addChild(3);

        Assertions.assertEquals(t1,t2);
    }

    @Test
    public void removeChildTest() {
        Tree<Integer> t1 = new Tree<>();
        t1.treeInit(1);
        Tree<Integer> t2 = new Tree<>();
        t2.treeInit(1);

        t1.addChild(100);
        t1.addChild(300);

        t2.addChild(300);

        t1.removeChild(0);

        Assertions.assertEquals(t1,t2);
    }

    @Test
    public void modCounterTest() {
        Tree<Integer> t1 = new Tree<>();
        t1.treeInit(1);
        Tree<Integer> t2 = new Tree<>();
        t2.treeInit(1);

        t1.addChild(2);
        t1.addChild(3);
        t2.addChild(4);
        t2.addChild(7);
        t1.removeChild(0);
        t2.removeChild(1);

        int modCounter1 = t1.getModificationCounter();
        int modCounter2 = t2.getModificationCounter();

        Assertions.assertEquals(modCounter1, modCounter2);
    }

    @Test
    void getParent() {
        Tree<String> t1 = new Tree<>();
        t1.treeInit("Parent");
        Tree<String> childVertex = t1.addChild("Child");

        String realParent = t1.getValue();
        String actualParent = childVertex.getParent().getValue();

        Assertions.assertEquals(realParent, actualParent);
    }

    @Test
    void getChildren() {
        Tree<Integer> root = new Tree<>();
        root.treeInit(0);
        root.addChild(1);
        root.addChild(2);
        root.addChild(3);

        List<Tree<Integer>> actualChildren = root.getChildren();
        List<Integer> children = new ArrayList<>();
        for(Tree<Integer> i : actualChildren) {
            children.add(i.getValue());
        }

        List<Integer> realChildren = Arrays.asList(1, 2, 3);

        Assertions.assertEquals(children, realChildren);
    }

    @Test
    void getRoot() {
        Tree<Double> root = new Tree<>();
        root.treeInit(1.1);
        root.addChild(1.2);
        root.addChild(1.3);
        root.addChild(1.4);

        Tree<Double> actualRoot = root.getRoot();

        Assertions.assertEquals(root, actualRoot);
    }

    @Test
    void getValueTest() {
        Tree<String> root = new Tree<>();
        root.treeInit("Hello world!");
        String expression = "Hello world!";
        String realExpression = root.getValue();

        Assertions.assertEquals(expression, realExpression);
    }

    @Test
    void setValueTest() {
        Tree<String> root = new Tree<>();
        root.treeInit("Hello ");
        Tree<String> child = root.addChild("peace!");
        child.setValue("world!");
        String expression = "Hello world!";
        String realExpression = root.getValue() + child.getValue();

        Assertions.assertEquals(expression, realExpression);
    }

    @Test
    void BFSTreeTest() {
        Tree<Integer> root = new Tree<>();
        root.treeInit(0);
        Tree<Integer> child1 = root.addChild(1);
        Tree<Integer> child2 = root.addChild(2);
        Tree<Integer> child3 = child1.addChild(3);
        child2.addChild(4);
        child3.addChild(5);

        BreadthFirstSearchIterator<Integer> bfs = new BreadthFirstSearchIterator<>(root);
        ArrayList<Integer> actual= new ArrayList<>();

        while (bfs.hasNext()) {
            actual.add(bfs.next());
        }

        List<Integer> real = Arrays.asList(0, 1, 2, 3, 4, 5);

        Assertions.assertEquals(actual, real);
    }
}
