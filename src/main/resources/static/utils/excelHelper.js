// eslint-disable-next-line camelcase
import { export_json_to_excel } from './Export2Excel'
import { isUTF8 } from './isUTF8'
import XLSX from 'xlsx'
/* import cptable from 'codepage' */
const cptable = require('codepage/dist/cpexcel.full')
/* var cptable = require('codepage')
 */
export default {
  // name
  // sheets
  // [
  // {
  // sheetName
  // dataList
  // header [{key:字段名,title:表头名,children[] 二级表头,一级可合并}]
  // }
  // ]
  /* {
    title: '传输专线',
    align: 'center',
    children: [
      {
        title: 'AAA',
        key: 'transAAANum',
        align: 'center',
        width: 80
      },
      {
        title: 'AA',
        key: 'transAANum',
        align: 'center',
        width: 80
      },
      {
        title: 'A',
        key: 'transANum',
        align: 'center',
        width: 80
      },
      {
        title: '普通',
        key: 'transNormalNum',
        align: 'center',
        width: 80
      }
    ]
  } */

  exportExcel (excelData) {
    export_json_to_excel(excelData)
  },

  callback: null,
  importExcel (callbackFunction) {
    this.callback = callbackFunction
    let inputObj = document.getElementById('_ef')
    if (!inputObj) {
      inputObj = document.createElement('input')
      // 设置属性
      inputObj.setAttribute('id', '_ef')
      inputObj.setAttribute('type', 'file')
      inputObj.setAttribute('style', 'visibility:hidden')
      /*       inputObj.setAttribute('accept', '.csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel')
 */ // 添加到DOM中
      document.body.appendChild(inputObj)

      // 添加事件监听器
      inputObj.addEventListener('change', this.updatePath.bind(this))
    }
    // 模拟点击
    inputObj.click()
  },
  updatePath: function () {
    const inputObj = document.getElementById('_ef')
    const files = inputObj.files
    let isCSV = false
    // 移除事件监听器
    inputObj.removeEventListener('change', function () { })
    // 从DOM中移除input
    document.body.removeChild(inputObj)
    try {
      if (files.length > 1) {
        this.$message.warning('当前仅支持选择一个文件!')
      } else {
        const file = files[0]
        const types = file.name.split('.')[1]
        const fileType = ['xlsx', 'txt', 'xlc', 'xlm', 'xls', 'xlt', 'xlw', 'csv'].some(item => item === types)
        if (!fileType) {
          this.$message.warning('格式错误,请重新选择!')
          return
        }
        if (types === 'csv' || types === 'txt') {
          isCSV = true
        }
        const that = this
        this.file2Xce(file, isCSV, that).then(tabJson => {
          that.callback(tabJson)
        })
      }
    } catch (error) {
      this.callback('error')
    }
  },
  fixdata (data) { // 文件流转BinaryString
    let o = ''
    let l = 0
    const w = 10240
    for (; l < data.byteLength / w; ++l) o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w, l * w + w)))
    o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w)))
    return o
  },

  file2Xce (file, isCSV, that) {
    return new Promise(function (resolve, reject) {
      try {
        const reader = new FileReader()
        reader.onload = function (e) {
          let data = e.target.result
          let wb = null
          if (isCSV) {
            data = new Uint8Array(data)
            const f = isUTF8(data)
            if (f) {
              data = e.target.result
            } else {
              const str = cptable.utils.decode(936, data)
              const types = file.name.split('.')[1]
              if (types === 'txt') {
                that.callback({ filename: file.name, text: str })
                return
              }
              wb = XLSX.read(str, { type: 'string' })
            }
          }
          if (!wb) {
            wb = isCSV ? XLSX.read(btoa(that.fixdata(data)), { type: 'base64' }) : XLSX.read(data, { type: 'binary' })
          }

          const result = []
          wb.SheetNames.forEach((sheetName) => {
            result.push({
              sheetName: sheetName,
              sheet: XLSX.utils.sheet_to_json(wb.Sheets[sheetName], { header: 'A' })
            })
          })
          resolve(result)
        }
        if (isCSV) {
          reader.readAsArrayBuffer(file)
        } else { reader.readAsBinaryString(file) }
      } catch {
        resolve('error')
      }
    })
  }
}
