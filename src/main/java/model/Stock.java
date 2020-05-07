package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "Stocks")
@ApiModel(description="All details about the Stocks. ")
public class Stock {

	private String companyName;
	//private int quantityBought;
	@ApiModelProperty(notes = "The database generated stock ID")
	@Id @GeneratedValue(strategy=GenerationType.AUTO)private long stockid;
	
//    @OneToMany(mappedBy = "u",
//            cascade = CascadeType.PERSIST,
//            fetch = FetchType.LAZY)
//    private Set<SavedStocks> ss;
    
	private float price;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stock_category_id", referencedColumnName="sectorid")
	private Sector stockCategory;
	private int quantityBought;
	
	
	public Stock(){}
	
	public Stock(String companyName,Sector category,float price)
	{
		this.companyName = companyName;
		this.stockCategory = category;
		this.price = price;
		//this.quantityBought = quantityBought;
	}
	
	@Column(name = "comapanyName",nullable = false)
	public String getCompanyName()
	{
		return companyName;
	}
	
	
	@Column(name = "category",nullable = false)
	public Sector getCategory()
	{
		return stockCategory;
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
	
	
	//@GeneratedValue(strategy = GenerationType.AUTO) //change to foreign key too
	public void setId(int id)
	{
		this.stockid = id;
	}
	public long getId()
	{
		return stockid;
	}
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	
	public void setStockCategory(Sector category)
	{
		this.stockCategory = category;
		stockCategory.getStocks().add(this);
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


