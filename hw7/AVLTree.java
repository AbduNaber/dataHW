public class AVLTree {
    
    private static class Node
    {
        private Stock data;
        private Node left;
        private Node right;
        private int height;

        public Node(Stock _data)
        {
            this.data = _data;
            this.height = 1;
        }
    }

    private Node root = null; 


    /**
     * Insert a stock
     * @param stock stock to be inserted
     */
    public void insert(Stock stock)
    {
        root = insert(root, stock);
    }

    /**
     * Helper recursive method
     * @param node localroot of the tree
     * @param stock stock to be inserted
     * @return inserted and balanced tree
     */
    private Node insert(Node node, Stock stock)
    {
        if(node == null)
            return new Node(stock);
        else if(node.data.getSymbol().compareTo(stock.getSymbol()) == 0)
            return node;
        else if(node.data.getSymbol().compareTo(stock.getSymbol()) < 0)
            node.right = insert(node.right, stock);
        else 
            node.left = insert(node.left, stock);

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        return balance(node);

    }
    
    /**
     * Delete a stock
     * @param symbol symbol of the stock to be deleted
     */
    public void delete(String symbol)
    {
        root = delete(root, symbol);
    }

    /**
     * Helper recursive delete method
     * @param node localroot of the tree
     * @param symbol symbol of the stock to be deleted
     * @return given symbol deleted and balanced tree
     */
    private Node delete(Node node, String symbol) {
        if (node == null) {
            return node;
        }

        if (symbol.compareTo(node.data.getSymbol()) < 0) {
            node.left = delete(node.left, symbol);
        } else if (symbol.compareTo(node.data.getSymbol()) > 0) {
            node.right = delete(node.right, symbol);
        } else {
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                Node temp = getMinValueNode(node.right);
                node.data = temp.data;
                node.right = delete(node.right, temp.data.getSymbol());
            }
        }

        if (node == null) {
            return node;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return balance(node);
    }

    /**
     * gets the min node
     * @param node the subtree's root
     * @return min node
     */
    private Node getMinValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * Search for a stock in the tree with the given symbol
     * @param symbol symbol of the stock to be searched
     * @return stock if found, null otherwise
     */
    public Stock search(String symbol)
    {
        Node result = search(root, symbol);
        return (result != null) ? result.data : null;
    }

    /**
     * Helper recursive search method
     * @param node the tree that will be searched
     * @param symbol the symbol of the stock to be searched
     * @return Node if found, null otherwise
     */
    private Node search(Node node, String symbol)
    {
        if(node == null)
            return null;
        else if(node.data.getSymbol().compareTo(symbol) == 0)
            return node;
        else if(node.data.getSymbol().compareTo(symbol) < 0)
            return search(node.right, symbol);
        else 
            return search(node.left, symbol);
    }

    //BALANCING METHODS
    /**
     * Balancing the tree
     * @param node the unbalanced node
     * @return balanced tree
     */
    private Node balance(Node node) {
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            //LEFT-LEFT TREE
            if (getBalanceFactor(node.left) >= 0) {
                return rotateRight(node);
            }
            //LEFT-RIGHT TREE 
            else {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if (balanceFactor < -1) {
            //RIGHT-RIGHT TREE
            if (getBalanceFactor(node.right) <= 0) {
                return rotateLeft(node);
            } 
            //RIGHT-LEFT TREE
            else {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }



    
    /**
     * @param y Node to be rotated right
     * @return right rotation of the node
     */
    private Node rotateRight(Node y)
    {
        Node x = y.left;
        Node temp = x.right;

        x.right = y;
        y.left = temp;

        y.height = updateHeight(y);
        x.height = updateHeight(x);

        return x;
    }

    /**
     * @param x Node to be rotated left
     * @return left rotation of the node
     */
    private Node rotateLeft(Node x)
    {
        Node y = x.right;
        Node temp = y.left;

        y.left = x;
        x.right = temp;

        x.height = updateHeight(x);
        y.height = updateHeight(y);
        
        return y;
    }


    
    
    /**
     * get the height of given node
     * @param node given node
     * @return height of the node
     */
    private int getHeight(Node node)
    {
        if(node == null)
            return 0;
        else
            return node.height;
    }

    /**
     * Update the height of given node
     * @param node Node to update height
     * @return updated height
     */
    private int updateHeight(Node node)
    {
        return Math.max(getHeight(node.left), getHeight(node.right)) +1;
    }

    /**
     * Get Balance Factor
     * @param node Node to get balance factor
     * @return balance factor of the node
     */
    private int getBalanceFactor(Node node)
    {
        if(node == null)
            return 0;
        else 
            return getHeight(node.left) - getHeight(node.right);
    }


    //TRAVERSAL METHODS
    
    /**
     * Inorder traversal of the tree
     */
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    /**
     * Preorder traversal of the tree
     */
    public void preorder()
    {
        preorder(root);
    }

    private void preorder(Node root)
    {
        if(root != null)
        {
            preorder(root.left);
            preorder(root.right);
            System.out.println(root.data);
        }
    }

    /**
     * Postorder traversal of the tree
     */
    public void postorder()
    {
        postorder(root);
    }

    private void postorder(Node root)
    {
        if(root != null)
        {
            System.out.println(root.data);
            postorder(root.left);
            postorder(root.right);
        }
    }
}