
import store from '@/framework/store'

export default {
  wsHandler () {
    return {
      dataHandler: this.addNotice.bind(this),
      'sys.heartbeat': this.receiveHeartbeat(this),
      errorHandler: () => { },
      closeHandler: () => { }
    }
  },
  addNotice (data) {
    store.dispatch('systemNotice/insertSystemNotice', data)
  },
  receiveHeartbeat () {
    // logger.info('服务端发来心跳感应，连接正常！')
  }
}
