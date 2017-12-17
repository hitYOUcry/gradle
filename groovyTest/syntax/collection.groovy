//import java.util.LinkedList
//Lists Groovy lists are plain JDK java.util.List
def nums = [1,"2",3]
assert nums instanceof ArrayList

nums = [1,"2",3] as LinkedList

assert nums instanceof LinkedList

assert nums[0] instanceof Integer

assert nums[1] instanceof String

nums << true

assert nums[-1] instanceof Boolean

//Arrays
String[] strArr = ["a","b","v"]
assert strArr instanceof String[]
assert !(strArr instanceof List)

def numArr = [1, 2, 3] as int[]

assert numArr.length == 3

//Maps

def colors = ["red":"#ff0000", green:"#00ff00", blue:"#0000ff"]

assert colors['red'] == colors.red

assert colors instanceof LinkedHashMap