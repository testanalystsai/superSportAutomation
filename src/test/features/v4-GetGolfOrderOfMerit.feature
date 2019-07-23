@Regression @V4
Feature: V4 retrieve the yearly Season Golf event schedule
  Scenario: User calls web service to get yearly Season Golf event schedule
	Given a Golf Order Of Merit for V4
	When a user retrieves the tour V4 european-tour Golf Order Of Merit
	Then the european-tour Golf Order Of Merit service returns status code is 200
