function removeFromCart(id){
    $.ajax({
        url: '/cart?command=removeById&id=' + id,
        type: 'post',
        success: function(){
            $('#'+id).remove();
        }
    });
}
