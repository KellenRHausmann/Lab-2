class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /**
     * Pre-order Traversal traversal for traversing the binary tree
     * @param root Root for traversing the binary search tree
     */
    public void preOrderTraversal(Node root){
       if(root == null)
       {
          return;
       }
       System.out.print(root.value + ", ");
       inOrderTraversal(root.left);
       inOrderTraversal(root.right);
    }

   
   
   /**
    * In-order traversal for traversing the binary tree
    * @param root Root node for traversing the binary search tree
    */
    public void inOrderTraversal(Node root)
    {
      if(root == null)
      {
         return;
      }
      inOrderTraversal(root.left);
      System.out.print(root.value + ", ");
      inOrderTraversal(root.right);
    }
   
   
   
   /**
    * Post-Order Traversal for traversing the binary tree
    * @param root Root node for traversing the binary search tree in post order
    */
    public void postOrderTraversal(Node root)
    {
       if(root == null)
      {
         return;
      }
       inOrderTraversal(root.left);
       inOrderTraversal(root.right);
       System.out.print(root.value + ", ");
    }
   
   
   
   /**
     * This is for finding a soecific key value and returning a true or false if that key is in the binary search tree
     * @param root Root node as the starting poistion in the binary search tree
     * @param key Key for comparing the root value to see if they are the value
     * @return returns if the value is true if the key is present and false if not
     */
    public boolean find(Node root, int key)
    {
      if(root == null)
      {
         return false;
      }

      if(root.value == key)
      {
         return true;
      }
      else if(root.value > key)
      {
         return find(root.left, key);
      } 
      else if(root.value < key)
      {
         return find(root.right, key);
      }
      else
      {
         return false;
      }  
    }
   
   
   
   /**
     * Gets the minimum value in the binary serach tree
     * @param root Root node for traversal
     * @return returns the minimum value in the binary search tree
     */
    public int getMin(Node root)
    {
      if(root.left == null)
      {
         return root.value;
      }
      else
      {
         return getMin(root.left);
      }
    }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  //implement me
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}