
<h1>Liste de Books</h1>

<#list books as book>
  <div>
    <div>
      ${book.name}
    </div>
    <div>
      ${book.nbPage}
    </div>
    <div>
      ${book.price}
    </div>
  </div>
</#list>