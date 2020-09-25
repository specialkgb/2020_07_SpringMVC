$(function () {
  $("section#book-modal").css("display", "none");

  $("#btn-save").click(function () {
    // naver로 부터 조회한 도서정보를 저장하는 까닭에
    // 유효성 검사는 일단 생략한다.
    $("form").submit();
  });

  $("#naver_search").click(function () {
    let title = $("#title").val();
    if (title === "") {
      alert("도서명을 입력한 후 검색을 하세요");
      $("#title").focus();
      return false;
    }
    // ajax를 사용하여 서버에 네이버 검색 요청
    $.ajax({
      /*
       ㅆ) ajax로 서버의 /naver/search URL에 POST로 요청을 하면서
       search_text 변수에 title 변수에 담긴 값을 담아서 전달하고
       */
      url: `${rootPath}/naver/search`,
      method: "POST",
      data: { search_text: title },
      /* 응답 결과 페이지를 전체 페이지로 보여주는것이 아니라
       #search-result div안에 보여줘라
       html방식으로 끼워넣어라
       
       T) 서버가 데이터 조회를 수행한 후 view(HTML코드)코드를
       return하면 그 결과를
       #search-result div box에 채워서 보여달라
       */
      success: function (result) {
        $("#search-result").html(result);
      },
      error: function (error) {
        alert("서버 통신 오류!!");
      },
    });

    $("section#book-modal").css("display", "block");
  });

  // x 표시를 클릭했을 때 modal 창 닫기
  $("div#modal-header span").click(function () {
    $("#book-modal").css("display", "none");
  });

  /*
 동적으로 구현 된 HTML event 핸들링 설정하기
 현재 document(HTML 문서)가 생성되는 동안에 없던 tag를
 JS(JQ)코드에서 동적으로 생성했을 경우 화면에 그려지는 것은
 아무런 문제가 없으나
 
 JS에서 event 핸들러를 설정할 때 아직 화면에 없는 tag에 연결을 하면
 무시해 버리고 없던 일로 만들어버린다.
 
 사후에(HTML 문서가 완성된 후) JS 코드로 생성할 tag(id, class)에
 event를 설정하려면 자체에  설정하지 않고
 가장 상위 객체인 document에 on  함수를 사용하여 event를 설정한다. 
 
 $(document).on("event","대상",function(){})
 
 주의사항
 
 
 */

  // $(document) 화면에 보이는 문서 전체에 evnet를 걸어버리는 것
  $(document).on("click", "div.book-select", function () {
    let isbn = $(this).data("isbn");
    // 13자리 isbn 추출
    let length = isbn.length;
    isbn = isbn.substring(length - 13);

    $.ajax({
      url: `${rootPath}/api/isbn`,
      method: "POST",
      data: { search_text: isbn },
    })
      .done(function (bookVO) {
        // alert(JSON.stringify(bookVO))
        $("#seq").val(bookVO.seq);
        $("#title").val(bookVO.title);
        $("#link").val(bookVO.link);
        $("#image").val(bookVO.image);
        $("#author").val(bookVO.author);
        $("#price").val(bookVO.price);
        $("#discount").val(bookVO.discount);
        $("#publisher").val(bookVO.publisher);

        let isbn = bookVO.isbn;
        // isbn 변수에 들어있는 문자열중에서 html tag구조를 가진 단어가 있으면 무조건 제거하라

        isbn = isbn.replace(/(<([^>]+)>)/gi, "");

        isbn = isbn.substring(isbn.length - 13);
        $("#isbn").val(isbn);

        $("#description").val(bookVO.description);
        $("#pubdate").val(bookVO.pubdate);

        $("section#book-modal").css("display", "none");
      })
      .fail(function (xhr, textStatus, error) {
        alert("서버와 통신오류!");
      });
  });
});
