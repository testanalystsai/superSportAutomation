@Regression @V5
Feature: V5 retrieve the yearly Season Golf event schedule
  Scenario: User calls web service to get yearly Season Golf event schedule
	Given a Season Golf event schedule for V5
	When a user retrieves the current V5 european-tour of this year 2019
	Then the Season Golf event european-tour schedule service returns status code is 200
