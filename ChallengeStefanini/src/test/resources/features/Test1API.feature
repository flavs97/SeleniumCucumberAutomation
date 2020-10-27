#Author: Flaviane C. Siqueira

Feature: Test 1 API

@teste1
Scenario: Create a account
  Given open url - Interzoid
  When click register
  And fill in the required data
  And fill in the optional data
  And finish registration