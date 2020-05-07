package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import javax.persistence.IdClass;


@Entity
@Table(name = "SavedStocks")
@ApiModel(description="All details about the Stocks. ")

@IdClass(SectorStocks.class)
public class SavedStocks implements Serializable 
{

		@Id
		private long userid;
	    @Id
	    private long stockid;
	    @Id
	    private String date;

	    private int quantity;
	    
	    
//	    @ManyToOne(fetch=FetchType.LAZY)
//		@JoinColumn(name="userid", referencedColumnName="userid")
//		private User userid;
	    
	
	    
	    public SavedStocks() {
	    }

	    public SavedStocks(long userid,long stockid,String date,int quantity) {
	        this.date=date;
	        this.stockid=stockid;
	        this.userid=userid;
	        this.quantity=quantity;
	    }

	    // getters and setters
//	    public void setUserId(User id)
//		{
//			this.u = id;
//		}
//		public User getUserId()
//		{
//			return u;
//		}
		
		public long getStockId()
		{
			return stockid;
		}
		
		public void setStockId(long stockid)
		{
			this.stockid = stockid;
		}
		public long getUserId()
		{
			return userid;
		}
		
		public void setUserId(long u)
		{
			this.userid = u;
		}
		
		public String getDate()
		{
			return date;
		}
		public void setDate(String date)
		{
			this.date = date;
		}
		
		public int getQuantity()
		{
			return quantity;
		}
		
		public void setQuantity(int quantity)
		{
			this.quantity = quantity;
		}
		
//		public void setSavedStockUserID(User ui)
//		{
//			this.userid = ui;
//			userid.getSavedStocks().add(this);
//		}
		@Override
		public String toString() {
			return "Saved Stocks: [userid=" + userid + ", stockid=" + getStockId() + ", Date=" + getDate()+" ,Quantity="+getQuantity()+ "]";
		}
		
}