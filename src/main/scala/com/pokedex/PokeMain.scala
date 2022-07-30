import com.pokedex.services.PokedexService

object PokeMain {
    def main(args: Array[String]): Unit = 
        val pokeSvc = new PokedexService(http = new AsyncHttp)

        pokeSvc.getAllPokemons().runAsync {
            case Left(err) =>
                println(s"Got error: ${err.toString}")
            case Right(units) =>
                println(units.head)
        }

        pokeSvc.getPokemon().runAsync {
            case Left(err) =>
                println(s"Got error: ${err.toString}")
            case Right(units) =>
                println(units.head)
        }

        /*pokeSvc.whereis().runAsync {
            
        }

        pokeSvc.match().runAsync {
            
        }*/
}