<#import "parts/common.ftl" as c>

<@c.page>
<div class="alert alert-primary mt-3" role="alert">
    <h5>Задание 1c. Со сложным AI (1 игрок, AI просчитывает наиболее благоприятный ход)</h5>
</div>

<div style="width: 350px;">
    <#list cards as card>
        <a href="/xo/c/${card.id}"
           class="btn ${card.colorInfo} ${card.disable}  m-1"
           style="width: 100px; height: 100px;font-size: 60px">${card.badge}</a>
    </#list>
</div>
<hr>
<a href="/xo/c/update" class="btn btn-primary" role="button" aria-disabled="true">Начать сначала</a>
</@c.page>