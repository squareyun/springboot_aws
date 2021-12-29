// 추후 index.mustache에 동일 이름의 함수가 덮어지지 않도록 스코프(유효범위)를 만들어 사용
var main = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save: function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
};

main.init();