package com.qa.payload;

public class Campaign_payload
{
	
	

	private String campaign_name;
    private String campaign_start_date;
    private int campaign_owner_user_id;
    private int group_id;
    
	public Campaign_payload(String campaign_name, String campaign_start_date, int campaign_owner_user_id,int group_id) 
	{
		
		this.campaign_name = campaign_name;
		this.campaign_start_date = campaign_start_date;
		this.campaign_owner_user_id = campaign_owner_user_id;
		this.group_id = group_id;
	}

	
	
	
	public String getCampaign_name() {
		return campaign_name;
	}




	public void setCampaign_name(String campaign_name) {
		this.campaign_name = campaign_name;
	}




	public String getCampaign_start_date() {
		return campaign_start_date;
	}




	public void setCampaign_start_date(String campaign_start_date) {
		this.campaign_start_date = campaign_start_date;
	}




	public int getCampaign_owner_user_id() {
		return campaign_owner_user_id;
	}




	public void setCampaign_owner_user_id(int campaign_owner_user_id) {
		this.campaign_owner_user_id = campaign_owner_user_id;
	}




	public int getGroup_id() {
		return group_id;
	}




	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}




	@Override
	public String toString() 
	{
		return "Campaign_payload [campaign_name=" + campaign_name + ", campaign_start_date=" + campaign_start_date
				+ ", campaign_owner_user_id=" + campaign_owner_user_id + ", group_id=" + group_id + "]";
	}
    
    
    

}
