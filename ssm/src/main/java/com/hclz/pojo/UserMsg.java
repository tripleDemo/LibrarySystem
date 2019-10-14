package com.hclz.pojo;

public class UserMsg {
    private Integer userId;

    private String userName;

    private String password;

    private Boolean type;
    
    public UserMsg() {
		super();
	}

	public UserMsg(String userName, String password, Boolean type) {
		super();
		this.userName = userName;
		this.password = password;
		this.type = type;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

	@Override
	public String toString() {
		return "UserMsg [userId=" + userId + ", userName=" + userName + ", password=" + password + ", type=" + type
				+ "]";
	}
    
}