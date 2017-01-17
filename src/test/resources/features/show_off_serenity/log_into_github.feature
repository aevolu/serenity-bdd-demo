#language en
@current
Feature: To show off serenity bdd

  In order to show people that we really know our tools
  as software craftsman
  I want to log into Github

  Scenario: Show repositories
    Given that aevolu has created a repository 'codefreeze.fi'
     When he lists all the repositories
     Then codefreeze.fi repository is shown in the repository lists
