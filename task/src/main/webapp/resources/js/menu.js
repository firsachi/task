 (() => {
	steActiveComponentMenuLi();	
})();
 
 function steActiveComponentMenuLi() {
	const titletext = $('title').text();
	$("ul#componentMenu li:contains("+ titletext +")" ).addClass('is-active');
}