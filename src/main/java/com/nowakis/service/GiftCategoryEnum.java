package com.nowakis.service;

public enum GiftCategoryEnum {

	CATEGORY_1("Mesa e Banho"),
	CATEGORY_2("Mesa e Banho"),
	CATEGORY_3("Mesa e Banho"),
	CATEGORY_4("Mesa e Banho"),
	CATEGORY_5("Mesa e Banho"),
	CATEGORY_6("Mesa e Banho"),
	CATEGORY_7("Mesa e Banho"),
	CATEGORY_8("Mesa e Banho"),
	CATEGORY_9("Mesa e Banho"),
	CATEGORY_20("Eletrodométicos");
	
	private final String category;
	
	private GiftCategoryEnum(final String category) {
		this.category = category;
	}
	
	static public GiftCategoryEnum from(String category) {
		return GiftCategoryEnum.valueOf(category);
	}
}
