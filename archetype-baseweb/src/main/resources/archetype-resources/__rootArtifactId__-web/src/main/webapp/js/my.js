/*个性化的javascript */
/*扩展ie的indexOf方法*/
if(!Array.indexOf){Array.prototype.indexOf = function(obj){for(var i=0; i<this.length; i++){if(this[i]==obj){return i;}} return -1;}};
/*分页跳转*/
function goToPage(page,limit,queryForm){
	var form=$("#"+queryForm);
	form.append("<input type='hidden' id='page' name='page' value='"+page+"'></input>");
	form.append("<input type='hidden' id='limit' name='limit' value='"+limit+"'></input>");
	form.submit();
}
