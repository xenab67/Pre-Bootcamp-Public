var likeCount = [9, 12, 9];
var likeSpan1 = [
    document.querySelector("#post-1"),
    document.querySelector("#post-2"),
    document.querySelector("#post-3")
];

function like(id) {
    likeCount[id]++;
    likeSpan1[id].innerText = likeCount[id] + "like(s)"
}