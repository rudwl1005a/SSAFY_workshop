package oop.override.equalshash;

public class Item {
	int itemId;
	String itemNm;
	
	Item(){}
	Item(int itemId, String itemNm){
		this.itemId = itemId;
		this.itemNm = itemNm;
	}
	
	@Override
	public boolean equals(Object obj) {
		// 멤버 변수들의 비교
		// 두개의 객체
		//	1. 자기 자신
		//	2. 전달되는 객체
		if(obj == null || !(obj instanceof Item)) return false;
		
		Item item = (Item) obj;
		if(this.itemId == item.itemId && this.itemNm.equals(item.itemNm)){
			return true;
		} else
			return false;
	}
	
	@Override
	public int hashCode() {
		return java.util.Objects.hash(this.itemId, this.itemNm);
	}
}
