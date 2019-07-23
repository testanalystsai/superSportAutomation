@Regression @V4
Feature: V4 retrieve the Golf Event Score Card
  Scenario: User calls web service to get Golf Event Score Card
	Given a Golf Event Score Card for V4
	When a user retrieves the tour european-tour Golf Event Score Card 2019054
	Then the european-tour Golf Event Score Card service returns status code is 200