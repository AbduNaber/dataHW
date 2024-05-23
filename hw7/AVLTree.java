public class AVLTree {

    private class Node {
        Stock stock;
        Node left, right;
        int height;

        Node(Stock stock) {
            this.stock = stock;
            this.height = 1;
        }
    }

    private Node root;

    // Insertion
    public void insert(Stock stock) {
        root = insert(root, stock);
    }

    private Node insert(Node node, Stock stock) {
        if (node == null) {
            return new Node(stock);
        }

        if (stock.getSymbol().compareTo(node.stock.getSymbol()) < 0) {
            node.left = insert(node.left, stock);
        } else if (stock.getSymbol().compareTo(node.stock.getSymbol()) > 0) {
            node.right = insert(node.right, stock);
        } else {
            node.stock = stock;
            return node;
        }


        // Update height and balance factor
        updateHeight(node);
        return balance(node);
        
    }

    // Deletion
    public void delete(String symbol) {
        root = delete(root, symbol);
    }

    private Node delete(Node node, String symbol) {

        // Base case
        if (node == null) {
            return null;
        }

        // Recursive case
        else if(symbol.compareTo(node.stock.getSymbol()) < 0) {
            node.left = delete(node.left, symbol);
        } 
        else if(symbol.compareTo(node.stock.getSymbol()) > 0) {
            node.right = delete(node.right, symbol);
        } 

        // Node to delete found
        else {

            // Node with only one child or no child
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
                
                
            } 
            // Node with two children
            else {
                Node temp = findMinimum(node.right);
                node.stock = temp.stock;
                node.right = delete(node.right, temp.stock.getSymbol());
                
            }
        }

        if( node == null) {
            return null;
        }

        // Update height and balance factor
        updateHeight(node);
        return balance(node);
       

    }
    private Node findMinimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Search
    public Stock search(String symbol) {
        Node result = search(root, symbol);
        return (result != null) ? result.stock : null;
    }

    private Node search(Node node, String symbol) {
        if (node == null) {
            return null;
        }

        if(symbol.compareTo(node.stock.getSymbol()) < 0) {
            return search(node.left, symbol);
        } 
        else if(symbol.compareTo(node.stock.getSymbol()) > 0) {
            return search(node.right, symbol);
        } 

        return node;
    }


    private int height(Node node) {
        return (node != null) ? node.height : 0;
    }

    private int balanceFactor(Node node) {
        return (node != null) ? height(node.left) - height(node.right) : 0;
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private Node rotateLeft(Node node) {

        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    private Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        updateHeight(node);
        updateHeight(temp);
        return temp;
    }

    private Node balance(Node node) {
        updateHeight(node);
        int balanceFactor = balanceFactor(node);
        // Left heavy
        if (balanceFactor > 1) {
            // Left-right heavy
            if (balanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }

            return rotateRight(node);
        }
        // Right heavy
        if (balanceFactor < -1) {
            // Right-left heavy
            if (balanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        
        }
        return node;
    }
    // In-order, pre-order, post-order traversals
    // For example:
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }


    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.stock);
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.stock);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.stock);
        }
    }
}
