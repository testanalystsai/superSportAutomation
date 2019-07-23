@Regression @V4
Feature: V4 retrieve the current tour schedule
  Scenario: User calls web service to get european tour schedule
	Given a Golf event schedule by current season for V4
	When a user retrieves the current V4 european-tour schedule details
	Then the current european-tour schedule service returns status code is 200