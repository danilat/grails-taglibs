package com.jobsket.taglibs
import org.springframework.web.servlet.support.RequestContextUtils
import org.codehaus.groovy.grails.web.pages.GroovyPagesTemplateEngine

class CommonsTagLib {
	
	private currentLocale(){
		RequestContextUtils.getLocale(request)
	}
	
	def currentLang={ attrs, body ->
		def locale = currentLocale()
		def lang = locale.getLanguage() 
		out << lang
	}
	
	def currentCountry={ attrs, body ->
		def locale = currentLocale()
		def country = locale.getCountry()?.toLowerCase()
		out << country
	}
	
	def renderByCurrentLang={attrs, body ->
		if(!attrs.template){
	        throwTagError("Tag [render] is missing required attribute [template]")
		}
		def paramsMap = attrs
		def template = attrs.template + "_" + currentLang()
		
	    def engine = groovyPagesTemplateEngine
	    
	    def uri = grailsAttributes.getTemplateUri(template,request)
	    def contextPath = attrs.contextPath ? attrs.contextPath : ""
	    def r = engine.getResourceForUri("${contextPath}${uri}")
	    if(r.exists()){
	    	paramsMap.template = template
	    }
		out << render(paramsMap)
	}
}