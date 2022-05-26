function searchBlog() {
    let authorName = $("#searchValue").val();
    $.ajax({
        url: "http://localhost:8080/api/blogs/searchAuthor",
        data: {
            nameAuthor: authorName
        },
        type: 'get',
        dataType: "json",
        success: function (response) {
            let result = '';
            for (let i = 0; i < response.length; i++) {
                result += `
                    <tr>
                        <td>${response[i].id}</td>
                        <td>${response[i].title}</td>
                        <td>${response[i].content}</td>
                        <td>${response[i].author}</td>
                        <td>${response[i].postDate}</td>
                        <td>${response[i].category.name}</td>                     
                    </tr>
                `;

                // result += "<tr>"
                //     + "<td>"+ response[i].subjectId + "</td>"
            }
            $("#result").html(result);

        },
        error: function (e) {
        }
    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}