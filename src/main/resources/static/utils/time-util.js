
// test
window.dayjs = dayjs

export const TimeStyleEnum = {
  YMD: 'YYYY-MM-DD',
  YMDHM: 'YYYY-MM-DD HH:mm'
}

export const TimeGranularityEnum = {
  YEAR: 'YEAR',
  MONTH: 'MONTH',
  WEEK: 'WEEK',
  DAY: 'DAY',
  HOUR: 'HOUR',
  MINUTE_30: 'MINUTE_30',
  MINUTE_15: 'MINUTE_15',
  MINUTE_10: 'MINUTE_10',
  MINUTE_1: 'MINUTE_1'
}

export const TimeGranularityStyleMap = {
  YEAR: 'YYYY-MM',
  MONTH: 'YYYY-MM',
  WEEK: 'YYYY-MM-DD',
  DAY: 'MM-DD',
  HOUR: 'HH:mm',
  MINUTE_30: 'HH:mm',
  MINUTE_15: 'HH:mm',
  MINUTE_10: 'HH:mm',
  MINUTE_1: 'HH:mm'
}

export default {
  format (timer, style) {
    if (!timer || timer === 'null') {
      return '-'
    }
    return dayjs(timer).format(style)
  },
  formatByGranularity (timer, timeGranularity) {
    if (!timer || timer === 'null') {
      return '-'
    }
    return dayjs(timer).format(TimeGranularityStyleMap[timeGranularity])
  }
}
