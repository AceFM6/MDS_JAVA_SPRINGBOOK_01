
<#list users as user>
	<a href="login/${user.id}">
	  <div>
	    <div>
	      ${user.firstname}
	    </div>
	    <div>
	      ${user.lastname}
	    </div>
	    <div>
	      ${user.role.name}
	    </div>
	  </div>
  	</a>
</#list>