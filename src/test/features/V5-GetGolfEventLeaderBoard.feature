@Regression @V5
Feature: V5 retrieve the leader board of an event
Scenario Outline: User calls web service to get leader board of an event
	Given a V5 Golf event leader board
	When a user retrieves v5 european-tour Golf Event leader board <leaderBoardID>
	Then the current european-tour leader board service returns status code is 200
	Examples:
	|leaderBoardID|
	#|2019028|
	#|2019031|
	#|2019034|
	#|2019038|
	#|2019040|
	#|2019042|
	#|2019044|
	#|2019046|
	#|2019048|
	#|2019049|
	#|2019052|
	#|2019054|
	#|2019056|
	#|2019058|
	#|2019060|
	|2019062|