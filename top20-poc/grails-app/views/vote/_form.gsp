<%@ page import="top20.entity.Vote" %>



<div class="fieldcontain ${hasErrors(bean: voteInstance, field: 'votDate', 'error')} required">
	<label for="votDate">
		<g:message code="vote.votDate.label" default="Vot Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="votDate" precision="day"  value="${voteInstance?.votDate}"  />

</div>

