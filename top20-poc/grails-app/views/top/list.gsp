
<%@ page import="top20.entity.Vote"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
</head>
<body>
	<g:if test="${top?.mostPopulatArtist != null}">
	
		<div>
			The most popular artist
		</div>
		<ul>
		<g:each in="${top?.mostPopulatArtist}" status="i" var="topArtist">
			<li>${topArtist?.artist}</li>
		</g:each>
		</ul>
	</g:if>

	<g:if test="${top?.mostPopulatSong != null}">
		<div>
			The most popular song
		</div>
		<ul>
		<g:each in="${top?.mostPopulatSong}" status="i" var="topSong">
			<li>${topSong?.song}</li>
		</g:each>
		</ul>
	</g:if>

	<g:if test="${top?.artistOfTheWeek != null}">
		<div>
			${top?.artistOfTheWeek?.stageName} ${artistOfTheWeek?.realName}
		</div>
	</g:if>

	<g:if test="${top?.songOfTheWeek != null}">
		
		<div>
			${top?.songOfTheWeek?.name}
		</div>
	</g:if>
</body>
</html>
