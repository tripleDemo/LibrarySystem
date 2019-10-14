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
	
	$(".modifyBtn").on("click",function(){
		let tr = $(this).parents("tr");
		for(let i=1;i<=4;i++){
			tr.find('th:eq('+i+')').hide();
			tr.find('th:eq('+(i+4)+')').show();
		}
		tr.find('th:eq(9)').find('.modifyBtn').hide();
		tr.find('th:eq(9)').find('.saveBtn').show();
	});
	
	$(".saveBtn").on("click",function(){
		let tr = $(this).parents("tr");
		let bookId = tr.find('th:eq(9)').find('#bookId').val();
		let bookName = tr.find("input[id='bookName']").val();
		let borrowNum = tr.find("input[id='borrowNum']").val();
		let publisher = tr.find("input[id='publisher']").val();
		let publishTime = tr.find("input[id='publishTime']").val();	
		let formData = {bookId:bookId,bookName:bookName,borrowNum:borrowNum,publisher:publisher,publishTime:publishTime};
		for(let i=1;i<=4;i++){
			tr.find('th:eq('+i+')').show();
			tr.find('th:eq('+(i+4)+')').hide();
		}
		tr.find('th:eq(9)').find('.modifyBtn').show();
		tr.find('th:eq(9)').find('.saveBtn').hide();
		$.ajax({
			type:"post",
			url:"/ssm/modifyBook",
	        dataType:"json",
	        data:formData,
	        async: true
		});
	});
});