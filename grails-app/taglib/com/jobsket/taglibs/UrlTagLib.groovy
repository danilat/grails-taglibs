package com.jobsket.taglibs

class UrlTagLib {
	def linkConfirm={attrs, body ->
		def link = createLink(attrs).encodeAsHTML()
		def confirm = attrs.remove("confirm")
		if(confirm!=null){
			attrs.put("onclick", "if(confirm('${confirm}')){location.href='${link}'};return false")
		}
		def writer = out
	    writer << '<a href="'
	    writer << link
	    writer << '"'
	    // process remaining attributes
	    attrs.each { k,v ->
	        writer << " $k=\"$v\""
	    }
	    writer << '>'
	    // output the body
	    writer << body()
	    // close tag
	    writer << '</a>'
	
	}
}
