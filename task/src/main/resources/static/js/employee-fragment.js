import {loadFragment} from "./api/ajax.js";

const parametrAjax = {
    url: '/informer/company/datalist',
    dataModel: {companyId: 0},
    setCompanyId(companyId) {
        this.dataModel.companyId = companyId;
    }
};

(() => {
    datalistDepartment();
})();

function datalistDepartment() {
    $('select#idEnterprise').change(async function(){
        parametrAjax.setCompanyId($(this).val());
        renderDatalistDepartments(await loadFragment(parametrAjax));
    }).click(function (){
        $('select#department').val('');
    });
}

function renderDatalistDepartments(dataList) {
    $('select#department').find('option').not('#departmentItem').remove();
    $('select#department > option#departmentItem').replaceWith(dataList);
}