package br.com.cotemig.aularetrofit.services

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