/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global room, his */

"use strict";

window.onload = function() {
    room.addEventListener('change', function() {
        this.options[his.selectedIndex].text;
        console.log(this.options[his.selectedIndex].text);
    });
};



function displayNone(){
    var array = document.getElementsByClassName('row-div');
    for (var index = 1; index < array.length; index++){
        array[index].style.display = 'table-row';
        var tmp = array[index].getElementsByTagName('div')[1];
        if ("210" !== tmp.textContent){
            array[index].style.display = 'none';
        }
    }
}
