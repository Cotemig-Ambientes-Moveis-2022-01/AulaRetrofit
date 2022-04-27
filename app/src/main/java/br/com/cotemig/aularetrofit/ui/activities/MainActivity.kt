package br.com.cotemig.aularetrofit.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cotemig.aularetrofit.R
import br.com.cotemig.aularetrofit.models.Friend
import br.com.cotemig.aularetrofit.services.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getFriends()
    }

    fun getFriends() {
        var s = RetrofitInitializer().getFriendService()
        var call = s.getFriends("7vjf3r5gkeds91g1k3e9ar")

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
}