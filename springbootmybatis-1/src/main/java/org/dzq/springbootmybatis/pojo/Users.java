package org.dzq.springbootmybatis.pojo;

public class Users {
	private String username;
	private Integer age;
	private String sex;
	private Integer id;
	private String info;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", age=" + age + ", sex=" + sex + ", id=" + id + ", info=" + info
				+ ", password=" + password + "]";
	}
	
}
