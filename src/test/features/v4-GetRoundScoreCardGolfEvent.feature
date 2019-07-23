@Regression @V4
Feature: V4 retrieve the Round Score Card- Get golf event
  Scenario Outline: User calls web service to Golf Event Round Score Card
	Given request to a Golf Event Round Score Card for V4
	When a user retrieves tour european-tour golf event round <round> score card of a leaderboard <leaderBoardID>
	Then the european-stour Golf Event Round Score Card service returns status code is 200
	Examples:
	|round|leaderBoardID|
	|1|2019060|
	#|2|2019052|
	#|3|2019062|
	#|4|2019058|
	