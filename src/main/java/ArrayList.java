class ArrayList {
    private String itemName;
    private double price;

    public ArrayList(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }
}

 class ShoppingList {
    private java.util.ArrayList<ArrayList> purchases;

    public ShoppingList() {
        this.purchases = new java.util.ArrayList<>();
    }

    public void addPurchase(String itemName, double price) {
        purchases.add(new ArrayList(itemName, price));
    }

    public void displayPurchases() {
        System.out.println("Shopping List:");
        for (ArrayList purchase : purchases) {
            System.out.println("Item: " + purchase.getItemName() + ", Price: " + purchase.getPrice());
        }
    }

    public void searchPurchase(String itemName) {
        System.out.println("Searching for item: " + itemName);
        boolean found = false;
        for (ArrayList purchase : purchases) {
            if (purchase.getItemName().equalsIgnoreCase(itemName)) {
                System.out.println("Item found - " + "Item: " + purchase.getItemName() + ", Price: " + purchase.getPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Item not found!");
        }
    }

    public void removePurchase(String itemName) {
        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).getItemName().equalsIgnoreCase(itemName)) {
                purchases.remove(i);
                System.out.println("Item '" + itemName + "' removed successfully!");
                return;
            }
        }
        System.out.println("Item '" + itemName + "' not found in the list!");
    }

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.addPurchase("Apple", 2.5);
        shoppingList.addPurchase("Banana", 1.0);
        shoppingList.addPurchase("Milk", 3.0);

        shoppingList.displayPurchases();

        shoppingList.addPurchase("Bread", 2.0);

        shoppingList.displayPurchases();

        shoppingList.searchPurchase("Banana");

        shoppingList.removePurchase("Banana");

        shoppingList.displayPurchases();
    }
}
