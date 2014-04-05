package com.seattleninja.naturalroyale;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
//import android.widget.Toast;

public class TheGrid extends BaseActivity {
	

	private List<Product> myProducts = new ArrayList<Product>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview);
		generateList();
		generateView();
		registerClick();
	      
	}


	private void generateList() {
		// myProducts.add(new Product("Flavor", 20, R.drawable.image,"Amazing"));
		myProducts.add(new Product("Amaretto", 1, R.drawable.amaretto, "Delicious Coffee"));
		myProducts.add(new Product("BlueBerry Cheesecake", 2, R.drawable.bbccake, "Most Popular Dessert"));
		myProducts.add(new Product("Butter Scotch", 3, R.drawable.bscotch, "Like Candy"));
		myProducts.add(new Product("Bubble Gum", 4, R.drawable.bubble, "Yummy"));
		myProducts.add(new Product("Cookies and Cream", 5, R.drawable.candc, "Very Popular"));
		myProducts.add(new Product("Cotton Candy", 55, R.drawable.cotton, "Very Popular"));
		myProducts.add(new Product("Caramel Apple", 6, R.drawable.capple, "A Favorite"));
		myProducts.add(new Product("Cherry", 7, R.drawable.cherry, "It is Delicious"));
		myProducts.add(new Product("Fruit Punch", 8, R.drawable.fpunch, "A combination of Amazing Fruits"));
		myProducts.add(new Product("French Vanilla", 9, R.drawable.fvanilla, "A True Vanilla taste"));			
		myProducts.add(new Product("Honey Dew", 10, R.drawable.honeydew, "Very Good"));			
		myProducts.add(new Product("Maple Syrup",11, R.drawable.maple, "All Organic"));			
		myProducts.add(new Product("Menthol", 12, R.drawable.menthol, "If you like that crstyal sensation"));			
		myProducts.add(new Product("Mint", 13, R.drawable.mint, "Crisp and Fresh"));			
		myProducts.add(new Product("Nectarine", 14, R.drawable.nectarine, "Taste really Good"));			
		myProducts.add(new Product("Rasberry", 15, R.drawable.rberry, "Better than the Awards"));			
		myProducts.add(new Product("Strawberry", 16, R.drawable.sberry, "Taste Good"));			
		myProducts.add(new Product("Strawberry Mango", 17, R.drawable.smango, "Like a Smoothie"));			
		myProducts.add(new Product("Watermelon", 18, R.drawable.wmelon, "Great for a Summer Day"));			
												
	}



	private void generateView() {
		ArrayAdapter<Product> adapter = new MyListAdapter();
		GridView myGrid = (GridView) findViewById(R.id.gridView);
		myGrid.setAdapter(adapter);
	}
	
	
	private class MyListAdapter extends ArrayAdapter<Product>{
		public MyListAdapter(){
			super(TheGrid.this, R.layout.gridview, myProducts);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View itemView = convertView;
			if(itemView == null){
				itemView = getLayoutInflater().inflate(R.layout.singleview, parent, false);
				
			} 
			//Find the product
			Product currentProduct = myProducts.get(position);
			
			//Fill Images:
			ImageView imageView = (ImageView)itemView.findViewById(R.id.ivImage);
			imageView.setImageResource(currentProduct.getImageId());
		
			//Name:
			TextView nameText = (TextView) itemView.findViewById(R.id.tvName);
			nameText.setText(currentProduct.getName());
			
			//Price: 
			//TextView priceText = (TextView) itemView.findViewById(R.id.tvPrice);
			//priceText.setText("" + currentProduct.getPrice()); 
			
			//Description:
		    //TextView descriptionText = (TextView) itemView.findViewById(R.id.tvDescription);
		    //descriptionText.setText(currentProduct.getDescription());
			
			return itemView;
		
		}
		
	}

	
		private void registerClick() {
			GridView myGrid = (GridView) findViewById(R.id.gridView);
			myGrid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
	
				@Override
				public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) { 		

					Product clickedItem = myProducts.get(position);
					String name = clickedItem.getName();
					String description = clickedItem.getDescription();
					int photo = clickedItem.getImageId();
					
					Intent i = new Intent(TheGrid.this, SingleItem.class);
					Bundle bundle = new Bundle();
					
					bundle.putString("name", name);
					bundle.putString("description", description);
					bundle.putInt("photo", photo);
					i.putExtras(bundle);
					startActivity(i);
					
					setResult(RESULT_OK,i);
					finish();
						
						/*
						String message = "Details: " + clickedItem.getDescription();
					    //String message = "Yes " + position + "Flavor" + clickedItem.getName();
						Toast.makeText(TheGrid.this, message, Toast.LENGTH_LONG).show();
						*/
						
				}
					
		});
		
	} 
		

		
		
}