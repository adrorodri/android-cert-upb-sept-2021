package edu.upb.cocinaya.data

import edu.upb.cocinaya.model.Post

object TempDataSource {
    val postList = mutableListOf(
        Post(
            publisher = "Andre Machicado",
            shortDescription = "Enchiladas Suizas en Microondas!",
            imageUrl = "https://cdn7.kiwilimon.com/recetaimagen/26245/th5-320x213-38984.jpg",
            time = 15,
            likes = 256
        ),
        Post(
            publisher = "Joel Jarro",
            shortDescription = "Carne a la parrilla, sin parrilla?",
            imageUrl = "https://cocina-casera.com/wp-content/uploads/2018/01/Carne-a-la-parilla.jpg",
            time = 45,
            likes = 128
        ),
        Post(
            publisher = "Roberto Cuevas",
            shortDescription = "Chicharron de Cerdo",
            imageUrl = "https://www.cocina-ecuatoriana.com/base/stock/Recipe/299-image/299-image_web.jpg",
            time = 120,
            likes = 1000
        )
    )
}