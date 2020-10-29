#Author: Flaviane C. Siqueira

Feature: Test 1 API

  @teste1
  Scenario Outline: Create a account
    Given have the License Key - "452a76bab055c896b205b84f22c61530"
    When get weather with "<city>" "<state>"



    Examples:
      | city | state |
      | Round Rock |TX|
      | Tampa | TX |
      | | |