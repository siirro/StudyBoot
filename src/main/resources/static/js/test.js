console.log("start");

$("#btn").click(function(){
    console.log("click");
});

// const buttons = document.getElementsByClassName("buttons");
// const buttons = document.querySelectorAll(".buttons");

$(".buttons").click(function(){
    console.log("buttons");
});

$("#test").on("click", "#btn2", function(){

});

// .html();

// .attr("속성명");

// .prop("속성명");
// selected checked 등 상태가 변할 때 값도 변하는 속성