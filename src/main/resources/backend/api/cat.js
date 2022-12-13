// 查询列表接口
const getCatPage = (params) => {
    return $axios({
        url: '/cat/page',
        method: 'get',
        params
    })
}


// 删除接口
const deleteCat = (ids) => {
    return $axios({
        url: '/cat',
        method: 'delete',
        params: { ids }
    })
}

// 修改接口
const editCat = (params) => {
    return $axios({
        url: '/cat',
        method: 'put',
        data: { ...params }
    })
}

// 新增接口
const addCat = (params) => {
    return $axios({
        url: '/cat',
        method: 'post',
        data: { ...params }
    })
}

// 查询详情
const queryCatById = (id) => {
    return $axios({
        url: `/cat/${id}`,
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

