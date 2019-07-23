@Regression @V4
Feature: V4 retrieve the yearly Season Golf event schedule
  Scenario Outline: User calls web service to get yearly Season Golf event schedule
	Given a Golf Player Score Card for an event for V4
	When a user retrieves the current tour V4 european-tour Golf Player <playerId> Score Card for an event <eventId>
	Then the Golf Player <playerId> Score Card for the european-tour for an event <eventId> service returns status code is 200
Examples:
|playerId|eventId|
|33676|2019060|
#|35509|2019060|
#|39075|2019060|
#|35329|2019060|
#|37549|2019060|
#|2090|2019060|
#|36932|2019060|
#|35602|2019060|
#|32111|2019060|
#|34486|2019060|
#|31183|2019060|
#|39594|2019060|
#|30503|2019060|
#|39861|2019060|