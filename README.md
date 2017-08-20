# angular-spring-web-app

Following the tutorial of https://github.com/chrishenkel


Notes...
--------------------------------------------------------------------
Tutorial #5
- nullvalue() is working if version of jayway is 0.9 and older.
  If it is newer, then need to use doesNotExist()
  .andExpect(jsonPath("$.password", is(nullValue()))) ==> .andExpect(jsonPath("$.password").doesNotExist())


Tutorial #6
- Once 'business-config.xml' is set, in order to run AccountRepoTest like tutorial video, need to set other parts of the xml. With the same code of Video, it will return error message about 'No qualifying bean of type [javax.persistence.EntityManagerFactory] is defined'


Tutorial #7
- Using postman to test Rest API.
- It seems @Id and @GeneratedValue are shared by other entities such as account and blog


Tutorial #8
- http://localhost:8080/basic-web-app/app/index.html
- Node js, grunt-cli, bower, Angular JS
		1. Install nodejs
		2. Install grunt
			npm install -g grunt-cli
		3. Install bower
			npm install -g bower
		4. Create app folder under webapp
			C:\workspace_jee_oxy\basic-web-app\src\main\webapp
		5. Type "npm install" in app folder


Tutorial #9
- A tutorial covering ui-router, creation of a custom view and controller, and data-binding using $scope.


Tutorial #10
- covering simple session management using localStorage, creation of services using the factory method, and also some basic Angular and ui-router directives.


Tutorial #11
- bower install angular-resource @ \basic-web-app\src\main\webapp\app>
	If you are stuck with lines below,
		  "type": "input",
		  "message": "Answer",
		  "name": "prompt",
		  "level": "prompt"
	, then remove '"json": "bower.json"' on .bowerrc file

