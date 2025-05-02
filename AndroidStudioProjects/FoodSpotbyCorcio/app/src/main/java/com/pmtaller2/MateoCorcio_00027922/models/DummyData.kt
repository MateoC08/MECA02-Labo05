package com.pmtaller2.MateoCorcio_00027922.models

val categories = listOf(
    Category(id = 1, name = "Comida Rápida"),
    Category(id = 2, name = "Comida Mexicana"),
    Category(id = 3, name = "Comida Italiana"),
    Category(id = 4, name = "Comida Asiatica"),
    Category(id = 5, name = "Comida Saludable"),
    Category(id = 6, name = "Postres y Dulces"),
    Category(id = 7, name = "Bebidas")
)

val restaurants = listOf(
    // Comida Rápida
    Restaurant(
        id = 1,
        name = "Pizza Planet",
        description = "Las mejores pizzas del universo",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTehn6ZGkXeKwQ9LnF4RtwExnB3H3rNdm1WA&s",
        categories = listOf("Comida Italiana", "Comida Rápida"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Pizza Pepperoni",
                description = "Clásica pizza con pepperoni y queso.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCiW5pVbw2nkJUAWRa2PeHDuIa7ddJIshVeQ&s"
            ),
            Dish(
                id = 2,
                name = "Pizza Margarita",
                description = "Pizza con tomate, mozzarella y albahaca.",
                imageUrl = "https://pizzeriaciao.es/wp-content/uploads/2020/03/BLOG-RECETA-PIZZA-MARGARITA-MAR17-800x600-1.jpg.webp"
            )
        )
    ),
    Restaurant(
        id = 2,
        name = "Burger King",
        description = "Las hamburguesas más sabrosas",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Burger_King_2020.svg/1200px-Burger_King_2020.svg.png",
        categories = listOf("Comida Rápida"),
        menu = listOf(
            Dish(
                id = 3,
                name = "Whopper",
                description = "Hamburguesa clásica con carne, queso, y vegetales.",
                imageUrl = "https://tb-static.uber.com/prod/image-proc/processed_images/e3af3b04a6ac83073175dd28cfa29587/cc592037c936600295e9961933037e19.jpeg"
            ),
            Dish(
                id = 4,
                name = "Papas Fritas",
                description = "Papas fritas crujientes.",
                imageUrl = "https://bk-latam-prod.s3.amazonaws.com/sites/burgerking.latam/files/BK_Web_patatas_500X540px_Resized.png"
            )
        )
    ),
    Restaurant(
        id = 3,
        name = "Subway",
        description = "Sándwiches frescos y deliciosos.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5Wc7cutXSY9sE68X9uXGGfVaulQ27umhNrg&s",
        categories = listOf("Comida Rápida"),
        menu = listOf(
            Dish(
                id = 5,
                name = "Sándwich de Pollo",
                description = "Pollo a la parrilla con verduras frescas.",
                imageUrl = "https://www.subway.com/ns/images/menu/ELS/SPA/menu-category-sandwich-ovnrstdchicken.jpg"
            ),
            Dish(
                id = 6,
                name = "Sándwich Veggie",
                description = "Verduras frescas con aderezos especiales.",
                imageUrl = "https://www.subway.com/ns/images/menu/ELS/SPA/menu-category-sandwich-veggiedelite.jpg"
            )
        )
    ),

    // Comida Mexicana
    Restaurant(
        id = 4,
        name = "Taco Loco",
        description = "Auténtica comida mexicana para los amantes del picante.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnqbm8O3fEPC6RIJx_g6RMXWF0c2GjIX2Uaw&s",
        categories = listOf("Comida Mexicana"),
        menu = listOf(
            Dish(
                id = 7,
                name = "Tacos al Pastor",
                description = "Tacos con carne de cerdo marinada.",
                imageUrl = "https://s3.amazonaws.com/static.realcaliforniamilk.com/media/recipes_2/tacos-al-pastor.jpg"
            ),
            Dish(
                id = 8,
                name = "Burrito Especial",
                description = "Gran tortilla rellena de frijoles, arroz y carne.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSN9R4WKE9kQnNJKitDCVhAi1LluR10SwO9xQ&s"
            )
        )
    ),
    Restaurant(
        id = 5,
        name = "La Casa del Taco",
        description = "Tacos tradicionales con sabor casero.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZ_qkCBx-tdB_dTWxAJKx9RU9HxkAHn2Lfeg&s",
        categories = listOf("Comida Mexicana"),
        menu = listOf(
            Dish(
                id = 9,
                name = "Tacos de Carne Asada",
                description = "Carne asada con cebolla y cilantro.",
                imageUrl = "https://s3.amazonaws.com/static.realcaliforniamilk.com/media/recipes_2/carna-asada-street-tacos.jpg"
            ),
            Dish(
                id = 10,
                name = "Quesadilla de Pollo",
                description = "Quesadilla rellena de pollo y queso derretido.",
                imageUrl = "https://newmansown.com/wp-content/uploads/2022/03/Apple-Chicken-Quesadilla-1200x900.png"
            )
        )
    ),
    Restaurant(
        id = 6,
        name = "El Mariachi",
        description = "Comida mexicana auténtica y deliciosa.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyU16ZDIW7oRUFXXT5wfcgSZ9z3YUGluNuIQ&s",
        categories = listOf("Comida Mexicana"),
        menu = listOf(
            Dish(
                id = 11,
                name = "Tacos de Barbacoa",
                description = "Tacos con carne de barbacoa y salsa casera.",
                imageUrl = "https://familiakitchen.com/wp-content/uploads/2021/01/iStock-960337396-3beef-barbacoa-tacos-e1695391119564.jpg"
            ),
            Dish(
                id = 12,
                name = "Guacamole con Totopos",
                description = "Guacamole fresco acompañado de totopos.",
                imageUrl = "https://vidapicante.com/wp-content/uploads/2023/01/tortillas-con-guacamole.jpg"
            )
        )
    ),

    // Comida Italiana
    Restaurant(
        id = 7,
        name = "La Trattoria",
        description = "Comida italiana clásica y deliciosa.",
        imageUrl = "https://static.wixstatic.com/media/06a864_9ac93d88d62544f5a7d4d1932f2641d2~mv2_d_2664_1464_s_2.png/v1/fit/w_2500,h_1330,al_c/06a864_9ac93d88d62544f5a7d4d1932f2641d2~mv2_d_2664_1464_s_2.png",
        categories = listOf("Comida Italiana"),
        menu = listOf(
            Dish(
                id = 13,
                name = "Lasagna",
                description = "Lasagna de carne con salsa bechamel.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ60zibfrdNtwPw-jzCHhk3-NsHf93JCn6TuA&s"
            ),
            Dish(
                id = 14,
                name = "Spaghetti Bolognese",
                description = "Spaghetti con salsa de carne y tomate.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5EIdSE-Pjt5U2LrtAI90ox4uOKgk1-hPW6w&s"
            )
        )
    ),
    Restaurant(
        id = 8,
        name = "Pasta & Pizza",
        description = "Especialistas en pasta fresca y pizzas al horno.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPz60CGNOG1aju8X7DuasVgAWNo04NTpOB0Q&s",
        categories = listOf("Comida Italiana"),
        menu = listOf(
            Dish(
                id = 15,
                name = "Pizza Margherita",
                description = "Pizza clásica con mozzarella y albahaca.",
                imageUrl = "https://www.stefanofaita.com/wp-content/uploads/2022/04/pizzamargherita1.jpg"
            ),
            Dish(
                id = 16,
                name = "Fettucine Alfredo",
                description = "Fettucine con salsa Alfredo cremosa.",
                imageUrl = "https://assets.tmecosys.com/image/upload/t_web_rdp_recipe_584x480_1_5x/img/recipe/ras/Assets/66cef03a-bad8-4c37-aba8-769aa62ec076/Derivates/d5049f83-4843-4504-aa92-253f1e141650.jpg"
            )
        )
    ),
    Restaurant(
        id = 9,
        name = "Osteria Bella",
        description = "Comida italiana tradicional con un toque moderno.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1aPGoaJpFnpt6AURWxEjxLp5GtEmlEi_BQQ&s",
        categories = listOf("Comida Italiana"),
        menu = listOf(
            Dish(
                id = 17,
                name = "Risotto de Champiñones",
                description = "Risotto cremoso con champiñones frescos.",
                imageUrl = "https://cocina-casera.com/wp-content/uploads/2023/03/rissoto-champinones.jpeg"
            ),
            Dish(
                id = 18,
                name = "Pizza Cuatro Estaciones",
                description = "Pizza con cuatro tipos de ingredientes.",
                imageUrl = "https://recetinas.com/wp-content/uploads/2022/11/Pizza-cuatro-estaciones.jpg"
            )
        )
    ),
    Restaurant(
        id = 10,
        name = "Sakura Express",
        description = "Comida asiática fresca y deliciosa.",
        imageUrl = "https://play-lh.googleusercontent.com/ScWPB8wv2L4SmKjIr3cjtJLaVt1XA6Q8U_-r67-EaCBMi4Tr7oq3M4WRGaWTvGuSMQ",
        categories = listOf("Comida Asiatica"),
        menu = listOf(
            Dish(id = 19, name = "Sushi Roll", description = "Sushi clásico con salmón.", imageUrl = "https://simmerandsage.com/wp-content/uploads/2023/09/Crunchy-California-Roll1.jpg"),
            Dish(id = 20, name = "Ramen", description = "Sopa japonesa con fideos y cerdo.", imageUrl = "https://cdn7.kiwilimon.com/recetaimagen/36172/640x640/44468.jpg.jpg"),
        )
    ),
    Restaurant(
        id = 11,
        name = "Green Bites",
        description = "Opciones saludables y sabrosas.",
        imageUrl = "https://greenbitesgo.com/cdn/shop/files/greenbites_1200x1200.png?v=1721828753",
        categories = listOf("Comida Saludable"),
        menu = listOf(
            Dish(id = 22, name = "Ensalada César", description = "Clásica ensalada con pollo.", imageUrl = "https://www.goodnes.com/sites/g/files/jgfbjl321/files/srh_recipes/755f697272cbcdc6e5df2adb44b1b705.jpg"),
            Dish(id = 23, name = "Bowl de Quinoa", description = "Bowl nutritivo con vegetales.", imageUrl = "https://d36fw6y2wq3bat.cloudfront.net/recipes/bowl-de-quinua-pollo-y-aguacate/900/bowl-de-quinua-pollo-y-aguacate_version_1652869865.jpg"),
        )
    ),
    Restaurant(
        id = 12,
        name = "Dulce Tentación",
        description = "Postres irresistibles para todos los gustos.",
        imageUrl = "https://d229ddbpqtk4gd.cloudfront.net/images/630189.png",
        categories = listOf("Postres y Dulces"),
        menu = listOf(
            Dish(id = 25, name = "Pastel de Chocolate", description = "Pastel suave con cobertura de chocolate.", imageUrl = "https://sarasellos.com/wp-content/uploads/2024/06/pastel-chocolate-oscuro-4.jpg"),
            Dish(id = 26, name = "Cheesecake", description = "Tarta de queso con base crujiente.", imageUrl = "https://peopleenespanol.com/thmb/8vzve3hmeCgC-SVqkvAmuXnMMBE=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/cheesecake-facil-con-leche-condensada-2000-4160526441114bf3ad8f3409586a2c8a.jpg"),
        )
    ),
    Restaurant(
        id = 13,
        name = "Bebidas del Mundo",
        description = "Refrescos y bebidas de diferentes culturas.",
        imageUrl = "https://www.beerpassclub.com/wp-content/uploads/2022/11/summer-drink-with-strawberry-2022-09-29-22-34-05-utc-scaled-1-scaled.jpg",
        categories = listOf("Bebidas"),
        menu = listOf(
            Dish(id = 28, name = "Té Chai", description = "Té especiado tradicional de India.", imageUrl = "https://cdn6.recetasdeescandalo.com/wp-content/uploads/2020/03/Te-chai-latte-en-casa.jpg"),
            Dish(id = 29, name = "Jugo Natural", description = "Jugo de frutas naturales recién exprimido.", imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9Ea2KBouOsrzI-QErWVHyI0zuvFeZfGXfxg&s"),
        )
    )
)
