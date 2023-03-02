# Test Case Management Project
 
## Description
The Project will allow testers to create, edit, and delete test cases, as well as view all test cases and search for specific test cases.
## Installations:
* Java JDK
* Gradle
* Git
## Used Dependencies:
* TestNg
## Information About Project:
### Logic Code (Dev)
#### 1.TestCase Creator
      Create Test Case with details like
       1. Name (It should be mandatory and unique)
       2. Description
       3. Steps to reproduce
#### 2.TestCase Finder
       Find particular TestCase in TestSuite with test Case name
#### 3.TestCase Editor
       Edit the test case with new name,new description and steps to reproduce
#### 4.TestCase Remover
       Remove the testCase from the TestSuite
#### 5.TestCase Viewer
       Viewing or Displaying Particular TestCase Details
#### 6.TestSuite
       It Store all the testCases with its related details 
#### 7.TestCase Validator
       It Validate that testCase name is unique and not exist any testcase with this name in TestSuite
### Tests (Tester)
#### 1.TestCaseTest
      It Contains All the TestCase Related Tests like
       1.  userShouldBeAbleToCreateTest()
       2.  userShouldNotAbleToCreateTestWithEmptyValue()
       3.  userShouldNotAbleToCreateTestWithNullValue()
       4.  userShouldNotAbleToEditTestCaseWithNullAsNewName()
       5.  userShouldNotAbleToEditTestCaseWithEmptyName()
#### 2.TestSuiteTest
      It Contains All the TestSuite Related Tests
       1.  userShouldNotAbleToCreateNewTestCaseWithDuplicateName()
       2.  userIsNotAbleToGiveNotExistingTestCaseName()
       3.  checkEditedDetails()
       4.  userShouldNotProvideDuplicateNewNameWhileEditing()
       5. userShouldProvideValidTestCaseNameToDelete()
       6. checkDeletedTestCase()
       7. viewAllTestCasesInOrder()
       8. searchTestwithValidTestName()
        

# Authors
_**poojitha**
       
