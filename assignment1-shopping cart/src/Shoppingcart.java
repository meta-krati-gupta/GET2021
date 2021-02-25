import java.util.ArrayList;
import java.util.Scanner;

class CartItem{
	public String product;
	public int quantity;
	public double price;
	
	CartItem(String Product, double Price, int Quant){
		product = Product;
		price = Price;
		quantity = Quant;
	}
	
	public boolean equalToItem(CartItem item, String myItem){
		if(item.product.equalsIgnoreCase(myItem)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		String result="";
		return result;
	}

}

public class Shoppingcart {

	public static void main(String[] args) {
		//Todo Auto-generated method stub;
		//Create a shop with four items
		ArrayList<CartItem> Shop = new ArrayList<CartItem>();
		Shop.add(new CartItem("shampoo", 200.0, 12));
		Shop.add(new CartItem("apple", 120.0, 12));
		Shop.add(new CartItem("mango", 70.0, 12));
		Shop.add(new CartItem("wheat", 40.0, 12));
		Shop.add(new CartItem("Biscuit",250.0,25));
		Shop.add(new CartItem("chocolates", 200.0, 22));
		Shop.add(new CartItem("banana", 120.0, 22));
		Shop.add(new CartItem("lotion", 70.0, 12));
		Shop.add(new CartItem("soap", 40.0, 12));
		Shop.add(new CartItem("sanitizer",250.0,25));

		// Create a shopping cart for customer
		Scanner sc = new Scanner(System.in);
		ArrayList<CartItem> Cart = new ArrayList<CartItem>();

		int choice;
		boolean keep = true;
		
        while(keep){
        	System.out.println("Welcome to shop...");
        	System.out.println("Enter 1 to add Item in cart....");
        	System.out.println("Enter 2 to delete Item in cart....");
        	System.out.println("Enter 3 to generate bill....");
        	System.out.println("Enter 4 to show Item present in shop....");
        	System.out.println("Enter 5 to show Item in cart....");
        	System.out.println("Enter 6 to update Item quantity in Cart....");
        	System.out.println("Enter 7 to End shopping....");
        	
        	choice = sc.nextInt();
        	sc.nextLine();
        	if(choice<1 || choice>7)
        	{
        		System.out.println("Enter a value between 1 and 7:");
        	}
        	else{
        		switch(choice){
					case 1: 
						// Add an item in cart
						double totalPrice = 0;	
						System.out.println("Enter name of item: ");
						String item = sc.nextLine();
						System.out.println("Enter quantity of item: ");
						int noOfItem = sc.nextInt();
						sc.nextLine();
						for(CartItem obj : Shop){
							if(obj.product.equalsIgnoreCase(item)){
								obj.quantity -= noOfItem;
								totalPrice = obj.price * noOfItem;
								break;
							}
						}
						if(totalPrice==0){
							break;
						}
						else{
							Cart.add(new CartItem(item, totalPrice, noOfItem));
						}
						break;
        			
					case 2:
						// Delete item from the cart
						int found = 0;
						System.out.println("Enter an item to remove: ");
						item = sc.nextLine();
						for(CartItem obj : Cart){
							if (obj.product.equalsIgnoreCase(item)){
								found = 1;
								updateShopQuantity(Shop, Cart, obj);
								System.out.println(item + " has been removed.");
								break;
							}
						}
						if(found==0){
							System.out.println(item + "is not present in cart");
						}
							
						if(found==0){
							System.out.println(item + "was not found in your shopping cart.");
							
						}
						break;
         			
					case 3:
						// Generate bill 	
						if(Cart.size()>0){
							double bill = 0;
							for(CartItem allItems : Cart){
								bill = bill + allItems.price;
							}
							System.out.println("Total bill is: " + bill);
						}
						else{
							System.out.println("Cart is empty...!");
						} 
						break;
        			  
					case 4:
						// Show item(s) present in shop
						printDetailsOfCartOrShop(Shop);
						break;
        			  
					case 5:
						printDetailsOfCartOrShop(Cart);
						break;
        		    	
					case 6:
						// Update item quantity in cart
						System.out.println("Enter an item to remove: ");
						item = sc.nextLine();
						System.out.println("Enter number of items to remove: ");
						noOfItem = sc.nextInt();
						sc.nextLine();
						found = 0;
						for(CartItem obj : Cart) {
							if (obj.product.equalsIgnoreCase(item)){
								if(obj.quantity>noOfItem){
									found = 1;
									obj.quantity -= noOfItem;
									for(CartItem obj1 : Shop){
										if(obj1.product.equalsIgnoreCase(item)){
											obj1.quantity += noOfItem;
											obj.price -= obj1.price * noOfItem;
											
										}
									}
									System.out.println("Quantity Updated\n");
									break;
								}
								else if(obj.quantity==noOfItem){
									found = 1;
									updateShopQuantity(Shop, Cart, obj);
									System.out.println("Quantity Updated\n");
									break;
								}
								else{
									System.out.println("Not enough quantity present in cart...!");
									break;
								}
							}
						}
						break;

					case 7:
						// End shopping
						System.out.println("Thank you for shopping.......");
						sc.close();
						keep = false;
						break;
        		    	
        		}
        	}
        	
        }
        
         
    }

	private static void printDetailsOfCartOrShop(ArrayList<CartItem> Shop) {
		System.out.println("\nproduct\tprice\tquantity\n");
		for(CartItem allItems : Shop){
			System.out.println(allItems.product + "\t" + allItems.price + "\t" + allItems.quantity);
		}
		System.out.println("\n");
	}

	private static void updateShopQuantity(ArrayList<CartItem> Shop, ArrayList<CartItem> Cart, CartItem obj) {
		for (CartItem obj1 : Shop) {
			obj1.quantity += obj.quantity;
		}
		Cart.remove(obj);
	}
}












