import { download, getFileNameByResponseHeaders, getFileNameByTime } from './fileApi'
import { postDownloadAxios } from './mainAxios'

// 文件下载类型，对应api/exporter/{type}的type
export const FileDownloadType = {
  SITE: 'site',
  SITE_PROVINCE: 'siteProvince'
}

function downloadFile (url, body) {
  postDownloadAxios(url, body, ({ headers, data }) => {
    download(
      data,
      getFileNameByResponseHeaders(headers) || getFileNameByTime()
    )
  })
}

export default {
  downloadFile
}
