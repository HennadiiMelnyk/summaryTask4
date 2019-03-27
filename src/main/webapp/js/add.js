function addToCart(id){
    $.ajax({
        url: '/cart?command=addToCart&id=' + id,
        type: 'post',
        success: function() {
            alert('Item with id='+id+' successfully added');
        }
    });
}