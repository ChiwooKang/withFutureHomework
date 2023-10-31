$(document).ready(function(){
    insertBook();
});

function insertBook(){
    $('#addBook').click(function() {
        let bookNo = $('#bookNo').val();
        let bookTitle = $('#bookTitle').val();
        let bookWriter = $('#bookWriter').val();
        let csrfToken = $('#csrfToken').val();

        $.ajax({
            url: '/books',
            type: 'POST',
            async: true,
            contentType: 'application/json',
            headers:{"X-CSRF-Token" :csrfToken},
            data: JSON.stringify({
                bookNo: bookNo,
                bookTitle: bookTitle,
                bookWriter: bookWriter
            }),
            success: function(data) {
           //     console.log(data);
                alert("성공");
                $('#bookForm')[0].reset();
               // initData();
               window.location.href = "/books/allBooks"
            },
            // error: function(XHR) {
            //     let errorResponse = JSON.parse(XHR.responseText);
            //     let errors = errorResponse.errors; // 오류 메시지를 포함하는 객체
            //     console.log(errorResponse)
            //     console.log(errors)

            //     if (errors) {
            //         // 모든 에러 메시지를 순회하여 하나의 문자열로 합칩니다.
            //         let errorMessage = Object.values(errors).join('\n');
            //         alert(errorMessage);
            //     } else {
            //         alert("에러가 발생했습니다."); // 기타 오류 메시지 출력
            //     }
            // }
            error: function(XHR) {
                let errorResponse = JSON.parse(XHR.responseText);
          //      console.log(errorResponse);
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