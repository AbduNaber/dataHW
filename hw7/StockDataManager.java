public class StockDataManager {
    private AVLTree avlTree;

    public StockDataManager() {
        avlTree = new AVLTree();
    }

    /**
     * adds or updates stock. if it is found then update.
     * @param symbol
     * @param price
     * @param volume
     * @param marketCap
     */
    public void addOrUpdateStock(String symbol, double price, long volume, long marketCap) {
        Stock existingStock = avlTree.search(symbol);
        if (existingStock != null) {
            existingStock.setPrice(price);
            existingStock.setVolume(volume);
            existingStock.setMarketCap(marketCap);
        } else {
            Stock newStock = new Stock(symbol, price, volume, marketCap);
            avlTree.insert(newStock);
        }
    }

    /**
     * Removes stock in AVL tree
     * @param symbol
     */
    public void removeStock(String symbol) {
        avlTree.delete(symbol);
    }

    /**
     * Search Stock in AVL tree
     * @param symbol
     * @return Stock
     */
    public Stock searchStock(String symbol) {
        return avlTree.search(symbol);
    }

    /**
     * Updates STOCK
     * @param symbol
     * @param newPrice
     * @param newVolume
     * @param newMarketCap
     */
    public void updateStock(String symbol, double newPrice, long newVolume, long newMarketCap) {
        // delete the stock with the old symbol
       Stock stock = avlTree.search(symbol);
         if(stock != null)
         {
            stock.setPrice(newPrice);
            stock.setVolume(newVolume);
            stock.setMarketCap(newMarketCap);

         }

    }
    
    public AVLTree getAvlTree() {
        return avlTree;
    }
    // Main method for testing
    public static void main(String[] args) {
        StockDataManager manager = new StockDataManager();
        manager.addOrUpdateStock("AAPL", 150.0, 1000000, 2500000000L);
        manager.addOrUpdateStock("GOOGL", 2800.0, 500000, 1500000000L);
        System.out.println(manager.searchStock("AAPL"));
        manager.removeStock("AAPL");
        System.out.println(manager.searchStock("AAPL"));
    }
}
