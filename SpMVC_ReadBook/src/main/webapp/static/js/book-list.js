$(function () {
  $("td.book-title").click(function () {
    let seq = $(this).data("seq");

    // path Varriable 방식
    document.location.href = `${rootPath}/books/detail/${seq}`;
  });
});
