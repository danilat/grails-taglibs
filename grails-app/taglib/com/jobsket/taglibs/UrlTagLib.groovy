package com.jobsket.taglibs

class UrlTagLib {
	def linkConfirm={attrs, body ->
		def link = createLink(attrs).encodeAsHTML()
		def confirm = attrs.remove("confirm")
		if(confirm!=null){
			attrs.put("onclick", "if(confirm('${confirm}')){location.href='${link}'};return false")
		}
	    out << '<a href="'
	    out << link
	    out << '"'
	    // process remaining attributes
	    attrs.each { k,v ->
	    	out << " $k=\"$v\""
	    }
	    out << '>'
	    // output the body
	    out << body()
	    // close tag
	    out << '</a>'
	}
}
