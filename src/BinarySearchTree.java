import com.sun.source.tree.Tree;

class TreeNode{
    int item;
    TreeNode left, right;

    TreeNode(int item){
        this.item = item;
        this.left = this.right = null;
    }
    TreeNode(int item, TreeNode left, TreeNode right){
        this.item = item;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    private TreeNode root;

    BinarySearchTree(int item){
        this.root = new TreeNode(item);
    }

    BinarySearchTree(){    }

    public void insert(int item){
        if (root == null){
            this.root = new TreeNode(item);
            return;
        }

        TreeNode traversal = root;

        while(true){
            if (traversal.item == item){
                return;
            }
            if (traversal.item > item){
                if (traversal.left == null){
                    traversal.left = new TreeNode(item);
                    return;
                }
                traversal = traversal.left;
            }
            if (traversal.item < item){
                if (traversal.right == null){
                    traversal.right = new TreeNode(item);
                    return;
                }
                traversal = traversal.right;
            }
        }

    }


    public void printInorderTraversal(){

        inorderHelper(this.root);

    }

    private void inorderHelper(TreeNode root){

        if (root == null){
            return;
        }

        inorderHelper(root.left);

        System.out.println(root.item);

        inorderHelper(root.right);
    }

    public boolean search (int item){

        return searchHelper(item, root);

    }

    private boolean searchHelper (int item, TreeNode root){

        if (root == null) return false;

        if (root.item < item) return searchHelper(item, root.right);

        if (root.item > item) return searchHelper(item, root.left);

        return true;

    }

    public void delete(int item){

        root = deleteHelper(item, root);

    }

    private TreeNode deleteHelper(int item, TreeNode root){

        if (root == null){
            return null;
        }

        if (root.item < item){

            root.right = deleteHelper(item, root.right);

        }

        else if (root.item > item){
            root.left = deleteHelper(item, root.left);

        }

        else {

            if (root.left == null && root.right == null){
                return null;
            }

            else if (root.left == null){
                return root.right;
            }

            else if (root.right == null){
                return root.left;
            }

            else {
                TreeNode next = root.right;

                while(next.left != null){
                    next = next.left;
                }

                root.item = next.item;
                root.right = deleteHelper(next.item, root.right);

            }
        }

        return root;

    }

    public int height(){

        return heightHelper(root);

    }

    private int heightHelper(TreeNode root){

        int right = 0;
        int left = 0;

        if (root == null) return -1;

        return 1 + Math.max(heightHelper(root.right), heightHelper(root.left));

    }

}
