

$(document).ready(function(){
 
    searchNumber();
    setEvent();

});


function setEvent(){
    $('.bookTitleClick').click(function(){

        let bookNo = $(this).data('bookno');
        window.location.href = '/books/updateBook/'+bookNo;
    
      });

}



function searchNumber(){
    $('#searchBook').click(function() {
        let bookNo = $('#searchBookNo').val();
    
        $.ajax({
            // url: `/books/${bookNo}`,
            url:'/books/allBooks',
            type: 'GET',
            async: false,
            contentType: 'application/json',  
            success: function(data) {

                if (data){

                    let str = '';
                    let bookNo = data.bookNo
                    let bookTitle = data.bookTitle
                    let bookWriter = data.bookWriter
    
                    str += '<tr>';
                    str += '<td><input type="checkbox" id="pkCheck_' + bookNo + '" class="bookCheckbox"></td>';
                    str += '<td>' + bookNo + '</td>';
                    str += '<td class="bookTitleClick" data-bookno="' + bookNo + '">' + bookTitle + '</td>';
                    str += '<td>' + bookWriter + '</td>';
                    str += '</tr>';    
              
            
                    
                }
                
                $('#searchNumber tbody').html(str);
                
            },


            error: function(XHR) {
                let errorResponse = JSON.parse(XHR.responseText);
      //          console.log(errorResponse);
                let errors = errorResponse.errors; 
            
                if (errors) {
                
                    let errorMessage = Object.values(errors).join('\n');
                    alert(errorMessage);
                } else if (errorResponse.message) {
                  
                    alert(errorResponse.message);
                } else {
                    alert("에러가 발생했습니다."); 
                }
            }
        });
    });
}









