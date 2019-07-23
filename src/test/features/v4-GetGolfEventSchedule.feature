@Regression @V4
Feature: V4 retrieve the yearly Season Golf event schedule
  Scenario: User calls web service to get yearly Season Golf event schedule
	Given a Season Golf event schedule for V4
	When a user retrieves the current V4 european-tour of this year 2019
	Then the Season Golf event european-tour schedule service returns status code is 200
	#|tourID|Year|Status|
	#|europe|2019|200|
	#|usa|2019|200|
	#|SA|2019|200|