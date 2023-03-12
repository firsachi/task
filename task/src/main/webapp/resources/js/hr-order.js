/**
 * 
 */
(() => {
	$(document).foundation();
	openModalform();
})();

function openModalform() {
	$(document).on('open.zf.reveal', "#modalAddEmployee", function(e) {
		let modal = $(this);
		let ajax_url = modal.data("ajax-url");
		if (ajax_url) {
			modal.html("Now Loading: " + ajax_url);
			$.ajax(ajax_url).done(function (response) {
				modal.html(response);
				submitFomAddEmoloyee();
			});
		}
	});
};

function submitFomAddEmoloyee() {
	
	$('button.float-right').click(function(){
		let tableEmployee = $('table#tableEmployee tbody');
		const employee ={
			id: $('select#idEmployee').val()
		};
		$.ajax({
			type: "POST",
			url: "newrow",
			data: employee,
			dataType: "html",
			encode: true,
			success: function (data){
				tableEmployee.append(data);
			}
		});
		$('#modalAddEmployee').foundation('close');
	});
};
