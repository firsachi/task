/**
 * 
 */
 async function GetFragment({Url, Id}) {
	const connectUrl = `${Url}\/${Id}`;
	return await $.ajax(connectUrl);
};
 export {GetFragment};