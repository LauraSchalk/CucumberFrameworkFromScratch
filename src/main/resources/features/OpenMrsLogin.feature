@smoke @regression
Feature: Testing the login functionality

  Scenario: Validating a valid login for OpenMrs
    Given User navigates to the OpenMrs website and provides credentials
    Then User validates title 'Login' and url 'https://demo.openmrs.org/openmrs/referenceapplication/login.page'


#Task: do negative tests for login functionality using scenario outline

  Scenario Outline: Testing invalid login scenarios
    Given User navigates to the OpenMrs website and provides invalid credentials '<Username>' and '<Password>'
    Then User validates the error message '<Message>'

    Examples:
      | Username | Password | Message                                      |
      |          |          | Invalid username/password. Please try again. |
      |          | Admin123 | Invalid username/password. Please try again. |
      | Admin    |          | Invalid username/password. Please try again. |
      | admin    | admin123 | Invalid username/password. Please try again. |
      | 123      | 123      | Invalid username/password. Please try again. |





