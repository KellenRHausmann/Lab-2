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
   
	public BinarySearchTree(int val) 
    {
      root = new Node(val);
    }
   
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
  
  
  
   /**
     * Gets the maximum value in the binary serach tree
     * @param root Root node for traversal
     * @return returns the maximum value in the binary search tree
     */
    public int getMax(Node root)
    {
      if(root.right == null)
      {
         return root.value;
      }
      else
      {
         return getMin(root.right);
      }
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
      BinarySearchTree t1  = new BinarySearchTree(24);
       t1.insert(t1.root, 80);
       t1.insert(t1.root, 18);
       t1.insert(t1.root, 9);
       t1.insert(t1.root, 90);
       t1.insert(t1.root, 22);

       System.out.print("pre-order: ");
       t1.preOrderTraversal(t1.root);
       System.out.println("");

       System.out.print("in-order: ");
       t1.inOrderTraversal(t1.root);
       System.out.println("");

       System.out.print("post-order: ");
       t1.postOrderTraversal(t1.root);
       System.out.println("");

       boolean foundKey = t1.find(t1.root, 22);
       System.out.println("Does 22 exist in the binary search tree? " + foundKey);
       
       boolean keyNotFound = t1.find(t1.root, 2124);
       System.out.println("Does 2124 exist in the binary search tree? " + keyNotFound);

       int min = t1.getMin(t1.root);
       System.out.println("The minimum value is: " + min);

       int max = t1.getMax(t1.root);
       System.out.println("The maximum value is: " + max);
           
      
   }  
}