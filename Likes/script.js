var likeCount = 3
var likeSpan1 = document.querySelector("#post-1");

function like() {
    likeCount++;
    likeSpan1.innerText = likeCount + "like(s)"
}