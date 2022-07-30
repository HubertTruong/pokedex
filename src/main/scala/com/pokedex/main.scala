package com.pokedex

import okhttp3.OkHttpClient
import okhttp3.{Request, OkHttpClient}

class main {
  def main(args: Array[String]): Unit = {
    val url = "https://pokeapi.co/api/v2/pokemon/35"
    val client = new OkHttpClient

    val request = new OkHttpClient().url(url).build

    val response = client.newCall(request).execute
    Console.println(response.body.string)

  }
}
