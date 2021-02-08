export default {
  fakeClick (obj) {
    const ev = document.createEvent('MouseEvents')
    ev.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null)
    obj.dispatchEvent(ev)
  },

  export (name, data) {
    const urlObject = window.URL || window.webkitURL || window
    const exportBlob = new Blob([data])
    const saveLink = document.createElementNS('http://www.w3.org/1999/xhtml', 'a')
    saveLink.href = urlObject.createObjectURL(exportBlob)
    saveLink.download = name
    this.fakeClick(saveLink)
  }
}
