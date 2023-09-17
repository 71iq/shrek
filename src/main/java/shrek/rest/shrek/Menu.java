package shrek.rest.shrek;
import java.util.ArrayList;
public class Menu {
	private final int price, calories;
	protected int quantity;
	private final String name, imageName, description;
	static ArrayList<Menu> menu = new ArrayList<>();

	Menu(String n, String in, String d, int p, int c){
		this.calories = c;
		this.description = d;
		this.name = n;
		this.imageName = in;
		this.quantity = 0;
		this.price = p;
	}

	@Override
	public String toString() {
		return "Menu{" + "price=" + price + ", calories=" + calories + ", quantity=" + quantity + ", name='" + name + '\'' + ", imageName='" + imageName + '\'' + ", description='" + description + '\'' + '}';
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static ArrayList<Menu> getMenu() {
		return menu;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getName() {
		return name;
	}

	public String getImageName() {
		return imageName;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public int getCalories() {
		return calories;
	}
}