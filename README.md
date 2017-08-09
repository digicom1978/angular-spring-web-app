# angular-spring-web-app

Following the tutorial of https://github.com/chrishenkel


Notes...
--------------------------------------------------------------------
Tutorial #5
- nullvalue() is working if version of jayway is 0.9 and older.
  If it is newer, then need to use doesNotExist()
  .andExpect(jsonPath("$.password", is(nullValue()))) ==> .andExpect(jsonPath("$.password").doesNotExist())


Tutorial #6
- Once 'business-config.xml' is set, in order to run AccountRepoTest like tutorial video, need to set other parts of the xml. With the same code of Video, it wiil return error message about 'No qualifying bean of type [javax.persistence.EntityManagerFactory] is defined'

