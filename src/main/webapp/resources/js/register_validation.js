'use strict';
var $$ = function (selector) {
    return document.querySelector(selector);
};

$$('#password-confirmation').onblur = function (e) {
    if ((this.value) !== $$('#password').value) {
        this.style.borderColor = 'red';
        $$('#p-error-password').innerHTML = 'Senhas não batem.';
        e.preventDefault();
    } else {
        this.style.borderColor = 'green';
        $$('#p-error-password').innerHTML = '';
    }
};