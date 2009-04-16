package com.jobsket.taglibs
import org.springframework.web.servlet.support.RequestContextUtils

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
}