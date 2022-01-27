package java8.lambda;

import java.util.Arrays;

public class ArrayTest {
	
	public static void main(String[] args) {
		Item[] itemArray = {
				new Item(3, "item3"),
				new Item(1, "item1"),
				new Item(4, "item4"),
				new Item(2, "item2")
		};
		
//		Arrays.sort(itemArray); // 아무것도 안해주면 cannot be cast to java.lang.Comparable
		Arrays.sort(itemArray, (it1, it2) -> it1.itemId - it2.itemId);
		
		System.out.println(Arrays.toString(itemArray));
		
		
	}
	
	static class Item {
		int itemId;
		String itemNm;
		
		public Item(int itemId, String itemNm) {
			this.itemId = itemId;
			this.itemNm = itemNm;
		}

		@Override
		public String toString() {
			return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
		}

	}
	
//	static class Item implements Comparable<Item> {
//		int itemId;
//		String itemNm;
//		
//		public Item(int itemId, String itemNm) {
//			this.itemId = itemId;
//			this.itemNm = itemNm;
//		}
//		
//		@Override
//		public String toString() {
//			return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
//		}
//		
//		@Override
//		public int compareTo(Item o) {
////			return this.itemId - o.itemId;
//			return this.itemNm.compareTo(o.itemNm);
//		}
//		
//	}
}
