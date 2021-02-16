$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Test/NavigateToURL.feature");
formatter.feature({
  "name": "Navigating to URL",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Navigate to URL",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test_page"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to URL",
  "keyword": "Given "
});
formatter.match({
  "location": "TestPageSteps.aUserNavigatesToURL()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});