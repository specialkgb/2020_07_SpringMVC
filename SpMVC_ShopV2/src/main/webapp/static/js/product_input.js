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
          $("#btn_resister").click(function(){
          
             var n_userid = $("#n_userid").val();
             var n_email = $("#n_email").val();
             var n_password = $("#n_password").val();
             
             if(n_userid==""){
                alert("id는 반드시 입력해야 합니다");
                $("n_userid").focus();
                return false;
                
             
             }else if(!n_password){
                alert("비밀번호는 반드시 입력해야 합니다");
                $("n_password").focus();
                return false;
             }else{
                return true;
                
             }
             
             alert("Short Navi에 오신 것을 환영합니다!");
             $("#register").submit()
             
          })

});
