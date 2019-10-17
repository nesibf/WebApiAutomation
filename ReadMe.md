### Assignment:
1) Check the response of the GET method:
http://ec2-3-15-24-92.us-east-2.compute.amazonaws.com:3030/services

2) Based on the web API above, implement a new project with Automated API Test Cases.
	Preferably in Java, but any other programming language would also fine
	Any framework, library can be used

3) Go to Jenkins:
http://ec2-3-15-24-92.us-east-2.compute.amazonaws.com:8080/
Create a New Item.
That project should do the following:
	Trigger and execute the Automated Tests, created in the 2nd step
	After the execution, publish the Test Execution Report (preferably Allure Reports)

### Jenkins credentials
	username: adminfn
	password: Rij35!0v0

### Execution
- clone the project from the repository
- open in IntelliJ
- run via IntelliJ by selecting "verify" in Maven Projects
- run via cmd by typing: mvn clean verify
