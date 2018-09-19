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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value='/resources/main.css'/>" rel="stylesheet" type="text/css">
    <script src="<c:url value="/resources/admin.js"/>"></script>

</head>

<%--Элементы основной страницы--%>
<a class="myButtonDel" href="exit.do"/>Выйти</a>
<div align="center">
<button class="myButtonadd" onclick="addWin()">Добавить</button><br><br>
<div id='showCD'></div><br>
<input type="button" onclick="previous()" value="<<">
<span id = 'currentPage'></span>
<input type="button" onclick="next()" value=">>">
</div>


<div id="popupWin" class="modalwin"></div> <%--// Модальное окно--%>

<div id="addForm" class="modalwin">  <%--// Форма добавления--%>
    <h2> Добавление песни </h2>
    <hr>
    <form id = "addSong" onsubmit="addSong(); return false;">
        <input type="text" id="aName" name="name" placeholder="Название" size="50">
        <input type="text" id="aArtist" name="artist" placeholder="Исполнитель" size="50">
        <input type="text" id="aAlbum" name="album" placeholder="Альбом" size="50">
        <input type="text" id="aDate" name="date" placeholder="Год" size="50">
        <br><input type="text" id="aDuration" name="duration" placeholder="Длительность" size="50">
        <br><br><button type="submit" class="myButtonadd">Добавить</button><span id="addmsg"></span>
    </form>
</div>

<div id="searchForm" class="modalwin">  <%--// Форма добавления--%>
    <h2> Поиск песен </h2>
    <hr>
    <form id = "addSong" onsubmit="searchSong(); return false;">
        <input type="text" id="fName" name="name" placeholder="Название" size="50">
        <input type="text" id="fArtist" name="artist" placeholder="Исполнитель" size="50">
        <input type="text" id="fAlbum" name="album" placeholder="Альбом" size="50">
        <input type="text" id="fDate" name="date" placeholder="Год" size="50">
        <br><input type="text" id="fDuration" name="duration" placeholder="Длительность" size="50">
        <br><br><button type="submit" class="myButtonadd">Добавить</button><span id="addmsg"></span>
    </form>
</div>

<div id="editForm" class="modalwin">  <%--// Форма изменения--%>
    <h2> Редактирование песни </h2>
    <hr>
    <form id = "editSong" onsubmit="editSong(); return false;">
        <input type="text" id="eName" name="name" placeholder="Название" size="50">
        <input type="text" id="eArtist" name="artist" placeholder="Исполнитель" size="50">
        <input type="text" id="eAlbum" name="album" placeholder="Альбом" size="50">
        <input type="text" id="eDate" name="date" placeholder="Год" size="50">
        <br><input type="text" id="eDuration" name="duration" placeholder="Длительность" size="50">
        <br><br><button type="submit" class="myButtonadd">Сохранить</button><span id="addmsg"></span>
    </form>
</div>

<div id="showForm" class="modalwin">  <%--// Форма показа--%>
    <h2> Просмотр песни </h2>
    <hr>
    <form id = "showSong" >
        <span><b>Название: </b></span><span id="sName"></span>
        <br><span><b>Исполнитель: </b></span><span id="sArtist"></span>
        <br><span><b>Альбом: </b></span><span id="sAlbum"></span>
        <br><span><b>Год: </b></span><span id="sDate"></span>
        <br><span><b>Длительность: </b></span><span id="sDuration"></span>
    </form>
</div>


</body>
</html>
