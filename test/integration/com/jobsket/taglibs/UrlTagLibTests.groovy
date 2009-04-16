package com.jobsket.taglibs
class UrlTagLibTests extends GroovyTestCase {

	def url
	
	void setUp() {
		url = new UrlTagLib()
    }
    void testLinkConfirmWithConfirmationMessage() {
    	assertEquals '<a href="/foo" onclick="if(confirm(\'Are you sure?\')){location.href=\'/foo\'};return false">bar</a>', url.linkConfirm(controller:"foo", confirm:"Are you sure?"){"bar"}
    }
    
    void testLinkConfirmWithoutConfirmationMessage() {
    	assertEquals '<a href="/foo">bar</a>', url.linkConfirm(controller:"foo"){"bar"}
    }
}
