package cw06_bank.datalayer;

import java.util.ArrayList;

public class Client {
	// ------------------------------------------------
	private long id;
	private String name;
	private ArrayList<Product> products;

	// ------------------------------------------------
	public Client(long id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.products = new ArrayList<>();
	}

	// ------------------------------------------------
	public void addProduct(Product product) {
		products.add(product);
	}

	// ------------------------------------------------
	public ArrayList<Product> getProducts() {
		return products;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return id + " " + name;
	}
}
