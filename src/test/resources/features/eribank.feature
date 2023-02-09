Feature: EriBank
  As a user of EriBank,
  I want to login into my account,
  So I can check my balance

  Scenario Outline: Login and check
    Given Juan access to the app
    When He accesses to my account with my credentials
      | data   |
      | <data> |
    Then He is able to check my actual balance
      | message   |
      | <message> |
    Examples:
      | data    | message                  |
      | company | Your balance is: 100.00$ |