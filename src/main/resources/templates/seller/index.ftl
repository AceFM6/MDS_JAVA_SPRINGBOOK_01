<a href="seller/create">Create</a>

<h1>Liste de mes books</h1>

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