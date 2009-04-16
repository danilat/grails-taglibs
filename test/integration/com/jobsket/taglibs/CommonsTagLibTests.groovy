package com.jobsket.taglibs
class CommonsTagLibTests extends GroovyTestCase {
	
	def commons
	
	void setUp() {
        commons = new CommonsTagLib()
        commons.request.addPreferredLocale(Locale.US)
    }
	
	void testCurrentLang(){
		assertEquals "en",commons.currentLang()
	}
	
	void testCurrentCountry(){
		assertEquals "us",commons.currentCountry()
	}
}
