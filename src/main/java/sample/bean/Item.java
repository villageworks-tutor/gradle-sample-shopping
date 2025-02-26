package sample.bean;

public class Item {
	/**
	 * フィールド
	 */
	private int id;
	private int categoryId;
	private String name;
	private int price;
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Item() {}
	
	/**
	 * コンストラクタ
	 * @param id         商品番号
	 * @param categoryId カテゴリコード
	 * @param name       商品名
	 * @param price      価格
	 */
	public Item(int id, int categoryId, String name, int price) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", price=" + price + "]";
	}

}
