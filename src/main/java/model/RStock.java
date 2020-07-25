package model;
import java.math.BigDecimal;

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
import lombok.ToString;
import yahoofinance.Stock;

@ToString
@Entity
@Table(name = "Stocks")
@ApiModel(description="All details about the Stocks. ")
public class RStock {

	private String companyName;
	@ApiModelProperty(notes = "The database generated stock ID")
	@Id @GeneratedValue(strategy=GenerationType.AUTO)private long stockid;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stock_category_id", referencedColumnName="sectorid")
	private Sector stockCategory;
	
	String sector;
	BigDecimal price;
	BigDecimal bid;
	BigDecimal ask;
	BigDecimal change;
	
	public RStock(Stock s,String sector)
	{
		this.companyName = s.getName();
		this.sector = sector;
		this.price = s.getQuote().getPrice();
		this.bid = s.getQuote().getBid();
		this.ask = s.getQuote().getAsk();
		this.change = s.getQuote().getChange();
	}
	
	public RStock(){}
	
	@Column(name = "companyName",nullable = false)
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
	public BigDecimal getPrice()
	{
		return price;
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
	}

	public void setPrice(BigDecimal price) {
		// TODO Auto-generated method stub
		this.price = price;
	}
	
}


