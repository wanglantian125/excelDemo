
export function getHeight (node) {
  return getBoundingRect(node).height
}

export function getWidth (node) {
  return getBoundingRect(node).width
}

export function getPageScrollX () {
  const t = document.documentElement || document.body.parentNode
  return typeof t.scrollLeft === 'number' ? t.scrollLeft : document.body.scrollLeft
}

export function getPageScrollY () {
  const t = document.documentElement || document.body.parentNode
  return typeof t.scrollTop === 'number' ? t.scrollTop : document.body.scrollTop
}

/**
 * 获取节点相对于所在容器的位置.
 * @param {Node} node 节点
 * @param {Node} containerNode 容器节点
 */
export function getBoundingRect (node, containerNode) {
  const nodeRect = node.getBoundingClientRect()
  if (!containerNode) {
    return nodeRect
  }
  const containerRect = containerNode.getBoundingClientRect()
  return {
    top: nodeRect.top - containerRect.top,
    left: nodeRect.left - containerRect.left,
    bottom: containerRect.bottom - nodeRect.bottom,
    right: containerRect.right - nodeRect.right,
    height: nodeRect.height,
    width: nodeRect.width,
    x: nodeRect.x - containerRect.x,
    y: nodeRect.y - containerRect.y
  }
}

export default {

}
