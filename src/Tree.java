import org.w3c.dom.Node;

public class Tree {

    public static void main(String[] args) {
        BinaryTree2 bt = new BinaryTree2();
        BinaryTree root = new BinaryTree(1, "bmw");
        BinaryTree node2 = new BinaryTree(2, "bmw");
        BinaryTree node3 = new BinaryTree(3, "bmw");
        BinaryTree node4 = new BinaryTree(4, "bmw");
        BinaryTree node5 = new BinaryTree(5, "bmw");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        bt.setRoot(root);
        bt.postOrder();

        BinaryTree res = bt.preOrderSearch(5);
        if(res!=null){
            System.out.println("got it");
        }else{
            System.out.println("no such node");
        }

    }

}
class BinaryTree2{
    private BinaryTree root;

    public BinaryTree2() {
    }

    public void setRoot(BinaryTree root) {
        this.root = root;
    }
    public void preOrder(){
        if(this.root!=null){
            this.root.pre();
        }else{
            System.out.println("binary tree is null, cannot traverse");
        }
    }
    public void inOrder(){
        if(this.root!=null){
            this.root.in();
        }else{
            System.out.println("binary tree is null, cannot traverse");
        }
    }
    public void postOrder(){
        if(this.root!=null){
            this.root.post();
        }else{
            System.out.println("binary tree is null, cannot traverse");
        }
    }
    public BinaryTree preOrderSearch(int no){

        if(root!= null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }
    public BinaryTree inOrderSearch(int no){

        if(root!=null){
            return root.inOrderSearch(no);
        }else{
            return null;
        }
    }
    public BinaryTree postOrderSearch(int no){

        if(root!= null){
            return root.postOrderSearch();
        }else{
            return null;
        }
    }
}

class BinaryTree{
    private int no;
    private String name;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //pre-order
    public void pre(){
        System.out.println(this);
        if(this.left!=null){
            this.left.pre();
        }
        if(this.right!=null){
            this.right.pre();
        }
    }
    public void in(){

        if(this.left!=null){
            this.left.in();
        }
        System.out.println(this);
        if(this.right!= null){
            this.right.in();
        }
    }
    public void post(){

        if(this.left!=null){
            this.left.post();
        }
        if(this.right!= null){
            this.right.post();
        }
        System.out.println(this);
    }
    public BinaryTree preOrderSearch(int no){
        System.out.println("testPre");
        if(this.no == no){
            return this;
        }
        BinaryTree res = null;
        if(this.left!= null){
            res = this.left.preOrderSearch(no);
        }
        if(res!=null){
            return res;
        }
        if(this.right!= null){
            res = this.right.preOrderSearch(no);
        }
        return res;
    }
    public BinaryTree inOrderSearch(int no){
        System.out.println("testIn");
        BinaryTree res = null;
        if(this.left != null){
            res = this.left.inOrderSearch(no);

        }
        if(res!= null){
            return res;
        }
        if(this.no == no){
            return this;
        }
        if(this.right!= null){
            res= this.right.inOrderSearch(no);

        }
        return res;
    }
    public BinaryTree postOrderSearch(){
        System.out.println("testPost");
        BinaryTree res = null;
        if(this.left!= null){
            res = this.left.postOrderSearch();
        }
        if(res!= null){
            return res;
        }
        if(this.right!= null){
            res = this.right.postOrderSearch();
        }
        if(res!= null){
            return res;
        }
        if(this.no == no){
            return this;
        }
        return res;
    }
}

