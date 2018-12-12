<#import "parts/common.ftl" as c>

<@c.page>
<div class="alert alert-info mt-3" role="alert">
    <h4>Задание 2. Сделать сервлет, обрабатывающий запрос GET и выдающий случайное число</h4>
</div>
<hr>
<a class="btn btn-success m-3" href="/random_number/g">
    <h4>Запрос GET на случайное число</h4></a><br>
    <#if number??>
    <div class="alert alert-info mt-3" role="alert">
        <h4>Случайное число = ${number}</h4>
    </div>
    </#if>
</@c.page>