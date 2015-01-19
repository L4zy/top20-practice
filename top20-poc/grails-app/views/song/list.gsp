
<%@ page import="top20.entity.Artist"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>

	<g:if test="${voted != null}">
		<div>
			Successful voted for
			${voted}
		</div>
	</g:if>
	<table>
		<g:each in="${songInstanceList}" status="i" var="songInstance">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

				<td><g:link action="show" id="${songInstance.id}">
						${fieldValue(bean: songInstance, field: "name")}
					</g:link></td>

				<td>
					${fieldValue(bean: songInstance?.artist, field: "stageName")}
				</td>

				<td>
					${votsCount}
				</td>

				<td><g:link controller="vote" action="vote"
						params="['song.id': songInstance?.id]">Vote</g:link></td>

			</tr>
		</g:each>
	</table>

	<g:link controller="song" action="createNew">Create New</g:link>

</body>
</html>
