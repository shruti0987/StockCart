package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "Users")
@RequestMapping("/user")
@ApiModel(description="All details about the Users. ")
public class User {
	
	@ApiModelProperty(notes = "The user first name")
	private String Fname;
	
	@ApiModelProperty(notes = "The user last name")
	private String Lname;
	private String username;
	private String Password;
	
	@ApiModelProperty(notes = "The database generated user ID")
	@Id @GeneratedValue(strategy=GenerationType.AUTO) private long id;
	
//    @OneToMany(
//            mappedBy = "userid",
//            cascade = CascadeType.PERSIST,
//            fetch = FetchType.LAZY
//        )
//    private Set<SavedStocks> ss;
    
	public User(){}
	
	public User(String Fname,String Lname,String Username,String Password)
	{
		this.Fname = Fname;
		this.Lname = Lname;
		this.username = Username;
		this.Password = Password;
	}

	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	public void setId(int id)
	{
		this.id = id;
	}
	public long getId()
	{
		return id;
	}
	
	@Column(name = "FirstName",nullable = false)
	public String getFirstName()
	{
		return Fname;
	}
	
	public void setFirstName(String Fname)
	{
		this.Fname = Fname;
	}
	
	@Column(name = "LastName",nullable = false)
	public String getLastName()
	{
		return Lname;
	}
	public void setLastName(String Lname)
	{
		this.Lname = Lname;
	}
	
	@Column(name = "Username",nullable = false)
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String Username)
	{
		this.username = Username;
	}
	
	@Column(name = "Password",nullable = false)
	public String getPassword()
	{
		return Password;
	}
	
	public void setPassword(String Password)
	{
		this.Password = Password;
	}
	
//	public Set<SavedStocks> getSavedStocks() {
//        return ss;
//    }
//
//	  public void setSavedStocks(Set<SavedStocks> st) {
//	        this.ss = st;
//	        for (SavedStocks stock : st) {
//	            stock.setSavedStockUserID(this);
//	        }
//	  }
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + getFirstName() + ", lastName=" + getLastName()
				+ "]";
	}
	
}
