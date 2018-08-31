<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Содержимое базы</title>
  <link href="<c:url value='/main.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<a class="adminButton" href="admin.do"/>Администрирование</a><br>
<a class="adminButton" href="init.do"/>Заполнить базу</a>&nbsp&nbsp${initmsg}

<div align="center">
  <form class="form-container" action="check.do" method="post">
    <div class="form-title"><h2>Авторизация</h2></div>
    <div class="form-title">Ваше Имя</div>
    <input class="form-field" type="text" name="user" /><br />
    <div class="form-title">Пароль</div>
    <input class="form-field" type="password" name="pass" /><br />
    <div class="submit-container">
      <input class="submit-button" type="submit" value="Войти" />
      <div class="status">${error}</div>
    </div>
  </form>
</div>
