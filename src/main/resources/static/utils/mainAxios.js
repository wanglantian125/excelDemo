import axios from 'axios'
import logger from '@/framework/utils/logger'
import qs from 'qs'
import Vue from 'vue'
let baseUrl = ''

export const AxiosRequest = {
  GET: 'get',
  POST: 'post',
  PUT: 'put',
  DELETE: 'delete',
  HEAD: 'head',
  PATCH: 'patch'
}

export const AxiosResponseType = {
  BLOB: 'blob',
  ARRAY_BUFFER: 'arraybuffer',
  DOCUMENT: 'document',
  JSON: 'json',
  TEXT: 'text',
  STREAM: 'stream'
}
export const DateStyle = {
  YMD: 'YYYY-MM-DD',
  YMDHM: 'YYYY-MM-DD HH:mm',
  YMDHMS: 'YYYY-MM-DD HH:mm:ss',
  HM: 'HH:mm',
  MD: 'MM-DD',
  YM: 'YYYY-MM'
}
const axiosDownloadInstance = axios.create({
  baseURL: baseUrl,
  // baseURL: 'http://10.154.8.23:18001',
  responseType: AxiosResponseType.BLOB,
  paramsSerializer: params => qs.stringify(params, { indices: false })
})

const catchFun = fFun => () => {
  // if (process.env.NODE_ENV !== 'production') {
  fFun ? fFun() : logger.error('系统繁忙，请稍候重试.')
}

const makeDownloadAxios = method => (url, data, sFun, fFun) => {
  const config = {
    method,
    url,
    data,
    headers: {}
  }
  if (method === AxiosRequest.GET) {
    config.params = data
    delete config.data
  }
  const configUrl = Vue.prototype.$config
  baseUrl = configUrl.BASE_URL
  // 将token塞到请求头中
  if (localStorage.getItem('inmsToken')) {
    _.merge(config.headers, {
      Authorization: 'Bearer ' + localStorage.getItem('inmsToken')
    })
  }
  axiosDownloadInstance
    .request(config)
    .then(response => {
      sFun && sFun(response)
    })
    .catch(catchFun(fFun))
}
const postDownloadAxios = makeDownloadAxios(AxiosRequest.POST)

export { postDownloadAxios }
