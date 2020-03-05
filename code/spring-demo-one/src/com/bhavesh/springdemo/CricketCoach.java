package com.bhavesh.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// add new fields for emailAddress and Team
	private String emailAddress;
	private String team;
	
	public String getEmailAddress() {
		System.out.println("CricketCoach: inside getter method getEmailAddress of CricketCoach");
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method setEmailAddress of CricketCoach");
		this.emailAddress = emailAddress;
	}


	public String getTeam() {
		System.out.println("CricketCoach: inside getter method setTeam of CricketCoach");
		return team;
	}


	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method setTeam of CricketCoach");
		this.team = team;
	}


	// create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor of CricketCoach");
	}
	
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method setFortuneService of CricketCoach");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "practice fast bowling for 15 minutes a day";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
