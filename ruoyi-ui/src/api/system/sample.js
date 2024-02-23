import request from '@/utils/request'

// 查询样品信息管理列表
export function listSample(query) {
  return request({
    url: '/system/sample/list',
    method: 'get',
    params: query
  })
}

// 查询样品信息管理详细
export function getSample(ioId) {
  return request({
    url: '/system/sample/' + ioId,
    method: 'get'
  })
}

// 新增样品信息管理
export function addSample(data) {
  return request({
    url: '/system/sample',
    method: 'post',
    data: data
  })
}

// 修改样品信息管理
export function updateSample(data) {
  return request({
    url: '/system/sample',
    method: 'put',
    data: data
  })
}

// 删除样品信息管理
export function delSample(ioId) {
  return request({
    url: '/system/sample/' + ioId,
    method: 'delete'
  })
}
