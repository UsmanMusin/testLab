
// Пагинация

var i = 0, len, idNum, pageSize = 5, currentPage = 1;
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
// Построение таблицы с данными
function myFunction(json, i) {
    len = json.length;
    var pageData = "<table class='blackTB'><thead><tr><th>№</th><th>Название</th><th>Исполнитель</th>" +
        "<th>Альбом</th><th>Год</th><th>Длительность</th></tr></thead>";
    for(k = i; k < j; k++){
        pageData += "<tr id='" + json[k].id + "'>" +
            "<td>" + json[k].id + "</td>" +
            "<td><a href='#' onclick='initShowWin("+json[k].id+")'> " + json[k].name + "</td>" +
            "<td>" + json[k].artist + "</td>" +
            "<td>" + json[k].album + "</td>" +
            "<td>" + json[k].date + "</td>" +
            "<td>" + json[k].duration + "</td>" + "</tr>";
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
        displaySongs(i);
    }
}
// Предыдущая страница
function previous() {
    if (i > 0) {
        i-=pageSize;
        j=i+pageSize;
        currentPage--;
        displaySongs(i);
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
        displaySongs(i);
        return false;
    };
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
function ShowWin(arr) {

    document.getElementById("sName").innerHTML = arr[1];
    document.getElementById("sArtist").innerHTML = arr[2];
    document.getElementById("sAlbum").innerHTML = arr[3];
    document.getElementById("sDate").innerHTML = arr[4];
    document.getElementById("sDuration").innerHTML = arr[5];
    showModalWin(document.getElementById("showForm"));
}







