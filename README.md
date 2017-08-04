# angular-spring-web-app

Following the tutorial of https://github.com/chrishenkel


Notes...
--------------------------------------------------------------------
Tutorial #5
- nullvalue() is working if version of jayway is 0.9 and older.
  If it is newer, then need to use doesNotExist()
  .andExpect(jsonPath("$.password", is(nullValue()))) ==> .andExpect(jsonPath("$.password").doesNotExist())