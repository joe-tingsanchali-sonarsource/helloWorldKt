import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

fun main() {
//    println("Hello World!")
    println("What's your name?")
    val name = readLine()
    println("Hello, $name!")
//    println("Hello World!")
}

fun vulnerableFunction() {
    val password = "password" // Vulnerability - hardcoded password
    if (!password.isBlank())println("null password!")
}

// Code Smell - Empty function
fun emptyFunction() {
}

fun buggyFunction(str: String){
    if (str == "hello"){
        println("Hello!")
    } else if (str == "goodbye"){
        println("Goodbye!")
    } else if (str == "hello"){ // Bug - Duplicate condition
        println("Hello again!")
    }
}

// Trust All Cert
// Create a trust manager that does not validate certificate chains
val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
    override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        throw UnsupportedOperationException("checkClientTrusted: Not supported yet.");
    }

    override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        require(chain != null) {
//            d("Certificate is null or empty")
        }
        require(!(authType == null || authType.isEmpty())) {
//            d("Auth type is null or empty")
        }
        try {
            chain?.firstOrNull()?.checkValidity()
        } catch (e: Exception) {
//            Helper.logExceptionOnFirebase(e)
            throw CertificateException("Certificate is not valid or trusted")
        }

    }

    override fun getAcceptedIssuers(): Array<X509Certificate> {
        return arrayOf()
    }
})

