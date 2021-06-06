import java.util.LinkedList;
import java.util.List;

public class BinTreeTraverse {
    private int arr[]={1,2,3,4,5,6,7};
    private static List<Node> nodeList=null;
    private static class Node{
        Node leftchild;
        Node rightchild;
        int data;
        Node(int newdata){
            leftchild=null;
            rightchild=null;
            data=newdata;
        }

    }
    public void createBintree(){//新建一个二叉树
        nodeList=new LinkedList<Node>();
        for (int nodIndex = 0; nodIndex < arr.length; nodIndex++) {
            nodeList.add(new Node(arr[nodIndex]));
        }
        //以下定义主要依据上面讲解的第五条的特性实现
        for (int parentIndex = 0; parentIndex < arr.length/2-1; parentIndex++) {
            //左孩子
            nodeList.get(parentIndex).leftchild=nodeList.get(parentIndex*2+1);
            //右孩子
            nodeList.get(parentIndex).rightchild=nodeList.get(parentIndex*2+2);
        }
        //最后一个父节点，因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex=arr.length/2-1;
        //左孩子
        nodeList.get(lastParentIndex).leftchild=nodeList.get(lastParentIndex*2+1);
        if (arr.length%2==1) {
            nodeList.get(lastParentIndex).rightchild=nodeList.get(lastParentIndex*2+2);
        }
    }
    /**
     * 先序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     * 遍历的节点
     */
    public static void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftchild);
        preOrderTraverse(node.rightchild);
    }

    /**
     * 中序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftchild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightchild);
    }

    /**
     * 后序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftchild);
        postOrderTraverse(node.rightchild);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinTreeTraverse binTree = new BinTreeTraverse();
        binTree.createBintree();
        // nodeList中第0个索引处的值即为根节点
        Node root = nodeList.get(0);

        System.out.println("先序遍历：");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraverse(root);
    }

}
