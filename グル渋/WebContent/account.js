// formオブジェクトの作成
var form = document.getElementById("form");

document.getElementById('image').addEventListener('change', function (e) {
    // 1枚だけ表示する
    var file = e.target.files[0];
    // ファイルリーダー作成
    var fileReader = new FileReader();
    fileReader.onload = function() {
        // Data URIを取得
        var dataUri = this.result;
        // img要素に表示
        var img = document.getElementById('file-preview');
        img.src = dataUri;
    }
    // ファイルをData URIとして読み込む
    fileReader.readAsDataURL(file);
});

// submitイベントが起きたときの処理
form.addEventListener("submit", function(event) {
    // formのデフォルト機能を消し，JavaScriptで管理
    event.preventDefault();
    check();
});

function check() {
    // formのvalueを取ってくる
    var username = document.getElementById("username").value;
    var loginid = document.getElementById("mail").value;
    var password = document.getElementById("password").value;
    // 入力されている場合送信
    if (username != "" && loginid != "" && password != "" && gender != "" && image != "") {
        sendData();
    } else {
        alert("Please input all item.");
    }
}

function sendData() {
    // FormDataオブジェクトの作成
    var formData = new FormData(form);
    // XMLHttpRequestでHTTPリクエストを送る
    var req = new XMLHttpRequest();

    // 送受信が完了した場合の処理
    req.addEventListener("load", function(event) {
        if (req.responseText == "done") {
            // 処理が成功した場合の処理
            alert("Succeeded.");
            window.location.href = '/グル渋/list.jsp';
        } else {
            alert("Failed to send.");
        }
    });
    // 送受信が失敗した場合の処理
    req.addEventListener("error", function(event) {
        alert("Error");
    });

    // HTTPリクエストの設定
    req.open("POST", "/グル渋/makeAccount"); // /application名/Servlet名
    // リクエストを送信
    req.send(formData);
}