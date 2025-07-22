// 日期格式化
export function formatDate(date, fmt = 'yyyy-MM-dd') {
  if (!date) return ''
  if (typeof date === 'string') return date
  
  const o = {
    'M+': date.getMonth() + 1,
    'd+': date.getDate(),
    'h+': date.getHours(),
    'm+': date.getMinutes(),
    's+': date.getSeconds()
  }
  
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length))
  }
  
  for (const k in o) {
    if (new RegExp(`(${k})`).test(fmt)) {
      fmt = fmt.replace(
        RegExp.$1,
        RegExp.$1.length === 1 ? o[k] : (`00${o[k]}`).substr((`${o[k]}`).length))
    }
  }
  
  return fmt
}

// 字符串转Date
export function parseDate(str) {
  if (!str) return null
  return new Date(str.replace(/-/g, '/')) // 解决iOS兼容性问题
}