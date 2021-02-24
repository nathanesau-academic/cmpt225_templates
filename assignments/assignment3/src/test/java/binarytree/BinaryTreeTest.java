package binarytree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class BinaryTreeTest {
    
    BinaryTree<Integer> createTree() {
        // creating the tree
        //       5
		//      / \
		//     2   6
		//    / \   \
		//   1   4   8
        BTNode<Integer> node8 = new BTNode<Integer>(8);
        BTNode<Integer> node6 = new BTNode<Integer>(6, null, node8, null);
		BTNode<Integer> node1 = new BTNode<Integer>(1);
		BTNode<Integer> node4 = new BTNode<Integer>(4);
		BTNode<Integer> node2 = new BTNode<Integer>(2, node1, node4, null);
		BTNode<Integer> node5 = new BTNode<Integer>(5, node2, node6, null);
		return new BinaryTree<Integer>(node5);
    }

    @Test
    public void testMirrorInverse() {
        BinaryTree<Integer> tree = createTree();
        tree.mirrorInverse();
        assert(tree != null && tree.getRoot().getData() == 5);
        assert(tree.getRoot().getLeftChild() != null && tree.getRoot().getLeftChild().getData() == 6);
        assert(tree.getRoot().getLeftChild().getLeftChild() != null
            && tree.getRoot().getLeftChild().getLeftChild().getData() == 8);
    }

    @Test
    public void testTreeFromTraversal1() {
        // creating the tree
        //       3
	//      / \
	//     2   5
	//    /   / \
	//   1   4   6   
        List<Integer> preorder = Arrays.asList(3,2,1,5,4,6);
        List<Integer> inorder = Arrays.asList(1,2,3,4,5,6);
        BinaryTree<Integer> tree = BinaryTree.createFromPreorderInorder(preorder, inorder);

        assert(tree != null);
        assert(tree.getRoot() != null && tree.getRoot().getData() == 3);
        assert(tree.getRoot().getLeftChild() != null && tree.getRoot().getLeftChild().getData() == 2);
        assert(tree.getRoot().getLeftChild().getRightChild() == null);
    }

    @Test
    public void testInOrderIterator1() {
        BinaryTree<Integer> tree = createTree();
        Iterator<Integer> inOrderIt = tree.inOrderIterator();
        List<Integer> vals = Arrays.asList(new Integer[] {1, 2, 4, 5, 6, 8});

        for (Iterator<Integer> it = vals.iterator(); it.hasNext(); ) {
            int expected = (int) it.next();
            assert(inOrderIt.hasNext() && inOrderIt.next() == expected);
        }

        assert(!inOrderIt.hasNext());
    }

    @Test
    public void testInOrderIterator2() {
        BinaryTree<Integer> tree = createTree();
        Iterator<Integer> inOrderIt = tree.inOrderIterator();

        // initial values
        List<Integer> vals = Arrays.asList(new Integer[] {1, 2});

        for (Iterator<Integer> it = vals.iterator(); it.hasNext(); ) {
            int expected = (int) it.next();
            assert(inOrderIt.hasNext() && inOrderIt.next() == expected);
        }

        // modify tree
        tree.getRoot().getRightChild().getRightChild().setData(9);

        // final values
        vals = Arrays.asList(new Integer[] {4, 5, 6, 9});

        for (Iterator<Integer> it = vals.iterator(); it.hasNext(); ) {
            int expected = (int) it.next();
            assert(inOrderIt.hasNext() && inOrderIt.next() == expected);
        }

        assert (!inOrderIt.hasNext());
    }

}
