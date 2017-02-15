"use strict";
window.onload = function (){
	var title = document.getElementsByTagName('title')[0];
	var link = document.getElementById('menu').getElementsByTagName('a');
	for (var index = 1; index < link.length; index++){
		if (title.text === link[index].text){
			link[index].classList.add('select');
			break;
		}
	}
};