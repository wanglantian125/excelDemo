import XLSX from 'xlsx'

const FileSaver = require('file-saver')

function generateArray (table) {
  const out = []
  const rows = table.querySelectorAll('tr')
  const ranges = []
  for (let R = 0; R < rows.length; ++R) {
    const outRow = []
    const row = rows[R]
    const columns = row.querySelectorAll('td')
    for (let C = 0; C < columns.length; ++C) {
      const cell = columns[C]
      let colspan = cell.getAttribute('colspan')
      let rowspan = cell.getAttribute('rowspan')
      let cellValue = cell.innerText
      if (cellValue !== '' && cellValue === +cellValue) cellValue = +cellValue
      // Skip ranges
      ranges.forEach(function (range) {
        if (R >= range.s.r && R <= range.e.r && outRow.length >= range.s.c && outRow.length <= range.e.c) {
          for (let i = 0; i <= range.e.c - range.s.c; ++i) outRow.push(null)
        }
      })

      // Handle Row Span
      if (rowspan || colspan) {
        rowspan = rowspan || 1
        colspan = colspan || 1
        ranges.push({
          s: {
            r: R,
            c: outRow.length
          },
          e: {
            r: R + rowspan - 1,
            c: outRow.length + colspan - 1
          }
        })
      }

      // Handle Value
      outRow.push(cellValue !== '' ? cellValue : null)

      // Handle Colspan
      if (colspan) { for (let k = 0; k < colspan - 1; ++k) outRow.push(null) }
    }
    out.push(outRow)
  }
  return [out, ranges]
}

function datenum (v, date1904) {
  if (date1904) v += 1462
  const epoch = Date.parse(v)
  return (epoch - new Date(Date.UTC(1899, 11, 30))) / (24 * 60 * 60 * 1000)
}

// eslint-disable-next-line camelcase
function sheet_from_array_of_arrays (data, opts) {
  const ws = {}
  const range = {
    s: {
      c: 10000000,
      r: 10000000
    },
    e: {
      c: 0,
      r: 0
    }
  }
  const cellRanges = []
  for (let R = 0; R !== data.length; ++R) {
    for (let C = 0; C !== data[R].length; ++C) {
      if (range.s.r > R) range.s.r = R
      if (range.s.c > C) range.s.c = C
      if (range.e.r < R) range.e.r = R
      if (range.e.c < C) range.e.c = C
      const cell = {
        v: data[R][C] && data[R][C].value ? data[R][C].value : data[R][C]
      }
      if (cell.v === null || cell.v === '' || data[R][C] === null || data[R][C] === undefined) continue
      // eslint-disable-next-line camelcase
      const cell_ref = XLSX.utils.encode_cell({
        c: data[R][C].col || C,
        r: R
      })

      if (data[R][C].rowspan > 1 || data[R][C].colspan > 1) {
        cellRanges.push({
          s: {
            c: data[R][C].col || C,
            r: R
          },
          e: {
            c: (data[R][C].col || C) + data[R][C].colspan - 1,
            r: R + data[R][C].rowspan - 1
          }
        }
        )
      }

      if (typeof cell.v === 'number') cell.t = 'n'
      else if (typeof cell.v === 'boolean') cell.t = 'b'
      else if (cell.v instanceof Date) {
        cell.t = 'n'
        cell.z = XLSX.SSF._table[14]
        cell.v = datenum(cell.v)
      } else cell.t = 's'

      ws[cell_ref] = cell
    }
  }
  if (range.s.c < 10000000) ws['!ref'] = XLSX.utils.encode_range(range)
  if (cellRanges.length > 0) {
    ws['!merges'] = cellRanges
  }
  return ws
}

function Workbook () {
  if (!(this instanceof Workbook)) return new Workbook()
  this.SheetNames = []
  this.Sheets = {}
}

function s2ab (s) {
  const buf = new ArrayBuffer(s.length)
  const view = new Uint8Array(buf)
  for (let i = 0; i !== s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF
  return buf
}
function formatJson (filterVal, jsonData) {
  return jsonData.map(v => {
    return filterVal.map(j => v[j])
  })
}

// eslint-disable-next-line camelcase
export function export_table_to_excel (id) {
  const theTable = document.getElementById(id)
  const oo = generateArray(theTable)
  const ranges = oo[1]

  /* original data */
  const data = oo[0]
  // eslint-disable-next-line camelcase
  const ws_name = 'SheetJS'

  const wb = new Workbook()
  const ws = sheet_from_array_of_arrays(data)

  /* add ranges to worksheet */
  // ws['!cols'] = ['apple', 'banan'];
  ws['!merges'] = ranges

  /* add worksheet to workbook */
  wb.SheetNames.push(ws_name)
  wb.Sheets[ws_name] = ws

  const wbout = XLSX.write(wb, {
    bookType: 'xlsx',
    bookSST: false,
    type: 'binary'
  })

  FileSaver(new Blob([s2ab(wbout)], {
    type: 'application/octet-stream'
  }), 'test.xlsx')
}

// function formatJson(jsonData) {
//   console.log(jsonData)
// }

// eslint-disable-next-line camelcase
// export function export_json_to_excel (th, jsonData, defaultTitle) {
// name
// sheets
// {
// sheetName
// dataList
// header [{key:字段名,title:表头名}]
// eslint-disable-next-line camelcase
export function export_json_to_excel (importData) {
  const wb = new Workbook()
  let index = 0
  for (const item of importData.sheets) {
    const headerData = getHeaderRows(item.header)
    // eslint-disable-next-line no-console
    console.log(headerData)

    let data = formatJson(headerData.keyList, item.dataList)
    data = headerData.headerRows.concat(data) // .unshift(item.header.map(header => header.title))

    // eslint-disable-next-line camelcase
    const ws_name = item.sheetName || '列表' + index

    const ws = sheet_from_array_of_arrays(data)

    /* add worksheet to workbook */
    wb.SheetNames.push(ws_name)
    wb.Sheets[ws_name] = ws
    index++
  }
  const wbout = XLSX.write(wb, {
    bookType: 'xlsx',
    bookSST: false,
    type: 'binary'
  })
  const title = importData.name || '列表'
  FileSaver(new Blob([s2ab(wbout)], {
    type: 'application/octet-stream'
  }), title + '.xlsx')
}

function getHeaderRows (header) {
  const result = []
  flatAndMarkLevel(header, result, 0)
  const maxLevel = _.maxBy(result, 'level').level

  const headerData = { headerRows: [], keyList: [] }
  for (let i = 0; i < maxLevel + 1; i++) {
    headerData.headerRows.push([])
    const temps = _.filter(result, item => item.level === i)
    for (let j = 0; j < temps.length; j++) {
      headerData.headerRows[i].push({
        value: temps[j].title,
        key: temps[j].key,
        colspan: temps[j].children ? temps[j].children.length : 1,
        rowspan: temps[j].children ? 1 : (maxLevel + 1) - i
      })
      if (temps[j].children) { // 填充合并项
        for (let t = 0; t < temps[j].children.length - 1; t++) {
          headerData.headerRows[i].push('')
        }
      }
    }
  }

  for (let i = 0; i < headerData.headerRows.length; i++) {
    const row = headerData.headerRows[i]
    for (let j = 0; j < row.length; j++) {
      if (!row[j]) continue

      if (row[j].key) {
        if (!headerData.keyList.includes(row[j].key)) {
          headerData.keyList.push(row[j].key)
        }
      } else { // 取子元素
        const item = _.find(result, temp => temp.title === row[j].value)
        if (item && item.children) {
          item.children.forEach((child, index) => {
            headerData.keyList.push(child.key)
            _.find(headerData.headerRows[i + 1], sub => sub.key === child.key).col = j + index
          })
        }
      }
    }
  }

  return headerData
}

function flatAndMarkLevel (header, result, level) {
  header.forEach(item => {
    item.level = level
    result.push(item)
    if (item.children && item.children.length > 0) {
      flatAndMarkLevel(item.children, result, level + 1)
    }
  })
}
