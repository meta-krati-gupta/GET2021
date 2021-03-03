import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ShopCart Class
 * 
 * @author avinash.kumar_metacu
 * 
 */
public class ShopCart implements Cart {

	//Here key (Integer) is product ID
	//And value is product count
	private final Map<Integer, Integer> cartList;
	StockList stockList = StockList.getInstance();
	
	/**
	 * class constructor
	 */
	public ShopCart() {
		this.cartList = new HashMap<Integer, Integer>();
	}
	
	/* 
	 * Add item into the cart
	 */
	@Override
	public void add(Integer productId, int count) {
		StockList stockList = StockList.getInstance();
		if(stockList.contains(productId))
		{	
			cartList.putIfAbsent(productId, count);
		}
	}


	/* 
	 * check if cart contains item
	 */
	@Override
	public boolean contains(Integer productId) {
		return cartList.containsKey(productId);
	}



	/* 
	 * remove item from cart
	 */
	@Override
	public void remove(Integer productId) {
		cartList.remove(productId);
	}



	/* 
	 * update quantity for item
	 */
	@Override
	public boolean updateQuantity(Integer productId, int newCount ) {
		if(cartList.containsKey(productId)){
			int oldCount = cartList.computeIfPresent(productId, (key, val)-> newCount);
			return oldCount == newCount;
		}
		return false;
	}
	
	
	/* 
	 * Generate bill for cart
	 */
	@Override
	public Double generateBill(){
		Double total = 0.0;
		for(Integer pid: cartList.keySet()){
			Product currentProduct = stockList.getProducts().get(pid);
			int itemCount = cartList.get(pid);
			Double itemPrice = currentProduct.getPrice();
			total += itemPrice * itemCount;
		}
		return total;
	}


	/* 
	 * @return Map<itemId, itemQuantity> for items present in cart
	 */
	@Override
	public final Map<Integer, Integer> getCartItems() {
		return Collections.unmodifiableMap(cartList);
	}
	
	
	
}