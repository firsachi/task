import {loadFragment} from "./api/ajax.js";

(() => {
    datalistDepartment();
})();

function datalistDepartment() {

    $('select#idEnterprise').change(async function(){
        let enterpriseId = $(this).val();
        const departmentPerametrAjax = {
            url: '/informer/company/datalist',
            dataModel: {companyId: enterpriseId}
        };
        renderDatalistDepartments(await loadFragment(departmentPerametrAjax));
    }).click(function (){
        $('input#department[name=department]').val('');
    });
}

function renderDatalistDepartments(dataList) {
    $('datalist#departmentsList').replaceWith(dataList);
}