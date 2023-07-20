 (() => {
	steActiveComponentMenuLi();	
})();
 
 function steActiveComponentMenuLi() {
	const titletext = $('head title').text();
	$("ul#componentMenu li:contains("+ titletext +")" ).addClass('is-active');
}