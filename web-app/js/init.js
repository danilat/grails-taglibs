$(document.body).observe("click", function(event) {
	var element = event.findElement("a['data-confirm']");
	if (element) {
		if(confirm(element.readAttribute("data-confirm"))){
			location.href = element.readAttribute("data-confirm");
		}else{
			event.stop();
		}
	}
});