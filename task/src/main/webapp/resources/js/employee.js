 import {GetFragment} from './connect-ajax.js';
 
 const param = {
	url: "selectedEmployee",
	id: 0
};
 
(() => {
	$(document).foundation();
	SetClickButtonDelete()
})();

function SetClickButtonDelete(){
	$(`ul.menu.vertical > li > a[data-open][data-employee-id]`).on(`click`, async function () {
		param.id = $(this).data('employeeId');
		$('#deleteRecord').html(await GetFragment(param));
	});
};