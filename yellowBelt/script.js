var succulentImg = document.querySelector("#succulent-img")

function switchImg() {
    succulentImg.src="succulents-2.jpg";
}

var succulentImg = document.querySelector("#succulent-img")
function switchImg2(){
    succulentImg.src="succulents-1.jpg";
}


var alertBox = document.querySelector(".alert")
function closeAlert() {
    console.log("You clicked Accept")
    alertBox.remove()
}
