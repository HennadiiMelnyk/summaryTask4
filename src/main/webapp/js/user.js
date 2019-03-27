function blockUser(id) {
    $.ajax({
        url: '/controller?command=block&id=' + id,
        type: 'post',
        success: function() {
            alert('user blocked');

        }
    });
}
function unlockUser(id) {
    $.ajax({
        url: '/controller?command=unlock&id=' + id,
        type: 'post',
        success: function() {
            alert('user unlocked');
        }
    });
}