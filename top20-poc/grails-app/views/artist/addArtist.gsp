<html>
	<head>
		<meta name="layout" content="main"/>
	</head>
    <body>
         <g:form name="add" url="[action:'add',controller:'song']">
         
         	<g:renderErrors bean="${song}" as="list" field="title"/>
         
	        <div class="add">
	        <ul>
	        <li> 
	        <div class="el">
		         <span class="label"> Song Title</span>
		         <div class="value">    <input name="title" maxlength="50"/ > 
	         </div>
	        </li>
	        </ul>
	        <br/>
	         <br/>
	        <div><input value="Add" type="submit"/></div>
	        </div>
        </g:form>
        
   </body>
</html>