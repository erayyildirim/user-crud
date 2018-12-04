$(document).ready(function () {
    $('#phoneNumber').mask('(000)-000-00-00');
    $('.nBtn, .table .eBtn').on('click', function (e) {
        e.preventDefault();
        var href = $(this).attr('href');
        var str =  $(this).text();


        if(str == 'Edit') {
            $.get(href, function (user, status) {
                $('.modal-form #id').val(user.id);
                $('.modal-form #name').val(user.name);
                $('.modal-form #surname').val(user.surname);
                $('.modal-form #phoneNumber').val(user.phoneNumber);

            })
            $('.modal-form #exampleModal').modal();
        }
        else {
            $('.modal-form #id').val('');
            $('.modal-form #name').val('');
            $('.modal-form #surname').val('');
            $('.modal-form #phoneNumber').val('');
            $('.modal-form #exampleModal').modal();
        }
    });

    $("#newModalForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 3
            },
            surname: {
                required: true,
                minlength: 3
            },
            phoneNumber: {
                required: true,
                minlength: 15
            },
            action: "required"
        },
        messages: {
            name: {
                required: "Please enter some data",
                minlength: "Your data must be at least 3 characters"
            },
            surname: {
                required: "Please enter some data",
                minlength: "Your data must be at least 3 characters"
            },
            phoneNumber: {
                required: "Please enter some data",
                minlength: "Your data must be at least 10 characters"
            },
            action: "Please provide some data"
        }
    });
})