package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "SavedStocks")
@ApiModel(description = "All details about the stocks.")
@Getter @Setter
public class SavedStocks{

	@Id @Column(name = "user_id",columnDefinition = "default = 0")
	long userId;
	
	@Column(name = "sector")
	String sector;
	
	@Column(name = "company_name")
	String companyName;
	
	@Column(name = "symbol")
	String symbol;
	
	@Column(name = "price")
	BigDecimal price;
	
	@Column(name = "bid")
	BigDecimal bid;
	
	@Column(name = "ask")
	BigDecimal ask;
	
	@Column(name = "change")
	BigDecimal change;
	
	@Column(name = "saved_on")
	String savedOn; // Date

	public SavedStocks() {}
	
	public SavedStocks(long userid) {this.userId = userid;}

	public SavedStocks(long userid,String date, RStock s) {
		this.userId = userid;
		this.companyName = s.companyName;
		this.symbol  = s.symbol;
		this.sector = s.sector;
		this.price = s.price;
		this.ask = s.ask;
		this.change = s.change;
		this.savedOn = date;
	}

}