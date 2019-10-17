<html>

<head>
    <link rel="stylesheet" href="/static/style.css">
</head>
<#if (username)??>
    <h2>Hello ${username}!</h2>
<#else>
    <h2>Hello! Vous n'êtes pas identifié !</h2>
</#if>

<h2> Liste des talks </h2>
<table align="center" border="1">
    <tr>
        <th>Titre</th>
        <th>Description</th>
        <th>Type</th>
    </tr>
    <#list talkList as talk>
        <tr>
            <td>${talk.title}</td>
            <td>${talk.description}</td>
            <td>${talk.type}</td>
        </tr>
    </#list>
</table>
</html>