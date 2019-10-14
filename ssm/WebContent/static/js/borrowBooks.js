// choose 搜索类型小箭头移动
const navs = document.getElementsByClassName('searchType');
for (let index = 0; index < navs.length; index++) {
    navs[index].addEventListener('click', () => {  
        let distance = index * navs[index].offsetWidth-380;
        if(index == 0){
            distance -= 29;
        }                 
        document.getElementById('choose').style.left = distance + "px";
    });
}


// 弹出图书
function showWindow(bookId) {
    $('.jump-container').show();  //显示弹出的图书
    $('#cover').show(); //显示遮罩层
    $('body').css('overflow', 'hidden'); //弹出层的时候就不会触发外面的 scroll事件
    
    $.ajax({
		type:"post",
		url:"/ssm/getBrief",
        dataType:"json",
        data:{bookId:bookId},
        async: true,
		success:function(result){
			$("#book_img").attr("src",result.bookMsg.bookCover);
			$("#author_img").attr("src",result.authorMsg.authorPhoto);
			$("#bookNameSpan").text(result.bookMsg.bookName);
			$("#publishTimeSpan").text(result.bookMsg.publishTime);
			$("#authorNameSpan").text(result.authorMsg.authorName);
			$("#birthSpan").text(result.authorMsg.authorBirth);
			$("#publisherSpan").text(result.bookMsg.publisher);
			$("#borrowNumSpan").text(result.bookMsg.borrowNum);
		},
		error:function(){
			console.log("简介获取失败");
		}
	});
}


//图书翻页
let suo = false;//设置一个锁 防止拼命点
document.getElementById('fanye').onclick = () => {
    if (!suo) {
        suo = true;
        let isRotate = true;//是否翻页
        document.getElementsByClassName('page')[0].classList.forEach(val => {
            isRotate = val == 'rotate' ? false : true;//判断一下class里面有没有那个rotate这个属性
        });
        if (isRotate) {
            //没有则添加
            rotateTranstion("", 'add');
        } else {
            //有则删除
            rotateTranstion("guanbi 1.5s 1 forwards ease-in", 'remove');
            setTimeout(() => {
            	$('.jump-container').hide();
            	$('#cover').hide();
            	//防止animation动画保存在其中，防止下次自动执行一下合页操作，这时候要清除一下动画
            	document.getElementsByClassName('page')[0].style.animation = "";
            	$('body').css('overflow', '');
            }, 1600);
        }
    }
    /*return false;*/ //阻止事件冒泡、同时也阻止当前事件的执行
}
//触发的animation动画 是否是添加还是删除类,z-index的值，按钮文本
function rotateTranstion(animation, isAdd) {
    document.getElementsByClassName('page')[0].style.animation = animation;
    document.getElementsByClassName('page')[0].classList[isAdd]('rotate');
    setTimeout(() => {
        suo = false;
    }, 1000);
}

//search
$(function() {
	$('#search').on('click', function() {
		let searchContext = $('#searchContext').val();
		if(searchContext == null){
			alert("请输入关键字");
			return;
		}
		let byType = "byBook";
		if($('#choose').css("left") != '-410px'){
			byType = "byAuthor";
		}
		$("#go").attr("href","/ssm/getBooks?searchContext="+searchContext+"&byType="+byType);
	})
});