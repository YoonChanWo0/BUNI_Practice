<!DOCTYPE html>
<html>
<head>
    <title>Form Registration</title>
    <style>
        #resultBox {
            display: none;
        }
    </style>
    <script>
        function signUp() {
            var name = document.getElementById('name').value;
            var email = document.getElementById('email').value;

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/regform", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById('regform').style.display = 'none';
                    var resultBox = document.getElementById('resultBox');
                    resultBox.style.display = 'block';
                    resultBox.innerHTML = xhr.responseText;
                }
            };
            xhr.send("name=" + encodeURIComponent(name) + "&email=" + encodeURIComponent(email));
        }
    </script>
</head>
<body>
<div id="regform">
    <form>
        이름: <input type="text" id="name" name="name"><br>
        이메일: <input type="text" id="email" name="email"><br>
        <input type="button" value="가입" onclick="signUp()">
    </form>
</div>
<div id="resultBox"></div>
</body>
</html>
