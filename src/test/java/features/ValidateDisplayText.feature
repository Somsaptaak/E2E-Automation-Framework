Feature: Validate Display Text

Scenario Outline: Positive test validating Display Text
Given The browser is initialized with chrome
When User navigates to "https://www.goibibo.com/" site
Then Verify display text visible as <expectedvalue>
And close browsers 

Examples:

|expectedvalue						|
|Domestic And International Flights	|
