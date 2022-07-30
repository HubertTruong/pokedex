package com.services

import com.pokedex.models.{Pokemon, PokedexAsyncService}
import monix.eval.Task
import com.pokedex.Http 
import spray.json_
import DefaultJsonProtocol._ 
import com.pokedex.AsyncHttp

trait PokedexService {
    def getPokemon() : Seq[Pokemon]
    def getAllPokemons() : Seq[Pokedex]
    //def whereIs() :
    //def match() :
}

trait PokedexAsyncService {
    def getPokemon() : Task[Seq[Pokemon]]
    def getAllPokemons() : Task[Seq[Pokedex]]
    //def whereIs() :
    //def match() :
}

class PokedexServiceOnHttp(http: Http) extends PokedexService {
    def getPokemon() : Seq[Pokemon] = {
        http.get("https://pokeapi.co/api/v2/pokemon/id")
        .parseJson
        .asJsObject
        .fields("pokemon")
        .convertTo[Seq[Pokemon]]
    }

    def getAllPokemons() : Seq[Pokedex] = {
        http.get("https://pokeapi.co/api/v2/pokemon")
        .parseJson
        .asJsObject
        .fields("pokemon")
        .convertTo[Seq[Pokedex]]
    }

    //def whereIs() :
    //def match() :
}

class PokedexAsyncServiceOnHttp(http: AsyncHttp) extends PokedexAsyncService {
    def getPokemon() : Seq[Pokemon] = {
        http.get("https://pokeapi.co/api/v2/pokemon/id")
        .parseJson
        .asJsObject
        .fields("pokemon")
        .convertTo[Seq[Pokemon]]

    def getAllPokemons() : Task[Seq[Pokedex]] = {}
        http.get("https://pokeapi.co/api/v2/pokemon")
        .map(content => content
        .parseJson.asJsObject
        .fields("pokemon")
        .convertTo[Seq[Pokedex]])
    }

    //def whereIs() :
    //def match() :
}