package com.qa.payload;

import java.util.Arrays;

public class Campaign_users_payload 
{
	
	private int[] campaign_users={0};

	public int[] getCampaign_users() {
		return campaign_users;
	}

	public void setCampaign_users(int[] campaign_users) {
		this.campaign_users = campaign_users;
	}

	@Override
	public String toString() {
		return "Campaign_users_payload [campaign_users=" + Arrays.toString(campaign_users) + "]";
	}

	public Campaign_users_payload(int[] campaign_users) {
		super();
		this.campaign_users = campaign_users;
	}

	
	
	
	
}
