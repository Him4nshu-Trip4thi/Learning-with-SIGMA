import java.util.LinkedList;
import java.util.Queue;

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

        public static void levelOrder(Node root){   //BFS using Queue
            Queue<Node> q= new LinkedList<>();

            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode= q.remove();

                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null) q.add(currNode.left);
                    if(currNode.right != null) q.add(currNode.right); 
                }
            }
        }

        public static int height(Node root){
            if(root==null) return 0;

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            int height = Math.max(leftHeight, rightHeight)+1;

            return height;
        }

        public static int countNodes(Node root){
            if(root==null){
                return 0;
            }

            int lc=countNodes(root.left);
            int rc=countNodes(root.right);

            int count= lc + rc + 1; //left count + right count + self

            return count;
        }

        public static int sumOfNodes(Node root){
            if(root == null) return 0;

            int ls=sumOfNodes(root.left);
            int rs=sumOfNodes(root.right);
            int sum = ls + rs + root.data;  //leftsum + rightsum + self value

            return sum;

        }

        public static int diameter(Node root){
            if( root == null) return 0;

            int leftD = diameter(root.left);
            int rightD = diameter(root.right);

            int self = height(root.left) + height(root.right) + 1; //left-height + right-height + 1

            int maxi = Math.max(self, Math.max(leftD, rightD));

            return maxi;
        }

        public static boolean isSubtree(Node root, Node subroot){
            if(root==null) return false;

            if(root.data == subroot.data){
                if(isIdentical(root, subroot)) return true;

            }
            return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
        }

        public static boolean isIdentical(Node node, Node subroot){ //helper function for isSubtree
            if(node==null && subroot==null) return true;
            if(node==null || subroot==null || node.data != subroot.data) return false;

            if(!isIdentical(node.left, subroot)) return false;
            if(!isIdentical(node.right, subroot)) return false;

            return true;

        }


    }
    public static void main (String args[]){
        int nodes[]={1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree.idx=-1;
        Node root=BinaryTree.buildTree(nodes);

        int subnodes[] = {2, 4, -1, -1, 5, -1, -1};
        BinaryTree.idx=-1;
        Node root2=BinaryTree.buildTree(subnodes);


        System.out.println("Root of the tree: "+root.data);

        System.out.print("The preOrder traversal of the nodes: "); BinaryTree.preOrder(root);
        System.out.println();
        System.out.print("The inOrder traversal of the nodes: "); BinaryTree.inOrder(root);
        System.out.println();
        System.out.print("The postOrder traversal of the nodes: "); BinaryTree.postOrder(root);
        System.out.println();
        System.out.println("The levelOrder traversal of the nodes: "); BinaryTree.levelOrder(root);
        System.out.println();
        System.out.println("Height of the Tree is : " + BinaryTree.height(root));
        System.out.println("Count of nodes in the Tree is : " + BinaryTree.countNodes(root));
        System.out.println("Sum of nodes in the Tree is : " + BinaryTree.sumOfNodes(root));
        System.out.println("Diameter of the Tree is : " + BinaryTree.diameter(root));
        System.out.println(BinaryTree.isSubtree(root, root2));
        
    }
}