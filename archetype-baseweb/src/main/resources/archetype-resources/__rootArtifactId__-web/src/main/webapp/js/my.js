/*个性化的javascript */

/*分页跳转*/
function goToPage(page,limit,queryForm){
	var form=$("#"+queryForm);
	form.append("<input type='hidden' id='page' name='page' value='"+page+"'></input>");
	form.append("<input type='hidden' id='limit' name='limit' value='"+limit+"'></input>");
	form.submit();
}
