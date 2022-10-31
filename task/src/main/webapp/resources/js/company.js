import {GetFragment} from './connect-ajax.js';
 
const param = {
	url: "selectedCompany",
	id: 0
};
 
 $(document).foundation();
 
(() => {
	SetClickButtonDelete();	
})();

function SetClickButtonDelete(){
	$(`ul.menu.vertical > li > a[data-open][data-company-id]`).on(`click`, async function () {
		param.id = $(this).data('companyId');
		$('#deleteRecord').html(await GetFragment(param));
	});
};