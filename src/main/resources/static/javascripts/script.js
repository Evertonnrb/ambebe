$(function () {
    let decimal = $('.js-decimal')
    decimal.maskMoney({decimal:',',thousands:'.'})
    let plain = $('.js-plain')
    plain.maskMoney({precision:0,thousands:'.' })
});