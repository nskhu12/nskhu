## Overview

Create a web application in which user can register and view and edit their profile.

### Registration fields:

* Name
* Phone number
* Birthdate
* Monthly salary
* Current remaining liabilities
* Avatar (will be considered as a bonus)

When a user registers they must be shown their profile view with the information they specified during registration + allowed credit limit which should be calculated using formula :

    ageInYears * 87 + salary * 2 - liabilities * 3

For clients with age < `21` or > `75` credit limit should be `0`

Clients with age < `21` should not be able to register at all.

Clients with credit limit < 100 should not be able to register, too.

Clients also must be able to edit their profile.

## Technical requirements

Backend Platform: Spring Boot

Frontend Platform: HTML5, Bootstrap, AngularJS

RDBMS: any embedded SQL database via JPA

Project Management: Gradle (bonus) or Maven

Solution should be submitted as a link to a bitbucket or github repository which has this file as a README.

The solution should be submitted before the deadline stated in the email and it is okay to send it incomplete, just make it runnable and implement as many requirements as you can within the allocated time.

If you are willing, you can use the next day to complete the task and notify us about it before 21:00. So you have two check points 21:00 of due date and 21:00 the next day.

Additional requirements, must be implemented unless marked as '(bonus)':

* All fields must be validated
* Birthdate should only be editable once
* Tests: use JUnit or Spock (using Spock earns you bonus points)
* Application must be runnable via build system (mvn or gradle) command without any additional installations besides git and JDK.

## Bonus

Home page must show list of registered users. Users should be able to set visibility of their avatars to `public`, `registered` or `private`.

* if it's `public` it is shown in the list always
* if it's `registered` it is only shown to logged in users
* if it's `private` it is not shown to anyone except the owner themselves.
