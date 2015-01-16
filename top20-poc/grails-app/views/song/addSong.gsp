<html>
	<head>
		<meta name="layout" content="main"/>
	</head>
    <body>
         <g:form name="add" url="[action:'add',controller:'artist']">
         
         	<g:renderErrors bean="${artist}" as="list" field="title"/>
         
	        <div class="addArtist">
	        <ul>
	        <li> 
	        <div class="el">
		         <span class="label"> Artist Name</span>
		         <div class="value">    <input name="realName" maxlength="50"/ > 
	         </div>
	        </li>
	        <li>  
				 <div class="el">
		         <span class="label"> Stage Name</span>
		         <div class="value">  <input name="stageName" maxlength="50" /> 
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