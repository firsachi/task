 async function GetFragment({url, id}) {
	const connectUrl = `${url}/${id}`;
	return await $.ajax(connectUrl);
};
 export {GetFragment};