/**
 * 
 */
"use strict";
$(document).ready(function() {
	var arrayLabel = $('form').find('label');
	var maxSizeLabel = 0;
	//find max size label
	for ( var i = 0; i < arrayLabel.length; i++){
		var tmp = $(arrayLabel[i]).width();
		if(maxSizeLabel < tmp){
			maxSizeLabel = tmp;
		}
	}
	//set max size label
	var pading = 6;
	maxSizeLabel = maxSizeLabel + pading;
	for (var i = 0; i < arrayLabel.length; i++){
		$(arrayLabel[i]).width(maxSizeLabel);
	}
});