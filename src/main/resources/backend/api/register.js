function registerApi(data) {
    return $axios({
        'url': '/user/register',
        'method': 'post',
        data
    })
}

