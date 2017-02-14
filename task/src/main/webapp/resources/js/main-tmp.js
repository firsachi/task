/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global room, his, department */

"use strict";

window.onload = function() {
    if(null === sessionStorage.getItem('room')){
        sessionStorage.setItem('room', room.selectedIndex);
    }
    room.selectedIndex = sessionStorage.getItem('room');
    if (null === sessionStorage.getItem('department')){
        sessionStorage.setItem('department', department.selectedIndex);
    }
    department.selectedIndex = sessionStorage.getItem('department');
    room.addEventListener('change', function() {
        sessionStorage.setItem('room', room.selectedIndex);
        displayNone();
    });
    department.addEventListener('change', function(){
        sessionStorage.setItem('department', department.selectedIndex);
        displayNone();
    });
    displayNone();
};
window.closed = function (){
    sessionStorage.clear();
};

function displayNone(){
    var array = document.getElementsByClassName('row-div');
    var roomNumber = room.options[sessionStorage.getItem('room')].text.trim();
    var departmentNumber = department.options[sessionStorage.getItem('department')].text.trim();
    for (var index = 1; index < array.length; index++){
        var roomColunm = array[index].getElementsByTagName('div')[1];
        roomColunm = roomColunm.textContent.trim();
        var departmentColumn = array[index].getElementsByTagName('div')[4];
        departmentColumn = departmentColumn.textContent.trim();
        
        if (check(roomNumber, roomColunm) && check(departmentNumber, departmentColumn)){
            array[index].style.display = 'table-row';
        }else{
            array[index].style.display = 'none';
        }
    } 
}
    
function check(valueOne, valueTwo){
    var flag = false;
    if ("All" === valueOne) {
        flag = true;
    } else if (valueOne === valueTwo) {
        flag = true;
    }
    return flag;
}


