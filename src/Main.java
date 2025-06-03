public class Main {
    public static void main(String[] args){

        // trying out binary search tree

        BinarySearchTree bst = new BinarySearchTree(5);

        bst.insert(3);
        bst.insert(17);
        bst.insert(4);
        bst.insert(12);

        bst.delete(5);

        System.out.println(bst.search(5));
        System.out.println(bst.search(12));

        System.out.println("Height: " +  bst.height());

        bst.printInorderTraversal();

    }
}
