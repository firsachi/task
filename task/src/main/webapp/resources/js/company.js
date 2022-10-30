/**
 * 
 */
 import {GetFragment} from './connect-ajax.js';
 
 const param = {
	Url: "selectedCompany",
	Id: 0
};
 
 $(document).foundation();
 
 const fun = SetClickButtonDelete();
 function SetClickButtonDelete () {
	$(`ul.menu.vertical > li > a[data-open][data-company-id]`).on(`click`, async function(){
		param.Id = $(this).data('companyId');
		const fragment = await GetFragment(param);
		var modal = $('#deleteRecord');
		modal.html(fragment);
	});
};

