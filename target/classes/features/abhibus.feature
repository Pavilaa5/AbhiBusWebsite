Feature: Book Bus Ticket on AbhiBus Website

  Scenario: Book a bus from Bangalore to Coimbatore
    Given I open the AbhiBus website
    And I select Bangalore as the from station
    And I select Coimbatore as the to station
    And I select travel date
    When I click on the Search button
    Then I should be redirected to the AbhiBus search results page
    And I should see the AbhiBus logo on the page
    And I select the seat
    And I select Majestic as the boarding point
    #And I select Thudiyalur as the dropping point
    And I select choose seat
    And I Enter name
    And I Enter gender
    And I Enter number
    And I Enter email
    #Then I should be on the payment details page
