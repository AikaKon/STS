$(function(){
    $(".menuItem").on("click", function(){
        switchingShowContent(this);
    });

    var id ;
    //アカウント開設
    $("#accountOpning").on("click", function(){
    	$("#loading").css("display", "block");
        $("#accountOpningErea").addClass("none");
        $("#accountMenu").removeClass("none");
        
        $.ajax('http://localhost:8080/bankTrading/accountOpening',
        			{
        				type: 'Post'
        			}
        　　　	)
        .done(function(request) {
                //通信後の処理　通信結果はrequestに格納されている
                　			console.log(request);
                	id = request.id;//今のidをとりたい
                	$("#loading").css("display", "none");
               })
        	 	// 通信失敗時
               .fail(function(errow) {
                	window.alert('正しい結果を得られませんでした。');
                	console.log(errow);
                	$("#loading").css("display", "none");
               });
    });
    
    //残高
    $("#checkBalance").on("click",function(){
    	$("#loading").css("display", "block");
    	  $.ajax('http://localhost:8080/bankTrading/'+id,
    	        	{
    	        		type: 'Get',
    	        		data: {key: 'value' }
    	        	}
    	        )
    	        .done(function(request) {
    	        	 //通信後の処理
    	        	$('#zan').text(request.balance);
    	        	console.log(request);    	
                	$("#loading").css("display", "none");
    	        })
    	        	 // 通信失敗時
    	        .fail(function(errow) {
    	        	 window.alert('正しい結果を得られませんでした。');
    	        	 console.log(errow);
                 	$("#loading").css("display", "none");
    	        });
    });
    
    //入金	
    $("#btn").on("click",function(){
    	$("#loading").css("display", "block");
    	  var sendData = {"amount":$('#azu').val()};//送るjson形式で
    	  console.log($('#azu').val());	
    	  
    	  $.ajax('http://localhost:8080/bankTrading/depositMoney/'+id,
    	        	{
    	       			type: 'PUT',
    	       			data: JSON.stringify(sendData),
    	       			contentType: 'application/json'
    	        	}
   	        　　　　　　    )
   	            .done(function(request) {
    	         //通信後の処理
    	        　		console.log(request);
//    	        　		$('#zan').text(request.balance);
                    	$("#loading").css("display", "none");
   	            })
    	        // 通信失敗時
   	            .fail(function(errow) {
   	        	    window.alert('正しい結果を得られませんでした。');
   	        	    console.log(errow);
                	$("#loading").css("display", "none");
   	            });
    });
    	
    //出金
    $("#hiki").on("click",function(){
    	$("#loading").css("display", "block");
    	  var sendData2 = {"amount":$('#en').val()};//送るjsonで
    	  console.log($('#en').val());	
    	  
    	  $.ajax('http://localhost:8080/bankTrading/withdrawal/'+id,
    	        	{
    		　　			type: 'PUT',
    		  			data: JSON.stringify(sendData2),
    		  			contentType: 'application/json'
    	        	}
    	         )
    	         .done(function(request) {
    	        	 //通信後の処理
    	        	  console.log(request);
//    	        	  $('#zan').text(request.balance);//残高のbalance  	
                  	$("#loading").css("display", "none");
    	         })
    	        	 // 通信失敗時
    	         .fail(function(errow) {
    	        	  window.alert('正しい結果を得られませんでした。');
    	        	  console.log(errow);
    	         });
    });
});

// メニューを選択した時の画面表示の切り替え
// 引数はクリックされたDOM自身が入ってくるのを想定しておく
function switchingShowContent(targetElement){
    classInit();
    // id名を自身から取得して、removeClassする対象を決定する
    var idName = $(targetElement).attr("id");
    $("#" + idName + "Erea").removeClass("none");
}

// classがあるので、それを利用して一括でcss反映
function classInit(){
    $(".content").addClass("none");
}


