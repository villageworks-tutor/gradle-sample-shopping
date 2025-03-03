package com.example.bean;

public class Category {

	/**
	 * フィールド
	 */
	private int id;       // カテゴリコード
	private String  name; // カテゴリ名
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Category() {}

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
