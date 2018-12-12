<#import "parts/common.ftl" as c>

<@c.page>
<div class="alert alert-primary mt-3" role="alert">
    <h5>Задание 1b. С простым AI (1 игрок, AI выбирает случайное поле)</h5>
</div>
<div class="alert alert-info mt-3" role="alert">
    <h5 id="playerNumber"></h5>
</div>
<button id="batt" class="btn btn-info mb-3">Add AI zero</button>
<div id="game">
</div>
<div class="alert alert-danger mt-3" role="alert">
    <h5 id="winner"></h5>
</div>
<script src="../static/js/xob.js"></script>
</@c.page>