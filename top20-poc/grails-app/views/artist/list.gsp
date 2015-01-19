
<%@ page import="top20.entity.Artist"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
	<table>
		<g:each in="${artistInstanceList}" status="i" var="artistInstance">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

				<td><g:link action="show" id="${artistInstance.id}">
						${fieldValue(bean: artistInstance, field: "stageName")}
					</g:link></td>

				<td>
					${fieldValue(bean: artistInstance, field: "realName")}
				</td>

			</tr>
		</g:each>
	</table>
	
	<g:link controller="artist" action="createNew">Create New</g:link>
	
</body>
</html>
