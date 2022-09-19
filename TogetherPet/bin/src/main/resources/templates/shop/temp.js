document.addEventListener('DOMContentLoaded', function () {
    console.log($('#tb').html())
    
    $('#tb').on('click', '.clickTr', function(){
        alert('trclick!');
    })

})