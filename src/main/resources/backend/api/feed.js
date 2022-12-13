// 查询列表接口
const getFeedPage = (params) => {
    return $axios({
        url: '/feed/page',
        method: 'get',
        params
    })
}

// 新增接口
const addFeed= (params) => {
    return $axios({
        url: '/feed',
        method: 'post',
        data: { ...params }
    })
}

// 查猫猫列表的接口
const queryCatList = () => {
    return $axios({
        url: '/cat/list',
        method: 'get'
    })
}

// 文件down预览
const commonDownload = (params) => {
    return $axios({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        url: '/common/download',
        method: 'get',
        params
    })
}
