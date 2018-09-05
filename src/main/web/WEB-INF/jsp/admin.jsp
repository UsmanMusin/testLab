<%--
  Created by IntelliJ IDEA.
  User: Усман
  Date: 01.09.2018
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<br>
<head>
    <link href="<c:url value='/main.css'/>" rel="stylesheet" type="text/css">
    <script>
        var i = 0, len, pageSize = 5, currentPage = 1;
        var j = pageSize;
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
            var pageData = "<table class='blackTB'><thead><tr><th>№</th><th>Название</th><th>Исполнитель</th>" +
                "<th>Альбом</th><th>Год</th><th>Длительность</th></tr></thead>";
            for(k = i; k < j; k++){
                pageData += "<tr>" +
                        "<td>" + json[k].id + "</td>" +
                        "<td>" + json[k].name + "</td>" +
                        "<td>" + json[k].artist + "</td>" +
                        "<td>" + json[k].album + "</td>" +
                        "<td>" + json[k].date + "</td>" +
                        "<td>" + json[k].duration + "</td>" + "</tr>";
            }
            pageData += "</table>";
            document.getElementById("showCD").innerHTML = pageData;

            document.getElementById("currentPage").innerHTML = currentPage;
        }

        function next() {
            if ((len / 5) > currentPage) {
                i+=pageSize;
                currentPage++;
                if((j + pageSize) > len){
                    j = len;
                }
                else j+=pageSize;
                displaySongs(i);
            }
        }

        function previous() {
            if (i > 0) {
                i-=pageSize;
                j=i+pageSize;
                currentPage--;
                displaySongs(i);
            }
        }

        //Открытие модального окна

        function showModalWin() {

            var darkLayer = document.createElement('div'); // слой затемнения
            darkLayer.id = 'shadow'; // id чтобы подхватить стиль
            document.body.appendChild(darkLayer); // включаем затемнение

            var modalWin = document.getElementById('popupWin'); // находим наше "окно"
            modalWin.style.display = 'block'; // "включаем" его

            darkLayer.onclick = function () {  // при клике на слой затемнения все исчезнет
                darkLayer.parentNode.removeChild(darkLayer); // удаляем затемнение
                modalWin.style.display = 'none'; // делаем окно невидимым
                displaySongs(i);
                return false;
            };
        }

        function addSong() {

            var xhr = new XMLHttpRequest();

            var body = 'name=' + encodeURIComponent(name) +
                '&artist=' + encodeURIComponent(artist) +
                '&album=' + encodeURIComponent(album) +
                '&date=' + encodeURIComponent(date) +
                '&duration=' + encodeURIComponent(duration);

            xhr.open("POST", '/rest/addsong.do', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

            xhr.send(body);


            /*xhr.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("addmsg").innerHTML = request.responseText;
                }
            };*/

        }
    </script>
</head>
<div align="center">
<button class="myButtonadd" onclick="showModalWin()">Добавить</button><br><br>
<div id='showCD'></div><br>
<input type="button" onclick="previous()" value="<<">
<span id = 'currentPage'></span>
<input type="button" onclick="next()" value=">>">
</div>


<div id="popupWin" class="modalwin">
    <h2> Добавить песню </h2>
    <hr>
    <form id = "addSong">
        <input type="text" name="name" placeholder="Название" size="50">
        <input type="text" name="artist" placeholder="Исполнитель" size="50">
        <input type="text" name="album" placeholder="Альбом" size="50">
        <input type="text" name="date" placeholder="Год" size="50">
        <br><input type="text" name="duration" placeholder="Длительность" size="50">
        <br><br><button class="myButtonadd" onclick="addSong()">Добавить</button><span id="addmsg"></span>
    </form>
</div>

</body>
</html>
