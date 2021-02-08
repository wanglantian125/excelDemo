
export function isUTF8 (bytes) {
  let i = 0
  while (i < bytes.length) {
    if ((// ASCII
      bytes[i] === 0x09 ||
            bytes[i] === 0x0A ||
            bytes[i] === 0x0D ||
            (bytes[i] >= 0x20 && bytes[i] <= 0x7E)
    )
    ) {
      i += 1
      continue
    }
    if ((// non-overlong 2-byte
      (bytes[i] >= 0xC2 && bytes[i] <= 0xDF) &&
            (bytes[i + 1] >= 0x80 && bytes[i + 1] <= 0xBF)
    )
    ) {
      i += 2
      continue
    }
    if ((// excluding overlongs
      bytes[i] === 0xE0 &&
            (bytes[i + 1] >= 0xA0 && bytes[i + 1] <= 0xBF) &&
            (bytes[i + 2] >= 0x80 && bytes[i + 2] <= 0xBF)
    ) ||
            (// straight 3-byte
              ((bytes[i] >= 0xE1 && bytes[i] <= 0xEC) ||
                    bytes[i] === 0xEE ||
                    bytes[i] === 0xEF) &&
                (bytes[i + 1] >= 0x80 && bytes[i + 1] <= 0xBF) &&
                (bytes[i + 2] >= 0x80 && bytes[i + 2] <= 0xBF)
            ) ||
            (// excluding surrogates
              bytes[i] === 0xED &&
                (bytes[i + 1] >= 0x80 && bytes[i + 1] <= 0x9F) &&
                (bytes[i + 2] >= 0x80 && bytes[i + 2] <= 0xBF)
            )
    ) {
      i += 3
      continue
    }
    if ((// planes 1-3
      bytes[i] === 0xF0 &&
            (bytes[i + 1] >= 0x90 && bytes[i + 1] <= 0xBF) &&
            (bytes[i + 2] >= 0x80 && bytes[i + 2] <= 0xBF) &&
            (bytes[i + 3] >= 0x80 && bytes[i + 3] <= 0xBF)
    ) ||
            (// planes 4-15
              (bytes[i] >= 0xF1 && bytes[i] <= 0xF3) &&
                (bytes[i + 1] >= 0x80 && bytes[i + 1] <= 0xBF) &&
                (bytes[i + 2] >= 0x80 && bytes[i + 2] <= 0xBF) &&
                (bytes[i + 3] >= 0x80 && bytes[i + 3] <= 0xBF)
            ) ||
            (// plane 16
              bytes[i] === 0xF4 &&
                (bytes[i + 1] >= 0x80 && bytes[i + 1] <= 0x8F) &&
                (bytes[i + 2] >= 0x80 && bytes[i + 2] <= 0xBF) &&
                (bytes[i + 3] >= 0x80 && bytes[i + 3] <= 0xBF)
            )
    ) {
      i += 4
      continue
    }
    return false
  }
  return true
}
