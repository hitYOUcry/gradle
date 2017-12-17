//number

//byte char short int long BigInteger
// def 幅值自动转换
def a = 1
assert a instanceof Integer

// Integer.MAX_VALUE
def b = 2147483647
assert b instanceof Integer

// Integer.MAX_VALUE + 1
def c = 2147483648
assert c instanceof Long

// Long.MAX_VALUE
def d = 9223372036854775807
assert d instanceof Long

// Long.MAX_VALUE + 1
def e = 9223372036854775808
assert e instanceof BigInteger

// 0b 0 0x 二进制 八进制 十六进制
int xInt = 0b10101111
assert xInt == 175
xInt = 077
assert xInt == 63
xInt = 0x77
assert xInt == 119

// 浮点数
def f = 1.1
assert f instanceof BigDecimal

def g = 1.12334f
assert g instanceof Float

def h = 1.12334d
assert h instanceof Double
//assert f instanceof Float
//assert f instanceof Double

// 下划线区分长数字以及类型后缀截图
a = 100_0000_0000_0000g
assert a instanceof BigInteger
a = 100_0000_0000_0000.0g
assert a instanceof BigDecimal