package com.regres.testdata.DB;

public class CommunityDBRepo {
	public static CommunityDB getCommunity1() {
		return new CommunityDB("Ukraine");
	}
	
	public static CommunityDB getInvalidCommunity() {
		return new CommunityDB("Valgalla");
	}
}
