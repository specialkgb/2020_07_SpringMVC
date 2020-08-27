$(function () {
  function getPCode() {
    $.ajax({
      type: "GET",
      url: `${rootPath}/api/product/get_pcode`,
      success: function (result) {
        $("#p_code").val(result);
      },
    });
  }

  $("#p_code_gen").click(getPCode);

  $("#btn_save").click(function () {
    /**
     * js 변수선언 키워드
     * var, let, const
     * var : public 전역변수 선언, 함수와 함수간에 데이터를 공유
     * let : 함수(function) scope형 변수 한번 선언되면 그 변수는 다시 선언 할 수없다.
     * const : 상수 키워드 값이 한번 저장되면 그값은 변경 할 수 없다.
     * ES6(ESCMA2015) 이상의 js 에서는 변수는 선언할때
     * 코드 중간에 값을 변경 해야할 필요가 없으면 const 함수 내에서 변수를 선언할때는 let
     *
     * 특별히 public scope 로 선언할때는 var
     * 순서는 const 를 먼저 고려, let, var 순으로 생각하자
     * 가급적 var는 자제할것
     * */
    var p_code = $("#p_code").val();
    var p_name = $("#p_name").val();
    if (p_code == "") {
      if (confirm("상품코드는 반드시 필요합니다.\n상품코드를 생성할까요?")) {
        getPCode();
      }
      return false;
    }
    if (p_name == "") {
      alert("상품이름은 반드시 입력해야 합니다.");
      $("#p_name").focus();
      return false;
    }

    $("form").submit();
  });
});
