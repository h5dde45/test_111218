<#import "parts/common.ftl" as c>

<@c.page>
<div class="alert alert-info mt-3" role="alert">
    <h4>Задание 4. Создать приложение Телефонный справочник</h4>
</div>

<div class="form-group mt-3">
    <form method="get" action="/person" class="form-inline">
        <div class="form-group">
            <input type="text" name="filter"
                   placeholder="Поиск по фамилии.." class="form-control">
            <button type="submit" class="btn btn-success ml-2">Поиск</button>
        </div>
    </form>
</div>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample"
   role="button" aria-expanded="false" aria-controls="collapseExample">
    <#if person??>Редактировать запись
    <#else>
        Добавить новый номер
    </#if>
</a>
<div class="collapse  <#if person??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="/person">
            <input type="hidden" name="id" value="<#if person??>${person.id}</#if>"/>
            <div class="form-group">
                <input type="text" name="name" placeholder="Имя.."
                       class="form-control"
                       value="<#if person??>${person.name}</#if>">
            </div>
            <div class="form-group">
                <input type="text" name="surname" placeholder="Фамилия.."
                       class="form-control"
                       value="<#if person??>${person.surname}</#if>">
            </div>
            <div class="form-group">
                <input type="text" name="telephone" placeholder="Телефон.."
                       class="form-control"
                       value="<#if person??>${person.telephone}</#if>">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-info">
                    <#if person??>Изменить
                    <#else>
                        Добавить
                    </#if>
                </button>
            </div>
        </form>
    </div>
</div>

<div class="mt-3">
    <table class="table table-dark" id="tableMouse">
        <thead>
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Телефон</th>
            <th scope="col">...</th>
            <th scope="col">...</th>
        </tr>
        </thead>
        <tbody>
            <#list persons as person>
            <tr>
                <td scope="row">${person.name}</td>
                <td scope="row">${person.surname}</td>
                <td scope="row">${person.telephone}</td>
                <td scope="row"><a href="/person/${person.id}">Редактировать</a></td>
                <td scope="row"><a href="/person/delete/${person.id}">Удалить</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@c.page>