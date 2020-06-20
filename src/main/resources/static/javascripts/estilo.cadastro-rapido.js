$(function () {
    const modal = $('#modalCadastroRapido')
    const btnSalvar = modal.find('.js-modal-cadastro-rapido-btn-salvar')
    const form = modal.find('form')
    const url = form.attr('action')
    const inputNomeEstilo = $('#nomeEstilo')
    const caixaMsgErro = $('.js-msg-cadastro-rapido')

    modal.on('shown.bs.modal',onModalShow)
    modal.on('hide.bs.modal',onModalClose)
    btnSalvar.on('click',onBtnSalvarClick)
    form.on('submit',(event)=>(event.preventDefault()))

    function onModalShow(){
            inputNomeEstilo.focus()
    }

    function onModalClose(){
        inputNomeEstilo.val('')
        caixaMsgErro.addClass('hidden')
        form.find('.form-group').removeClass('has-error')
    }

    function onErroSalvandoEstilo(obj) {
        console.log(arguments)
        let msgErro = obj.responseText
        caixaMsgErro.removeClass('hidden')
        caixaMsgErro.html('<span>'+msgErro+'</span>')
        form.find('.form-group').addClass('has-error')
    }

    function onEstilosSalvo(estilo) {
        console.log(arguments)
        let comboEstilo = $('#estilo')
        comboEstilo.append('<option value='+estilo.codigo+'>'+estilo.nome+ '</option>')
        comboEstilo.val(estilo.codigo)
        modal.modal('hide')
    }
    
    function onBtnSalvarClick(){
        let nomeEstilo = inputNomeEstilo.val().trim()
        $.ajax({
            url:url,
            method:'POST',
            contentType:'application/json',
            data:JSON.stringify({nome:nomeEstilo}),
            error:onErroSalvandoEstilo,
            success:onEstilosSalvo
        })
    }

})