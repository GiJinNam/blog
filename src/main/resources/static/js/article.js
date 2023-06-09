const deleteButton = document.getElementById('delete-btn');
const modifyButton = document.getElementById('modify-btn');
console.log('이거 왜 업데이트 안되냐ㅕ?')

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        // 아이디 값은 잘 나옴 근데 넘어갈때 id값이 쓰레기값이 되어버림 ..?
        console.log(id);
        let api = '/api/articles/' + id;
        fetch(api, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제가 완료되었습니다');
                location.replace('/articles');
            })
            .catch(error => {
                console.error('Deletion error:', error);
            })
    })
};

if(modifyButton) {
    modifyButton.addEventListener('click' ,event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch('api/articles/' + id, {
            method:'PUT',
            headers: {
                "Content-Type" : "application/json",
            },
            body:JSON.stringify({
                title : document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then(()=> {
                alert('수정완료');
                location.replace('/articles/' + id);
            });
    });
}

const createButton = document.getElementById("create-btn");
if(createButton) {
    createButton.addEventListener("click",(event) => {
        fetch("/api/articles", {
            method: "POST",
            headers : {
                "Content-Type" : "application/json",
            },
            body:JSON.stringify({
                title: document.getElementById("title").value,
                content: document.getElementById("content").value,
            }),
            }).then(()=> {
                alert('등록완료');
                location.replace("/articles");
            })
        });
}