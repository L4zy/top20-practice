<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
	<g:form name="add" url="[action:'saveArtist',controller:'artist']">

		<g:renderErrors bean="${song}" as="list" field="title" />

		<div
			class="fieldcontain ${hasErrors(bean: artistInstance, field: 'stageName', 'error')} required">
			<label for="stageName"> <g:message
					code="artist.stageName.label" default="Stage Name" /> <span
				class="required-indicator">*</span>
			</label>
			<g:textField name="stageName" required=""
				value="${artistInstance?.stageName}" />

		</div>

		<div
			class="fieldcontain ${hasErrors(bean: artistInstance, field: 'realName', 'error')} required">
			<label for="realName"> <g:message
					code="artist.realName.label" default="Real Name" /> <span
				class="required-indicator">*</span>
			</label>
			<g:textField name="realName" required=""
				value="${artistInstance?.realName}" />

		</div>

		<div>
			<input value="Add" type="submit" />
		</div>
		</div>

	</g:form>

</body>
</html>