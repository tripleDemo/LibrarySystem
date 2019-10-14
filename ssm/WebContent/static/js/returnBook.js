$(function(){
	
	$("#toLeft").on("click",function(){
		let idNum = nextPage('reduce');
		if(idNum != undefined){
			$('#toLeft').attr("href",$('#toLeft').attr('href')+idNum);
		}else{
			$('#toLeft').attr("href",'');
		}
    });	
	
	$("#toRight").on("click",function(){
		let idNum = nextPage('add');
		if(idNum != undefined){
			$('#toRight').attr("href",$('#toRight').attr('href')+idNum);
		}else{
			$('#toRight').attr("href",'');
		}
    });
	
	function nextPage(algorithm){
		for(item of $('.liNum')){
			let classStr = $(item).attr('class');
			if(classStr.indexOf('active') > -1){
				let idName = $(item).attr("id");
        		let numStr = idName.substring(idName.length-1);
        		let idNum = parseInt(numStr) + (algorithm == "add" ? 1 : -1);
        		if(idNum <= 0 || idNum > $("#pages").val()) return;
        		return idNum;
			}
		}
	}
});