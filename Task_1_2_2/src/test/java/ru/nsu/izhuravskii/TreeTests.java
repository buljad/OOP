package ru.nsu.izhuravskii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TreeTests {

    @Test
    public void simpleAddChildTest() {
        Tree<Integer> t1 = new Tree<>();
        t1.treeInit(1);

        Tree<Integer> t2 = new Tree<>();
        t2.treeInit(1);

        Tree<Integer> t1vertex1 = t1.addChild(2);
        Tree<Integer> t1vertex2 = t1.addChild(3);

        Tree<Integer> t2vertex1 = t2.addChild(2);
        Tree<Integer> t2vertex2 = t2.addChild(3);

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

        t1.addChild(2);
        t1.addChild(3);

        t2.addChild(3);

        t1.removeChild(2);

        Assertions.assertEquals(t1,t2);
    }
}
