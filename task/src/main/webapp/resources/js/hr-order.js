/**
 * 
 */
(() => {
	$(document).foundation();
})();

let $modal = $('#modalAddEmployee');

$.ajax('/url')
  .done(function(resp){
    $modal.html(resp).foundation('open');
});

$(document).on('open.zf.reveal', "#modalAddEmployee", function (e) {
  var $modal = $(this);
  var ajax_url = $modal.data("ajax-url");
  if (ajax_url) {
    $modal.html("Now Loading: "+ajax_url);
    $.ajax(ajax_url).done(function (response) {
      $modal.html(response);
    });
  }
});