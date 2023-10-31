// $(document).ready(function(){

    
//     initData();
//     insertBook();
//     deleteBook();
//     updateBook();
//    // form();

// });

// function initData(){

//     let str = '';

//     $.ajax({
//         url: '/books', 
//         type: 'GET',
//         async: true,
//         success: function(data) {
//             console.log("data",data);
//             data.forEach(function(el, index) {
               
//                 let bookID = el.bookID
//                 // let bookNo = el.bookID;
//                 // let bookTitle = el.bookID;
//                 let bookTitle = el.bookTitle;
//                 let bookWriter = el.bookWriter;

//                 str += '<tr>'
//                 str += '<td>'+ bookID.bookNo +'</td>'
//                 str += '<td>'+ bookTitle +'</td>'
//                 str += '<td>'+ bookWriter +'</td>'
//                 str += '</tr>'
                
              
//             });

//             $("table tbody").html(str);
//         },
//         error: function(error) {
//             console.error("Error during the AJAX request:", error);
//         }
//     });
    

// }

// // function insertBook(){

// //     $('#addBook').click(function(e){

// //         e.preventDefault();
        
// //         let bookNo = $('#bookNo').val();
// //         let bookTitle = $('#bookTitle').val();
// //         let bookWriter = $('#bookWriter').val();

// //         $.ajax({

// //             url:'/books',
// //             type : 'POST',
// //             async : true,
// //             contentType : 'application/json',
// //             data : JSON.stringify({
// //                 bookID : {
// //                     bookNo : bookNo,
// //                     bookTitle : bookTitle
// //                 },
// //                 bookWriter : bookWriter

// //             }),

// //             success : function(response){

// //                 console.log(response);
// //                 alert("성공");
// //                 $('#bookForm')[0].reset();
// //             },

// //             error: function(error){
// //                 alert('에러',error);
// //             }


// //         });

       

// //     });

// // }

// // function deleteBook() {

// //     $('#deleteBook').click(function(e){

// //         e.preventDefault();

// //         let bookNo = $('#bookNo').val();
// //         let bookTitle = $('bookTitle').val();

// //         $.ajax({

// //             url:'/books',
// //             type: 'DELETE',
// //             async : true,
// //             contentType : 'application,json',
// //             success : function(data){

// //                 console.log(data);
// //                 $('#bookForm')[0].reset();
// //             },

// //             error: function(error){
// //                 alert('삭제중에러',error);
// //             }

            
        
// //         });

// //     });



// // }

// function insertBook(){
    
//     $('#addBook').click(function() {
//         let bookNo = $('#bookNo').val();
//         let bookTitle = $('#bookTitle').val();
//         let bookWriter = $('#bookWriter').val();

//         $.ajax({
//             url: '/books',
//             type: 'POST',
//             async: true,
//             contentType: 'application/json',
//             data: JSON.stringify({
//                 bookID: {
//                     bookNo: bookNo,
//                 },
//                 bookTitle: bookTitle,
//                 bookWriter: bookWriter
//             }),
//             success: function(data) {
//                 console.log(data);
//                 alert("성공");
//                 $('#bookForm')[0].reset();
//                 initData();
//             },
//             error: function(error) {
//                 alert('삽입 중 에러', error);
//             }
//         });
//     });
// }

// function deleteBook(){

//     $('#deleteBook').click(function() {
//         let bookNo = $('#bookNo').val();
//        // let bookTitle = $('#bookTitle').val();
    
//         $.ajax({
//             url: `/books/${bookNo}`, 
//             type: 'DELETE',
//             async: true,
//             contentType: 'application/json',  
//             success: function(data) {
//                 console.log(data);
//                 alert("삭제성공")
//                 $('#bookForm')[0].reset();
//                 initData();
//             },
//             error: function(error) {
//                 alert('삭제 중 에러', error);
//             }
//         });
//     });

// } 


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
//                 bookID: {
//                     bookNo: bookNo,
//                 },
//                 bookTitle: bookTitle,
//                 bookWriter: bookWriter
//             }),
//             success: function(response) {
//                 console.log(response);
//                 alert("수정 성공");
//                // $('#bookForm')[0].reset();
//                 initData(); 
//             },
//             error: function(error) {
//                 alert('수정 중 에러', error);
//             }
//         });
//     });
// }


$(document).ready(function(){
    let urlParams = new URLSearchParams(window.location.search);
    let selectedLanguage = urlParams.get('lang') || 'ko';
    $("#languageSelect").val(selectedLanguage);

    initData();
    deleteBook();
    searchNumber();
    setEvent();
    
    
});

function setEvent() {

    // $('#searchBook').click(function() {
    //     window.location.href = '/books/searchNumber';
    // });


    $("#languageSelect").on('change', function() {
        let selectedLanguage = $(this).val();
        window.location.href = window.location.pathname + "?lang=" + selectedLanguage;
   });

   checkbox();

   $('#addBook').click(function(){

    window.location.href = '/books/insertBook'

   });

   $('.bookTitleClick').click(function(){

    let bookNo = $(this).data('bookno');
    window.location.href = '/books/detail/'+bookNo;

  });


//   $('.bookTitleClick').click(function(){

//     let bookNo = $(this).data('bookno');
//     window.location.href = '/books/updateBook/'+bookNo;

//   });




}




function initData() {
    
    let str = '';
  

    $.ajax({
        url: '/books', 
        type: 'GET',
        async: false,
        success: function(data) {
     
            data.forEach(function(el, index) {
                let bookNo = el.bookNo;
                let bookTitle = el.bookTitle;
                let bookWriter = el.bookWriter;

                str += '<tr>';
                str += '<td><input type="checkbox" id="pkCheck_' + bookNo + '" class="bookCheckbox"></td>';
                str += '<td>' + bookNo + '</td>';
                str += '<td class="bookTitleClick" data-bookno="' + bookNo + '">' + bookTitle + '</td>';
                str += '<td>' + bookWriter + '</td>';
                str += '</tr>';    
                
            });
            $("#searchAll tbody").html(str);
            
        },
        error: function(error) {
            console.error("Error during the AJAX request:", error);
        }
    });

}



function deleteBook() {
    $('#deleteBook').click(function() {
        let selectedBooks = [];
        $('.bookCheckbox:checked').each(function() {
            let checkboxId = $(this).attr('id');
            let bookNo = checkboxId.split('_')[1];
            selectedBooks.push(bookNo);
        });

        if (selectedBooks.length === 0) {
            alert("삭제할 책을 선택해주세요.");
            return;
        } else if (selectedBooks.length > 1) {
            alert("한 번에 하나의 책만 삭제할 수 있습니다.");
            return;
        }

        let bookNo = selectedBooks[0];  // 첫 번째로 체크된 책의 번호만 사용

        $.ajax({
            url: `/books/${bookNo}`, 
            type: 'DELETE',
            async: true,
            contentType: 'application/json',
            success: function(data) {
                alert("삭제성공");
                $('#bookForm')[0].reset();
                initData();
            },
            error: function(XHR) {
                let errorResponse = JSON.parse(XHR.responseText);
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



function searchNumber(){
    $('#searchBook').click(function() {
        let bookNo = $('#searchBookNo').val();
    
        $.ajax({
            url: `/books/${bookNo}`,
          //  url:'/books/allBooks',
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





function checkbox(){

    $('.bookCheckbox').on('click',function(){
 

        if($(this).is(':checked')){

       
            let checkboxId = $(this).attr('id');
            let bookNo = checkboxId.split('_')[1];
            let bookTitle = $(this).closest('tr').find('td:nth-child(3)').text();
            let bookWriter = $(this).closest('tr').find('td:nth-child(4)').text();

            console.log(checkboxId, bookNo, bookTitle, bookWriter);

            displayBookInfo({
                bookNo: bookNo,
                bookTitle: bookTitle,
                bookWriter: bookWriter
            });
        }

    });
}


function displayBookInfo(bookInfo) {
    $("#bookNo").val(bookInfo.bookNo);
    $("#bookTitle").val(bookInfo.bookTitle);
    $("#bookWriter").val(bookInfo.bookWriter);
}







