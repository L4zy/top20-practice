<%@ page import="top20.entity.Artist" %>



<div class="fieldcontain ${hasErrors(bean: artistInstance, field: 'stageName', 'error')} required">
	<label for="stageName">
		<g:message code="artist.stageName.label" default="Stage Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="stageName" required="" value="${artistInstance?.stageName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: artistInstance, field: 'realName', 'error')} required">
	<label for="realName">
		<g:message code="artist.realName.label" default="Real Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="realName" required="" value="${artistInstance?.realName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: artistInstance, field: 'songs', 'error')} ">
	<label for="songs">
		<g:message code="artist.songs.label" default="Songs" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${artistInstance?.songs?}" var="s">
    <li><g:link controller="song" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="song" action="create" params="['artist.id': artistInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'song.label', default: 'Song')])}</g:link>
</li>
</ul>


</div>

