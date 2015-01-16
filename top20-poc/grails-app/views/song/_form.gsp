<%@ page import="top20.entity.Song" %>



<div class="fieldcontain ${hasErrors(bean: songInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="song.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${songInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: songInstance, field: 'artist', 'error')} required">
	<label for="artist">
		<g:message code="song.artist.label" default="Artist" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="artist" name="artist.id" from="${top20.entity.Artist.list()}" optionKey="id" required="" value="${songInstance?.artist?.stageName}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: songInstance, field: 'vots', 'error')} ">
	<label for="vots">
		<g:message code="song.vots.label" default="Vots" />
		
	</label>
	<g:select name="vots" from="${top20.entity.Vote.list()}" multiple="multiple" optionKey="id" size="5" value="${songInstance?.vots*.id}" class="many-to-many"/>

</div>

