<#import "parts/common.ftl" as c>

<@c.page>
<div class="alert alert-info mt-3" role="alert">
    <h4>Задание 1. Сделать игру крестики-нолики 3х3. Режимы игры:</h4>
</div>
<a class="btn btn-info m-3" href="/xo/a">С человеком (2 игрока)</a><br>
<a class="btn btn-info m-3" href="/xo/b">С простым AI (1 игрок, AI выбирает случайное поле)</a><br>
<a class="btn btn-info m-3" href="/xo/c">Со сложным AI (1 игрок, AI просчитывает наиболее благоприятный ход)</a><br>
</@c.page>