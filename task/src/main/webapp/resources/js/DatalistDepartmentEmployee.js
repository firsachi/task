(() => {
    setStartDatalist().then(r =>{
        console.log(r)
    } );
    datalistDepartment();
})();

async function setStartDatalist () {
    let selectedCompanyId = $('select#idEnterprise option:selected').val();
    renderDatalistDepartments(await datalistFragmentHTML(selectedCompanyId));
}

function datalistDepartment() {

    $('select#idEnterprise').change(async function(){
        let enterpriseId = $(this).val();
        renderDatalistDepartments(await datalistFragmentHTML(enterpriseId));
    }).click(function (){
        $('input#department[name=department]').val('');
    });
}

function renderDatalistDepartments(dataList) {
    $('datalist#departmentsList').replaceWith(dataList);
}

async function datalistFragmentHTML (companyId) {
    return $.post('/informer/company/datalist', {companyId: companyId});
}