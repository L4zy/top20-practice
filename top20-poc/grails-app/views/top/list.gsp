
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
		<div>
			${top?.mostPopulatArtist?.stageName}  ${top?.mostPopulatArtist?.realName}
		</div>
	</g:if>

	<g:if test="${top?.mostPopulatSong != null}">

		<div>
			The most popular song
		</div>
		<div>
			${top?.mostPopulatSong?.name}
		</div>
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
