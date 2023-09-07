import {loadFragment} from "./api/ajax.js";

const parametrAjax = {
    url: '/informer/company/datalist',
    dataModel: {companyId: 0},
    setCompanyId(companyId) {
        this.dataModel.companyId = companyId;
    }
};

(async () => {
    await setStartDatalist();
    datalistDepartment();
})();

async function setStartDatalist () {
    let companyId = $('select#idEnterprise option:selected').val();
    if ('0' !== companyId) {
        parametrAjax.setCompanyId(companyId);
        renderDatalistDepartments(await loadFragment(parametrAjax));
    }
}

function datalistDepartment() {
    $('select#idEnterprise').change(async function(){
        parametrAjax.setCompanyId($(this).val());
        renderDatalistDepartments(await loadFragment(parametrAjax));
    }).click(function (){
        $('input#department[name=department]').val('');
    });
}

function renderDatalistDepartments(dataList) {
    $('datalist#departmentsList').replaceWith(dataList);
}