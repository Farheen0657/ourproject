$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/skeleton/CaseStudy1.feature");
formatter.feature({
  "name": "CaseStudy1 Feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Inorder to add a new product to TestMeApp user has to login as admin and proceed with further steps",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "alex logged-in as admin",
  "keyword": "When "
});
formatter.match({
  "location": "caseStudyStepDefs.alex_logged_in_as_admin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he clicked on add new product",
  "keyword": "And "
});
formatter.match({
  "location": "caseStudyStepDefs.he_clicked_on_add_new_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "filled all the mandatory details and clicked on add product",
  "keyword": "And "
});
formatter.match({
  "location": "caseStudyStepDefs.filled_all_the_mandatory_details_and_clicked_on_add_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "product is added succesfully",
  "keyword": "Then "
});
formatter.match({
  "location": "caseStudyStepDefs.product_is_added_succesfully()"
});
formatter.result({
  "status": "passed"
});
});