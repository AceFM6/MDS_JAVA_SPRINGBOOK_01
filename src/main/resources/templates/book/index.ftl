<a href="/book/create">Create</a>


<#list items as item>
  <div>
    <div>
      ${item.name}
    </div>
    <div>
      ${item.nbPage}
    </div>
    <div>
      ${item.price}
    </div>
    <div>
      <a href="/user/details/${item.id}">Details</a>
    </div>
  </div>
</#list>