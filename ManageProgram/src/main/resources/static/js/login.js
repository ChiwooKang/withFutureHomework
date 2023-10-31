
// $(document).ready(function() {
//     $("#loginBtn").on("click", function(event) {
//         let formData = {
//             username: $("#username").val(),
//             password: $("#password").val()
//         };

//         $.ajax({
//             type: "POST",
//             url: "/books/login",
//             data: JSON.stringify(formData),
//             contentType: "application/json",
//             success: function(response) {
//                 // 로그인 성공시 처리 (예: 페이지 리다이렉트)
//                 window.location.href = "/books/allBooks";
//             }, 
//             error: function(error) {
//                 // 로그인 실패시 처리 (예: 에러 메시지 표시)
//                 if (error.responseJSON && error.responseJSON.message) {
//                     $(".error").text(error.responseJSON.message).show();
//                 } else {
//                     $(".error").text("로그인 중 오류 발생").show();
//                 }
//                 console.log(error.responseText);
//             }
//         });
//     });
// });


// $(document).ready(function() {
//     $("#loginForm").on("submit", function(event) {
//         event.preventDefault();

//         let formData = {
//             username: $("#username").val(),
//             password: $("#password").val()
//         };

//         $.ajax({
//             type: "POST",
//             url:  "/books/login", 
//             data: JSON.stringify(formData),
//             contentType: "application/json",
//             success: function(response) {
//                 // 로그인 성공시 처리 (예: 페이지 리다이렉트)
//                 window.location.href = "/books/allBooks";
//             },
//             error: function(error) {
//                 // 로그인 실패시 처리 (예: 에러 메시지 표시)
//                 $(".error").show();
//                 console.log(error.responseText);

//             }
//         });
//     });
// });

