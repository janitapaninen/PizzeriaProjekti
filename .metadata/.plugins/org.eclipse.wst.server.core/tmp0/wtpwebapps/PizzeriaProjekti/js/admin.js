$('input[type=checkbox]').change(function(e){
   if ($('input[type=checkbox]:checked').length > 5) {
        $(this).prop('checked', false)
        alert("Max. 5 t\u00E4ytett\u00E4"); // \u00E4 ä-koodi
   }
})