package ru.nsu.izhuravskii;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

        Tree<Integer> vertex1 = new Tree<>();
        vertex1.setValue(1);

        t1.addChild(vertex1, 2);

        Assertions.assertEquals(t1,t2);
    }

}
