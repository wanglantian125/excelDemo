/**
 * 文件下载.
 */

import { AxiosRequest, DateStyle } from './mainAxios'

/**
 * 根据流文件response的headers获取文件名.
 */
export const FileType = {
  XLS: 'xls',
  XLSM: 'xlsm',
  TXT: 'txt'
}

export const getFileNameByResponseHeaders = headers => {
  const cd = headers['content-disposition']
  if (cd && _.isString(cd)) {
    const cdArr = cd.split('=')
    if (cdArr && _.isArray(cdArr)) {
      return decodeURI(cdArr[1])
    }
  }
  return null
}

/**
 * 根据当前时间生成文件名.
 * @param {string} fileSuffix 文件后缀
 */
export const getFileNameByTime = (fileSuffix = FileType.XLS) => {
  return `${dayjs().format(DateStyle.YMDHMS)}.${fileSuffix}`
}

/**
 * 根据返回的文件流进行文件的下载.
 */
export const download = (fileBlob, fileName) => {
  const a = document.createElement('a')
  if ('download' in a) {
    // chrome、firefox...
    const fileUrl = URL.createObjectURL(fileBlob)
    a.href = fileUrl
    a.download = fileName
    a.style.display = 'none'
    document.body.appendChild(a)
    a.click()
    URL.revokeObjectURL(fileUrl)
    document.body.removeChild(a)
  } else {
    // IE10+
    navigator.msSaveBlob(fileBlob, fileName)
  }
}

/**
 * @deprecated
 *
 * form表单提交进行文件下载.
 * 1.请求参数多，处理比较麻烦
 * 2.权限认证的header添加不了
 * 3.设置了form的target为什么没生效？
 */
export const downloadByForm = (url, params, method = AxiosRequest.POST) => {
  const iframe = document.createElement('iframe')
  iframe.name = 'download-iframe'
  document.body.appendChild(iframe)
  iframe.onload = function () {
    const form = document.createElement('form')
    form.style.display = 'none'
    form.method = method
    form.action = url
    form.target = 'download-iframe'

    for (const key in params) {
      const input = document.createElement('input')
      input.type = 'hidden'
      input.name = key
      input.value = params[key]
      form.appendChild(input)
    }

    document.body.removeChild(iframe)
    document.body.appendChild(form)
    form.submit()
    document.body.removeChild(form)
  }
}
