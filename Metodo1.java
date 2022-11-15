// Una clase para almacenar un nodo de árbol binario
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
class Main
{
    // Función recursivo para calcular la altura de un árbol binario dado
    public static int height(Node root)
    {
        // caso base: el árbol vacío tiene una altura de 0
        if (root == null) {
            return 0;
        }
 
        // recurre para el subárbol izquierdo y derecho y considera la profundidad máxima
        return 1 + Math.max(height(root.left), height(root.right));
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
 
        System.out.println("The height of the binary tree is " + height(root));
    }
}