package edu.upb.cocinaya.data

import edu.upb.cocinaya.model.Post

object TempDataSource {
    val postList = mutableListOf(
        Post(
            publisher = "Andre Machicado",
            shortDescription = "Enchiladas Suizas en Microondas!",
            longDescription = "Until recently, the prevailing view assumed lorem ipsum was born as a nonsense text. “It's not Latin, though it looks like it, and it actually says nothing,” Before & After magazine answered a curious reader, “Its ‘words’ loosely approximate the frequency with which letters occur in English, which is why at a glance it looks pretty real.”\n" +
                    "\n" +
                    "As Cicero would put it, “Um, not so fast.”\n" +
                    "\n" +
                    "The placeholder text, beginning with the line “Lorem ipsum dolor sit amet, consectetur adipiscing elit”, looks like Latin because in its youth, centuries ago, it was Latin.\n" +
                    "\n" +
                    "Richard McClintock, a Latin scholar from Hampden-Sydney College, is credited with discovering the source behind the ubiquitous filler text. In seeing a sample of lorem ipsum, his interest was piqued by consectetur—a genuine, albeit rare, Latin word. Consulting a Latin dictionary led McClintock to a passage from De Finibus Bonorum et Malorum (“On the Extremes of Good and Evil”), a first-century B.C. text from the Roman philosopher Cicero.",
            imageUrl = "https://cdn7.kiwilimon.com/recetaimagen/26245/th5-320x213-38984.jpg",
            time = 15,
            likes = 256
        ),
        Post(
            publisher = "Joel Jarro",
            shortDescription = "Carne a la parrilla, sin parrilla?",
            longDescription = "",
            imageUrl = "https://cocina-casera.com/wp-content/uploads/2018/01/Carne-a-la-parilla.jpg",
            time = 45,
            likes = 128
        ),
        Post(
            publisher = "Roberto Cuevas",
            shortDescription = "Chicharron de Cerdo",
            longDescription = "",
            imageUrl = "https://www.cocina-ecuatoriana.com/base/stock/Recipe/299-image/299-image_web.jpg",
            time = 120,
            likes = 1000
        ),
        Post(
            publisher = "Roberto Cuevas",
            shortDescription = "Chicharron de Cerdo",
            longDescription = "",
            imageUrl = "https://www.cocina-ecuatoriana.com/base/stock/Recipe/299-image/299-image_web.jpg",
            time = 120,
            likes = 1000
        ),
        Post(
            publisher = "Roberto Cuevas",
            shortDescription = "Chicharron de Cerdo",
            longDescription = "",
            imageUrl = "https://www.cocina-ecuatoriana.com/base/stock/Recipe/299-image/299-image_web.jpg",
            time = 120,
            likes = 1000
        )
    )
}