Feature: Validating usersAPI
Scenario Outline: Verify if USER is being successfully added using usersAPI

Given Add users payload "<name>"
When userAPI calls users with post http request
Then the userAPI call is success with status code 201
And Then test 'name' is 'Shivani'
And Then test 'job' is 'SDET'

Examples:
|name|
|Shivani|
 