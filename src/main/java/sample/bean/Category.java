package sample.bean;

public class Category {
	
	/**
	 * フィールド
	 */
	private int id;
	private String name;

	/**
	 * デフォルトコンストラクタ
	 */
	public Category() {}

	/**
	 * コンストラクタ
	 * @param id   カテゴリID
	 * @param name カテゴリ名
	 */
	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
}
