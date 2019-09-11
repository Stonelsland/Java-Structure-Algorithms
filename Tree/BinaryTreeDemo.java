package Tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        makeBinaryTree(binaryTree);
        //测试
        System.out.println("前序遍历");//一二三四
        binaryTree.preOrder();
        System.out.println("中序遍历");//二一三四
        binaryTree.infixOrder();
        System.out.println("后序遍历");//二四三一
        binaryTree.postOrder();

        //测试查找方法
//        testPreOrderSearch(binaryTree,3);
//        testInfixOrderSearch(binaryTree,3);
//        testPostOrderSearch(binaryTree,3);

    }

    public static void makeBinaryTree(BinaryTree binaryTree){
        //创建二叉树
        PersonNode root = new PersonNode(0, "零");
        PersonNode node1 = new PersonNode(1, "一");
        PersonNode node2 = new PersonNode(2, "二");
        PersonNode node3 = new PersonNode(3, "三");
        PersonNode node4 = new PersonNode(4, "四");
        PersonNode node5 = new PersonNode(5, "五");
        PersonNode node6 = new PersonNode(6, "六");
        //先手动创建二叉树,后续实现递归方式创建二叉树
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        binaryTree.setRoot(root);
    }

    public static void testPreOrderSearch(BinaryTree binaryTree,int id){
        System.out.println("前序查找:");
        PersonNode resNode = binaryTree.preOrderSearch(id);
        if (resNode!=null){
            System.out.println(resNode.toString());
        }else {
            System.out.println("未找到匹配项");
        }
    }
    public static void testInfixOrderSearch(BinaryTree binaryTree,int id){
        System.out.println("中序查找:");
        PersonNode resNode = binaryTree.infixOrderSearch(id);
        if (resNode!=null){
            System.out.println(resNode.toString());
        }else {
            System.out.println("未找到匹配项");
        }
    }
    public static void testPostOrderSearch(BinaryTree binaryTree,int id){
        System.out.println("后序查找:");
        PersonNode resNode = binaryTree.postOrderSearch(id);
        if (resNode!=null){
            System.out.println(resNode.toString());
        }else {
            System.out.println("未找到匹配项");
        }
    }
}

//定义二叉树
class BinaryTree {
    private PersonNode root;
    public void setRoot(PersonNode root) {
        this.root = root;
    }

    //删除结点
    public void deleteNode(int no){
        if (root!=null){
            //判断root是不是待删除结点
            if (root.getNo() ==no){
                root =null;
            }else {
                root.deleteNode(no);
            }
        }else {
            System.out.println("空树");
        }
    }
    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空,无法便利");
        }
    }
    //前序查找
    public PersonNode preOrderSearch(int no){
        if (root!=null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空,无法便利");
        }
    }

    //中序查找
    public PersonNode infixOrderSearch(int no){
        if (root!=null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空,无法便利");
        }
    }

    //后序查找
    public PersonNode postOrderSearch(int no){
        if (root!=null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }

}

//定义结点
class PersonNode {
    private int no;
    private String name;
    private PersonNode left;
    private PersonNode right;

    public PersonNode(int no, String name) {
        super();
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

    public PersonNode getLeft() {
        return left;
    }

    public void setLeft(PersonNode left) {
        this.left = left;
    }

    public PersonNode getRight() {
        return right;
    }

    public void setRight(PersonNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "PersonNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //递归删除结点
    public void deleteNode(int no){
        if(this.left!=null&&this.left.no == no){
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.no == no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.deleteNode(no);
        }
        if (this.right!=null){
            this.right.deleteNode(no);
        }
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);//输出父结点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);//输出父结点

        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        //递归向左子树后序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树后序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);//输出父结点
    }

    //前序遍历查找
    public PersonNode preOrderSearch(int no) {
        System.out.println("前序查找执行");
        //先比较当前结点是否相等,相等则返回
        if (this.no == no) {
            return this;
        }
        //若不等则判断当前结点的左子结点是否为空
        //不为空则递归前序查找
        PersonNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        //若左递归查找到结点则返回
        if (resNode != null) {
            return resNode;
        }
        //否则继续判断当前结点的右子结点是否为空
        // 若不为空,则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public PersonNode infixOrderSearch(int no) {
        System.out.println("中序查找执行");
        PersonNode resNode = null;
        //判断当前结点的左子结点是否为空
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        //若左递归查找到结点则返回
        if (resNode != null) {
            return resNode;
        }
        //否则比较当前结点,若找到,则返回
        if (this.no == no) {
            return this;
        }
        //否则继续判断当前结点的右子结点是否为空
        // 若不为空,则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历
    public PersonNode postOrderSearch(int no) {
        System.out.println("后序查找执行");
        PersonNode resNode = null;
        //判断当前结点的左子结点是否为空
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        //若左递归查找到结点则返回
        if (resNode != null) {
            return resNode;
        }
        //否则继续判断当前结点的右子结点是否为空
        // 若不为空,则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        //若右递归查找到结点则返回
        if (resNode != null) {
            return resNode;
        }
        //左右子树都没有找到则比较当前结点,若找到,则返回
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}

