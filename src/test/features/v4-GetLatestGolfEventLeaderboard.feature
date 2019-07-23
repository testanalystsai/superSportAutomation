@Regression @V4
Feature: V4 retrieve the yearly Season Golf event schedule
  Scenario: User calls web service to get yearly Season Golf event schedule
	Given a Latest Golf Event Leader Board for V4
	When a user retrieves the european-tour Latest Golf Event Leader Board
	Then the Latest Golf Event Leader Board for an european-tour service returns status code is 200