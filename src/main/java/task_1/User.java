package task_1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class User {

	public User() {};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//for multiple, else NonUniqueObjectException					akarakos@iti.gr
	@Column(name = "userId")
	private int id; 
	
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "sname")
	private String sname;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "birth")
	private Date birth;
	
	public User(String f, String s, String g, Date b) {
		this.fname = f;
		this.sname = s;
		this.gender = g;
		this.birth = b;
	}

	
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", sname=" + sname + ", gender=" + gender + ", birth=" + birth
				+ "]";
	}
}
