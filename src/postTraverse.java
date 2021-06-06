import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class postTraverse {
    public List<Integer> post(TreeNode root){
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;


    }
    public void postOrder(TreeNode root, List<Integer> res){
        if(root== null){
            return;
        }else{
            postOrder(root.left, res);
            postOrder(root.right, res);
            res.add(root.val);
        }
    }
}
