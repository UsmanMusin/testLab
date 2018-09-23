
// Пагинация

var i = 0, len, idNum, pageSize = 5, currentPage = 1;
var j = pageSize;
var getallUrl = "/rest/allsongs.do";
var currentUrl = getallUrl;
displaySongs(currentUrl);

function displaySongs(jsonUrl) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var myArr = JSON.parse(this.responseText);
            myFunction(myArr);
        }
    };
    xmlhttp.open("GET", jsonUrl, true);
    xmlhttp.send();
}
// Построение таблицы с данными
function myFunction(json) {
    len = json.length;
    var pageData = "<table class='blackTB'><thead><tr><th>№</th><th>Название</th><th>Исполнитель</th>" +
        "<th>Альбом</th><th>Год</th><th>Длительность</th><th></th><th></th></tr></thead>";
    for(k = i; k < j; k++){
        pageData += "<tr id='" + json[k].id + "'>" +
            "<td>" + json[k].id + "</td>" +
            "<td><a href='#' onclick='initShowWin("+json[k].id+")'> " + json[k].name + "</td>" +
            "<td>" + json[k].artist + "</td>" +
            "<td>" + json[k].album + "</td>" +
            "<td>" + json[k].date + "</td>" +
            "<td>" + json[k].duration + "</td>" +
            "<td><button class='adminButton'  onclick='initEditWin(" + json[k].id + ")' >Редактировать</button></td>" +
            "<td><button class='myButtonDel'  onclick='delConf(" + json[k].id + ")' >Удалить</button></td>"+ "</tr>";
    }
    pageData += "</table>";
    document.getElementById("showCD").innerHTML = pageData;

    document.getElementById("currentPage").innerHTML = currentPage;
}
// Следующая страница
function next() {
    if ((len / 5) > currentPage) {
        i+=pageSize;
        currentPage++;
        if((j + pageSize) > len){
            j = len;
        }
        else j+=pageSize;
        displaySongs(currentUrl);
    }
}
// Предыдущая страница
function previous() {
    if (i > 0) {
        i-=pageSize;
        j=i+pageSize;
        currentPage--;
        displaySongs(currentUrl);
    }
}

//Открытие модального окна с включением необходимой формы через параметр formType

function showModalWin(formType) {

    var darkLayer = document.createElement('div'); // слой затемнения
    darkLayer.id = 'shadow'; // id чтобы подхватить стиль
    document.body.appendChild(darkLayer); // включаем затемнение

    var modalWin = document.getElementById('popupWin'); // находим наше "окно"
    modalWin.appendChild(formType);
    modalWin.style.display = 'block'; // "включаем" его
    formType.style.display = 'block'; // "включаем" форму

    darkLayer.onclick = function () {  // при клике на слой затемнения все исчезнет
        darkLayer.parentNode.removeChild(darkLayer); // удаляем затемнение
        modalWin.style.display = 'none'; // делаем окно невидимым
        displaySongs(currentUrl);
        return false;
    };
}

// Построение окна добавления
function addWin() {
    showModalWin(document.getElementById("addForm"));
}
// Отправка данных JSON - Добавление
function addSong() {
    var xhr = new XMLHttpRequest();
    var json = JSON.stringify({
        name: document.getElementById("aName").value,
        artist: document.getElementById("aArtist").value,
        album: document.getElementById("aAlbum").value,
        date: document.getElementById("aDate").value ,
        duration: document.getElementById("aDuration").value
    });


    xhr.open("POST", '/rest/addsong.do', true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');

    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("addmsg").innerHTML = "&nbsp&nbsp Добавлено!";
            setTimeout(function(){ document.getElementById('popupWin').style.display = "none";
                var element = document.getElementById("shadow");
                element.parentNode.removeChild(element);
                document.getElementById("addmsg").innerHTML = "";

                displaySongs(currentUrl);},2000);

        }
    };
    xhr.send(json);
}

//Построение окна поиска
function  searchWin() {
    showModalWin(document.getElementById("searchForm"));
}

//Фильтрация таблицы по критериям поиска
function searchSong() {
    var searchUrl = "rest/filterSongs.do?"
        + "name=" + document.getElementById("fName").value + "&" +
         "artist=" + document.getElementById("fArtist").value + "&" +
         "album=" + document.getElementById("fAlbum").value + "&" +
         "date=" + document.getElementById("fDate").value + "&" +
         "duration=" + document.getElementById("fDuration").value + "&";
    currentUrl = searchUrl;
    document.getElementById("closeSearch").innerHTML =
        "<button onclick=\"closeSearch()\">Вернуться к списку</button>";
    i = 0, pageSize = 5, currentPage = 1; j = pageSize;
    displaySongs(currentUrl);
}

//Функция закрытия фильтрованной таблицы
function closeSearch() {
    currentUrl = getallUrl;
    document.getElementById("closeSearch").innerHTML = null;
    i = 0, pageSize = 5, currentPage = 1; j = pageSize;
    displaySongs(currentUrl);
}

// Построение массива с данными из выбранной строки
function initEditWin(numId) {
    var row =  document.getElementById(numId);
    var arr = [row.childNodes[0].textContent,
        row.childNodes[1].textContent,
        row.childNodes[2].textContent,
        row.childNodes[3].textContent,
        row.childNodes[4].textContent,
        row.childNodes[5].textContent];
    editWin(arr)
}

// Построение массива с данными из выбранной строки
function initShowWin(numId) {
    var row =  document.getElementById(numId);
    var arr = [row.childNodes[0].textContent,
        row.childNodes[1].textContent,
        row.childNodes[2].textContent,
        row.childNodes[3].textContent,
        row.childNodes[4].textContent,
        row.childNodes[5].textContent];
    ShowWin(arr)
}

// Построение окна изменения
function editWin(arr) {
    idNum = arr[0];
    document.getElementById("eName").setAttribute("value", arr[1]);
    document.getElementById("eArtist").setAttribute("value", arr[2]);
    document.getElementById("eAlbum").setAttribute("value", arr[3]);
    document.getElementById("eDate").setAttribute("value", arr[4]);
    document.getElementById("eDuration").setAttribute("value", arr[5]);
    showModalWin(document.getElementById("editForm"));
}

// Построение окна просмотра
function ShowWin(arr) {

    document.getElementById("sName").innerHTML = arr[1];
    document.getElementById("sArtist").innerHTML = arr[2];
    document.getElementById("sAlbum").innerHTML = arr[3];
    document.getElementById("sDate").innerHTML = arr[4];
    document.getElementById("sDuration").innerHTML = arr[5];
    showModalWin(document.getElementById("showForm"));
}

// Отправка данных JSON - Изменение
function editSong() {
    var xhr = new XMLHttpRequest();
    var json = JSON.stringify({
        id: idNum,
        name: document.getElementById("eName").value,
        artist: document.getElementById("eArtist").value,
        album: document.getElementById("eAlbum").value,
        date: document.getElementById("eDate").value ,
        duration: document.getElementById("eDuration").value
    });

    xhr.open("POST", '/rest/editsong.do' , true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');

    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("addmsg").innerHTML = "&nbsp&nbsp Сохранено!";
            setTimeout(function(){ document.getElementById('popupWin').style.display = "none";
                var element = document.getElementById("shadow");
                element.parentNode.removeChild(element);
                document.getElementById("addmsg").innerHTML = "";

                displaySongs(currentUrl);},2000);

        }
    };
    xhr.send(json);
}

// Вывод окна подтверждения удаления
function delConf(numId) {
    var row =  document.getElementById(numId);
    var textConf = "" +
        row.childNodes[1].textContent + " " +
        row.childNodes[2].textContent + " " +
        row.childNodes[3].textContent + " " +
        row.childNodes[4].textContent + " " +
        row.childNodes[5].textContent;
    var r = confirm("Удалить песню -" + textConf + "?");
    if (r == true) {
        delSong(numId);
    }
}

// Удаление при нажатии "ОК"
function delSong(id) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            displaySongs(currentUrl);
        }
    }
    xmlhttp.open("GET", "/rest/delsong/" +id + ".do", true);
    xmlhttp.send();
}


