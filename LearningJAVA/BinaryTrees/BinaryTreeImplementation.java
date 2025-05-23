public class BinaryTreeImplementation{
    static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1) return null;

            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root){  // root-left-right
            if(root==null) return;

            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root){  // left-root-right
            if(root==null) return;
            
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){ // left-right-root
            if(root==null) return;

            
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");

        }


    }
    public static void main (String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        System.out.println("Root of the tree: "+root.data);

        System.out.print("The preOrder traversal of the nodes: "); tree.preOrder(root);
        System.out.println();
        System.out.print("The inOrder traversal of the nodes: "); tree.inOrder(root);
        System.out.println();
        System.out.print("The postOrder traversal of the nodes: "); tree.postOrder(root);
        
    }
}