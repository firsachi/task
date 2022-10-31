 let connectUrl = "";
 
 async function GetFragment({url, id}) {
	if (0 == id) {
		connectUrl = `${url}`;
	}
	else {
		connectUrl = `${url}/${id}`;
	};
	return await $.ajax(connectUrl);
};

async function AddRecord () {
	
}

 export {GetFragment};