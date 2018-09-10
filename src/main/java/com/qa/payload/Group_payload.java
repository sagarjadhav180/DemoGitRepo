package com.qa.payload;

public class Group_payload

{
	
	 private String group_name;
	 private int group_parent_id;
	 private String industry_name;
	
	public Group_payload( String group_name,int group_parent_id,String industry_name)
	{
		this.group_name= group_name;
		this.group_parent_id= group_parent_id;
		this.industry_name=industry_name;
		
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public int getGroup_parent_id() {
		return group_parent_id;
	}

	public void setGroup_parent_id(int group_parent_id) {
		this.group_parent_id = group_parent_id;
	}

	public String getIndustry_name() {
		return industry_name;
	}

	public void setIndustry_name(String industry_name) {
		this.industry_name = industry_name;
	}

	@Override
	public String toString() {
		return "Group_payload [group_name=" + group_name + ", group_parent_id=" + group_parent_id + ", industry_name="
				+ industry_name + "]";
	}
	
	
	

}
