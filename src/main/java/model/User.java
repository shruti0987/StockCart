package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Users")
public class User {
	
	private String Fname;
	private String Lname;
	private String Username;
	private String Password;
	private long id;
	
	public User(){}
	
	public User(String Fname,String Lname,String Username,String Password)
	{
		this.Fname = Fname;
		this.Lname = Lname;
		this.Username = Username;
		this.Password = Password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
		return Username;
	}
	
	public void setUsername(String Username)
	{
		this.Username = Username;
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
	
	
}
