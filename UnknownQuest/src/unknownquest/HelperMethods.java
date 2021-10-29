package unknownquest;

public class HelperMethods {
	
	public static Item getItem(Item[] inventory,int inventoryElements, String itemName) {
	
		for(int i = 0; i < inventoryElements;i++)
		{
			if(inventory[i].getName().equals(itemName))
			{				
				return inventory[i]; 				
			}
		}	
		System.out.println("you don't have that item");
		return null;
	}
}
