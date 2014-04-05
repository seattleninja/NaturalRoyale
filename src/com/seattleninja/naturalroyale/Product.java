package com.seattleninja.naturalroyale;

public class Product extends BaseActivity{

	private String name, description;
	private int price, imageId;

	public Product(String name, int price, int imageId, String description) {
		super();
		this.name = name;
		this.price = price;
		this.imageId = imageId;
		this.description = description;

	}

	public Product(String name, int imageId) {
		super();
		this.name = name;
		this.imageId = imageId;
	}	

	public String getName(){
		return name;
	}

	public int getPrice(){
		return price;
	}

	public int getImageId(){
		return imageId;
	}
	
	public String getDescription(){
		return description;
	}


	

}
