package com.bhavesh.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}

	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: " + fortuneService.getFortune();
	}
	
	// Add Bean Init Method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	// Add Bean Destroy Method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside method doMyCleanupStuff");
	}

}
