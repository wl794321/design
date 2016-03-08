$(function() {
	//左侧菜单切换
	$('#slider-sub .menu li a').click(function() {
		var _link = $(this).attr('_link');

		$('#main').attr('src', _link);
		$(this).addClass('current-menuleft').parent().siblings().children().removeClass('current-menuleft');
		$(this).parents('.menu').siblings().find('li a').removeClass('current-menuleft');
	});

});
$('#t1').click(function() {
	if ($('#t1 a span').hasClass('glyphicon glyphicon-chevron-up pull-right')) {
		$('#t1 a span').removeClass('glyphicon glyphicon-chevron-up pull-right').addClass('glyphicon glyphicon-chevron-down pull-right');
		//收起
	} else {
		$('#t1 a span').removeClass('glyphicon glyphicon-chevron-down pull-right').addClass('glyphicon glyphicon-chevron-up pull-right');
		//展开
	}
});
$('#t2').click(function() {
	if ($('#t2 a span').hasClass('glyphicon glyphicon-chevron-up pull-right')) {
		$('#t2 a span').removeClass('glyphicon glyphicon-chevron-up pull-right').addClass('glyphicon glyphicon-chevron-down pull-right');
		//收起
	} else {
		$('#t2 a span').removeClass('glyphicon glyphicon-chevron-down pull-right').addClass('glyphicon glyphicon-chevron-up pull-right');
		//展开
	}
});
$('#t3').click(function() {
	if ($('#t3 a span').hasClass('glyphicon glyphicon-chevron-up pull-right')) {
		$('#t3 a span').removeClass('glyphicon glyphicon-chevron-up pull-right').addClass('glyphicon glyphicon-chevron-down pull-right');
		//收起
	} else {
		$('#t3 a span').removeClass('glyphicon glyphicon-chevron-down pull-right').addClass('glyphicon glyphicon-chevron-up pull-right');
		//展开
	}
});
$('#t4').click(function() {
	if ($('#t4 a span').hasClass('glyphicon glyphicon-chevron-up pull-right')) {
		$('#t4 a span').removeClass('glyphicon glyphicon-chevron-up pull-right').addClass('glyphicon glyphicon-chevron-down pull-right');
		//收起
	} else {
		$('#t4 a span').removeClass('glyphicon glyphicon-chevron-down pull-right').addClass('glyphicon glyphicon-chevron-up pull-right');
		//展开
	}
});