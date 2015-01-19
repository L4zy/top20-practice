<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
	<g:form name="add" url="[action:'save',controller:'song']">

		<g:renderErrors bean="${artist}" as="list" field="title" />

		<div
			class="fieldcontain ${hasErrors(bean: songInstance, field: 'name', 'error')} required">
			<label for="name"> <g:message code="song.name.label"
					default="Name" /> <span class="required-indicator">*</span>
			</label>
			<g:textField name="name" required="" value="${songInstance?.name}" />

		</div>

		<div
			class="fieldcontain ${hasErrors(bean: songInstance, field: 'artist', 'error')} required">
			<label for="artist"> <g:message code="song.artist.label"
					default="Artist" /> <span class="required-indicator">*</span>
			</label>

			<g:select optionKey="id" optionValue="stageName" name="artist.id"
				from="${artistList}" />
		</div>
		<br />
		<div>
			<input value="Add" type="submit" />
		</div>
	</g:form>

</body>
</html>