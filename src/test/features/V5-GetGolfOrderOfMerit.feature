@Regression @V5
Feature: V5 retrieve the yearly Season Golf event schedule
  Scenario: User calls web service to get yearly Season Golf event schedule
	Given a Golf Order Of Merit for V5
	When a user retrieves the tour V5 european-tour Golf Order Of Merit
	Then the european-tour Golf Order Of Merit service returns status code is 200
