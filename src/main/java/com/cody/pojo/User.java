/**
* 模仿天猫整站 springboot 教程 为 how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.cody.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")		
	private int id;
	
	private String password;
	private String name;	
	private String salt;	
	
	@Transient
	private String anonymousName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalt() {
		return salt;
		
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getAnonymousName(){
		if(null!=anonymousName)
			return anonymousName;
		if(null==name)
			anonymousName= null;
		else if(name.length()<=1)
			anonymousName = "*";
		else if(name.length()==2)
			anonymousName = name.substring(0,1) +"*";
		else {
			char[] cs =name.toCharArray();
			for (int i = 1; i < cs.length-1; i++) {
				cs[i]='*';
			}
			anonymousName = new String(cs);			
		}
		return anonymousName;
	}

	public void setAnonymousName(String anonymousName) {
		this.anonymousName = anonymousName;
	}
	
	
}

/**
* 模仿天猫整站 springboot 教程 为 how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
