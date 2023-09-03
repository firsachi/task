async function loadFragment (ajaxParametr) {
    return $.post(ajaxParametr.url, ajaxParametr.dataModel);
}

export {loadFragment};