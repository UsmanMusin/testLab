<%--
  Created by IntelliJ IDEA.
  User: Усман
  Date: 01.09.2018
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script>
        var i = 0, len;

        displaySongs(i);

        function displaySongs(i) {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    var myArr = JSON.parse(this.responseText);
                    myFunction(myArr, i);
                }
            };
            xmlhttp.open("GET", "/rest/allsongs.do", true);
            xmlhttp.send();
        }

        function myFunction(json, i) {
            len = json.length;
            document.getElementById("showCD").innerHTML =
                "Name: " +
                json[i].name +
                "<br>Artist: " +
                json[i].artist +
                "<br>Album: " +
                json[i].album;
            document.getElementById("currentPage").innerHTML = i + 1;
        }

        function next() {
            if (i < len-1) {
                i++;
                displaySongs(i);
            }
        }

        function previous() {
            if (i > 0) {
                i--;
                displaySongs(i);
            }
        }
    </script>
</head>
<body>

<div id='showCD'></div><br>
<input type="button" onclick="previous()" value="<<">
<span id = 'currentPage'></span>
<input type="button" onclick="next()" value=">>">

</body>
</html>
