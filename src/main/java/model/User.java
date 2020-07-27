package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Users")
@ApiModel(description="All details about a user ")
@ToString
public class User {

	@ApiModelProperty(notes = "Firstname of the user")
	@Setter @Getter @Column(name = "first_name")
	private String firstName;
	
	@ApiModelProperty(notes = "Lastname of the user")
	@Setter @Getter @Column(name = "last_name")
	private String lastName;
	
	@ApiModelProperty(notes = "Username of the user")
	@Setter @Getter @Column(name = "user_name")
	private String username;
	
	@ApiModelProperty(notes = "Password of the user")
	@Setter @Getter @Column(name = "password")
	private String password;
	
	@ApiModelProperty(notes = "The database generated user ID")
	@Getter @Column(name = "user_id")
	@Id @GeneratedValue(strategy=GenerationType.AUTO) private long userId;
	
	public User(){}
	
	public User(String fname,String lname,String username,String password)
	{
		this.firstName = fname;
		this.lastName = lname;
		this.username = username;
		this.password = password;
	}
	public User(long user_id,String fname,String lname,String username,String password)
	{
		this.firstName = fname;
		this.lastName = lname;
		this.username = username;
		this.password = password;
	}
	
}
