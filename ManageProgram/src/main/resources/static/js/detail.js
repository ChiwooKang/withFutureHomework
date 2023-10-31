

$(document).ready(function(){
 
    
    setEvent();

});


function setEvent() {
    $('#updateButton').click(function() {
        let bookNo = $(this).data('bookno');  // 버튼의 data-bookno 속성에서 값을 가져옵니다.
        window.location.href = '/books/updateBook/' + bookNo;  // 해당 URL로 리디렉션합니다.
    });
}











