# AulaRetrofit
 
## Adicionando bibliotecas do Retrofit no arquivo build.grade do Modulo App

O que é retrofit: 
https://square.github.io/retrofit/
```
// biblioteca do retrofit
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
// biblioteca do conversor gson
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
// biblioteca de download de imagens (url)
implementation 'io.coil-kt:coil:1.2.0'
```		

## Implementando classes baseado no JSON do serviço

O que é JSON: https://www.json.org/json-pt.html<br/>

## Classe Amigo (Friend)

```kotlin
class Friend {
    var name: String = ""
    var online: Boolean = false
    var messages: Int = 0
    var id: String = ""
    var email: String = ""
    var picture: String = ""
}
```

## Implementando Serviço para consumir os métodos da API

### FriendService

```kotlin
import br.com.cotemig.aularetrofit.models.Friend
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface FriendService {

    // assinatura do método de obter amigos com o endpoint account/friends
    // esse método possui um Header (token)
    // retorna a lista de amigos do usuário logado
    @GET("account/friends")
    fun getFriends(@Header("token") token: String): Call<List<Friend>>

}
```

## Implementando RetrofitInitializer

```kotlin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val URL = "https://api.falaai.app/v1/"

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getFriendService(): FriendService {
        return retrofit.create(FriendService::class.java)
    }

}
```

## Chamando Serviço no MainActivity

```kotlin

    fun getFriends() {
        var s = RetrofitInitializer().getFriendService()
        var call = s.getFriends("SUA MATRICULA")

        call.enqueue(object : retrofit2.Callback<List<Friend>> {
            override fun onResponse(call: Call<List<Friend>>, response: Response<List<Friend>>) {

                response.body()?.let {

                    Toast.makeText(this@MainActivity, "Amigos: ${it.size}", Toast.LENGTH_LONG)
                        .show()

                }

            }

            override fun onFailure(call: Call<List<Friend>>, t: Throwable) {

            }
        })

    }

```

## Liberando permissão de Internet no arquivo Manifest

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

## Arredondamento da imagem do Avatar

```kotlin
avatar.load(list[p0].avatar) {
    transformations(RoundedCornersTransformation(100f))
}
```        

