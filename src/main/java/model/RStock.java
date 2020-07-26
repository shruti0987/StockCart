package model;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import yahoofinance.Stock;

@ToString
@Entity
@ApiModel(description="All details about the Stocks. ")
@Setter @Getter
public class RStock{
	
	@ApiModelProperty(notes = "The database generated stock ID")
	@Id @GeneratedValue(strategy=GenerationType.AUTO)private long stockid;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stock_category_id", referencedColumnName="sectorid")
	Sector stockCategory;
	String sector;
	String companyName;
	String symbol;
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
	
}


