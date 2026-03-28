import com.example.foodapp.config.FoodConfig;
import com.example.foodapp.model.Food;
import com.example.foodapp.model.Order;
import com.example.foodapp.service.FoodService;
import com.example.foodapp.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class FoodappApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FoodConfig.class);

		FoodService foodService = applicationContext.getBean(FoodService.class);
		OrderService orderService = applicationContext.getBean(OrderService.class);

		Scanner sc = new Scanner(System.in);

		System.out.println("=== Food Ordering System ===");
		int n = 0;

		while(n!=5){
			System.out.println(
					"1. Add Food\n" +
							"2. View Menu\n" +
							"3. Place Order\n" +
							"4. View Orders\n" +
							"5. Exit\n"
			);
			System.out.print("Enter option: ");
			n = sc.nextInt();
			sc.nextLine();
			switch(n){
				case 1:
					System.out.print("Enter name: ");
					String name = sc.nextLine();
					System.out.print("Enter price: ");
					double price = sc.nextDouble();
					foodService.addFood(name,price);
					System.out.println("Food item added successfully\n");
					break;
				case 2:
					List<Food> foodItems = foodService.getFoodItems();
					System.out.printf("%10s%s%n","","----- Menu -----");
					if(foodItems.isEmpty()){
						System.out.printf("%12s%s","","Menu is empty\n");
					}else {
						System.out.printf("%-5s %-20s %10s%n", "Id", "Name", "Price");
						System.out.println("-".repeat(40));
						for (Food foodItem : foodItems) {
							System.out.printf("%-5s %-20s %10.2f%n", foodItem.getId(), foodItem.getName(), foodItem.getPrice());
						}
					}
					System.out.println();
					break;
				case 3:
					System.out.print("Enter id: ");
					int id = sc.nextInt();
					sc.nextLine();
					boolean placed = orderService.placeOrder(id);
					if(placed){
						System.out.println("Order placed successfully");
					}else{
						System.out.println("Food item not found");
					}
					System.out.println();
					break;
				case 4:
					List<Order> orderList = orderService.getOrders();
					System.out.printf("%10s%s\n","","----- orders -----");
					if(orderList.isEmpty()){
						System.out.printf("%13s%s","","No orders yet\n");
					}else {
						System.out.printf("%-5s %-20s %10s\n","Id","Food","Bill");
						System.out.println("-".repeat(40));
						for(Order order : orderList) {
							System.out.printf("%-5d %-20s %10.2f\n",order.getId(),order.getFood().getName(),order.getBill());
						}
					}
					System.out.println();
					break;
				default:
					n = 5;
					System.out.println("--- Exiting ---");
			}
		}
	}
}