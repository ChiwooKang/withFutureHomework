$(document).ready(function() {

    $('#updateButton').click(function() {
        let bookNo = $('#bookNo').val();
        let bookTitle = $('#bookTitle').val();
        let bookWriter = $('#bookWriter').val();
    
        let updatedBookData = {
            bookNo: bookNo,
            bookTitle: bookTitle,
            bookWriter: bookWriter
        };
    
        $.ajax({
            url: '/books/updateBook',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(updatedBookData),
            success: function(response) {
                alert('도서 정보가 업데이트되었습니다.');
                window.location.href = "/books/allBooks"
            },
            error: function(error) {
                alert('도서 정보 업데이트에 실패했습니다.');
            }
        });
    });

   
});

// $('#updateButton').click(function() {
//     let bookNo = $('#bookNo').val();
//     let bookTitle = $('#bookTitle').val();
//     let bookWriter = $('#bookWriter').val();

//     let updatedBookData = {
//         bookNo: bookNo,
//         bookTitle: bookTitle,
//         bookWriter: bookWriter
//     };

//     $.ajax({
//         url: '/books/updateBook',
//         type: 'PUT',
//         contentType: 'application/json',
//         data: JSON.stringify(updatedBookData),
//         success: function(response) {
//             alert('도서 정보가 업데이트되었습니다.');
//             window.location.href = "/books/allBooks"
//         },
//         error: function(error) {
//             alert('도서 정보 업데이트에 실패했습니다.');
//         }
//     });
// });



// function updateBook() {
//     $('#updateBook').click(function() {
//         let bookNo = $('#bookNo').val();
//         let bookTitle = $('#bookTitle').val();
//         let bookWriter = $('#bookWriter').val();
 

//         $.ajax({
//             url: '/books',
//             type: 'PUT',
//             contentType: 'application/json',       
//             data: JSON.stringify({
//                 bookNo: bookNo,
//                 bookTitle: bookTitle,
//                 bookWriter: bookWriter
//             }),
//             success: function(response) {
//             console.log(response);
//                 alert("수정 성공");
//                 initData(); 
//             },
//             error: function(XHR) {
//                 let errorResponse = JSON.parse(XHR.responseText);
//       //          console.log(errorResponse);
//                 let errors = errorResponse.errors; 
            
//                 if (errors) {
                
//                     let errorMessage = Object.values(errors).join('\n');
//                     alert(errorMessage);
//                 } else if (errorResponse.message) {
                  
//                     alert(errorResponse.message);
//                 } else {
//                     alert("에러가 발생했습니다."); 
//                 }
//             }
//         });
//     });
// }



