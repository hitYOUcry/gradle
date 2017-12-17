// default imports
/*
import java.lang.*
import java.util.*
import java.io.*
import java.net.*
import groovy.lang.*
import groovy.util.*
import java.math.BigInteger
import java.math.BigDecimal
*/

// import aliasing
import static Calendar.getInstance as now
import java.lang.reflect.*
import java.util.Date
import java.sql.Date as SQLDate

assert now().class == Calendar.getInstance().class

//public static void main vs script
class Main {                                    
    static void main(String... args) {          
        println 'Groovy world!'  
    }
}
//reflect call default package class
/*
Class fooClass = Class.forName("Two"); 
Method fooMethod = fooClass.getDeclaredMethod("main", String[].class);
// Method fooMethod = fooClass.getDeclaredMethod("sb", null);
String[][] args = [["1","2","3"]]//I am so clever ^^
assert args instanceof String[][]
fooMethod.invoke(fooClass,args) 
*/


/*script compiled into a class
println 'Groovy world!'
import org.codehaus.groovy.runtime.InvokerHelper
class Main extends Script {                     
    def run() {                                 
        println 'Groovy world!'                 
    }
    static void main(String[] args) {           
        InvokerHelper.runScript(Main, args)     
    }
}
*/
import com.nemo.One
One.main()