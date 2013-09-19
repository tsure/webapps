$(function(){
	$('#form').w2form({ 
		name     : 'form',
		url      : 'server/post',
		formURL  : 'addListingForm.html', 
		fields: [
			{ name: 'field_text', type: 'text', required: true },
			{ name: 'field_alpha', type: 'alphaNumeric', required: true },
			{ name: 'field_int', type: 'int', required: true },
			{ name: 'field_float', type: 'float', required: true },
			{ name: 'field_date', type: 'date' },
			{ name: 'field_list', type: 'list', required: true, 
				options: { items: ['Adams, John', 'Johnson, Peter', 'Lewis, Frank', 'Cruz, Steve', 'Donnun, Nick'] } },
			{ name: 'field_enum', type: 'enum', required: true, 
				options: { items: ['Adams, John', 'Johnson, Peter', 'Lewis, Frank', 'Cruz, Steve', 'Donnun, Nick'] } },
			{ name: 'field_textarea', type: 'text'}
		],
		actions: {
			reset: function () {
				this.clear();
			},
			save: function () {
				var obj = this;
				this.save({}, function (data) { 
					if (data.status == 'error') {
						console.log('ERROR: '+ data.message);
						return;
					}
					obj.clear();
				});
			}
		}
	});
})