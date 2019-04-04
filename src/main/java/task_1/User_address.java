package task_1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_addr")
public class User_address {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)													//for multiple, else NonUniqueObjectException					akarakos@iti.gr
	@Column(name = "user_addr_id")
	private int user_addr_id;
	
	
	@Column (name = "work_addr")
	private String work_addr = null;
	
	@Column (name = "home_addr")
	private String home_addr = null;
	
	
	
	
	@Column (name = "uid")
	private int uid;


	public User_address() {};
	public User_address(String w, String h, int uid ) {
		this.work_addr = w;
		this.home_addr = h;
		this.uid = uid;
	}



	public int getUser_addr_id() {
		return user_addr_id;
	}
	public void setUser_addr_id(int user_addr_id) {
		this.user_addr_id = user_addr_id;
	}
	public String getWork_addr() {
		return work_addr;
	}
	public String getHome_addr() {
		return home_addr;
	}
	public void setHome_addr(String home_addr) {
		this.home_addr = home_addr;
	}
	public void setWork_addr(String work_addr) {
		this.work_addr = work_addr;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	@Override
	public String toString() {
		return "User_address [user_addr_id=" + user_addr_id + ", work_addr=" + work_addr + ", home_addr=" + home_addr
				+ ", uid=" + uid + "]";
	}
	
	
}
