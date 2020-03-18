package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Stocks")
public class Stock {

	private String companyName;
	private int quantityBought;
	private float price;
	private String category;
	private long id;
	
	Stock(){}
	
	Stock(String companyName,String category,float price,int quantityBought)
	{
		this.companyName = companyName;
		this.category = category;
		this.price = price;
		this.quantityBought = quantityBought;
	}
	
	@Column(name = "comapanyName",nullable = false)
	public String getCompanyName()
	{
		return companyName;
	}
	
	@Column(name = "category",nullable = false)
	public String getCategory()
	{
		return category;
	}
	
	@Column(name = "price",nullable = false)
	public float getPrice()
	{
		return price;
	}
	
	@Column(name = "quantityBought",nullable = false)
	public int getQuantityBought()
	{
		return quantityBought;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //change to foreign key too
	public void setId(int id)
	{
		this.id = id;
	}
	public long getId()
	{
		return id;
	}
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public void setPrice(float price)
	{
		this.price = price;
	}
	
	public void setQuantityBought(int quantityBought)
	{
		this.quantityBought = quantityBought;
	}
	
}
