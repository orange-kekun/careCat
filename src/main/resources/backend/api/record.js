// 查询列表接口
const getRecordPage = (params) => {
    return $axios({
        url: '/record/page',
        method: 'get',
        params
    })
}

// 新增接口
const addRecord = (params) => {
    return $axios({
        url: '/record',
        method: 'post',
        data: { ...params }
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
