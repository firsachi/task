 (() => {
	steActiveComponentMenuLi();	
})();
 
 function steActiveComponentMenuLi() {
	const titletext = $('head title').text();
	$("ul#componentMenu ul li:contains("+ titletext +")" ).addClass('is-active');
}