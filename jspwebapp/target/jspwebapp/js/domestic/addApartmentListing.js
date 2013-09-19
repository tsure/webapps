$(function() {
	var pstyle = 'border: 1px solid #dfdfdf; padding: 5px;';
	$().w2destroy('layout');	
	var pstyle = 'border: 1px solid #dfdfdf; padding: 5px;';
	$('#layout').w2layout({
		name : 'layout',
		panels : [ {
			type : 'top',
			size : 50,
			style : pstyle,
			content : ''
		}, {
			type : 'left',
			size : 50,
			style : pstyle,
			content : ''
		}, {
			type : 'main',
			style : pstyle,
			content : '',
				tabs: {
					active: 'tab1',
					tabs: [
						{ id: 'tab1', caption: 'Tab 1' },
						{ id: 'tab2', caption: 'Tab 2' },
						{ id: 'tab3', caption: 'Tab 3' },
					],
					onClick: function (target, data) {
						if(target === "tab1"){
							w2ui['layout'].load('main', '/jspwebapp/addListingForm.html')
						} else {
							this.owner.content('main', target);
						}
						
					}
				}
		}, {
			type : 'right',
			style : pstyle,
			size : 50,
			content:''
		} ]
	});
	
	w2ui['layout'].load('main', '/jspwebapp/addListingForm.html')
})