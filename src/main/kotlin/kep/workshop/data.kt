package kep.workshop

val speakers = listOf(
    Speaker(
        id = "dmitry-savvinov",
        name = "Dmitry Savvinov",
        company = "JetBrains",
        description = """
            I've made my first acquaintance with Kotlin Team in 2016 during "JetBrains Summer Internship", where I was a part of the team responsible for implementing a translator from Kotlin to LLVM and then using it to deploy simple Kotlin program onto Raspberry Pi controller. Sometimes  One could say that was one of the very first Kotlin/Native programs :) (though the translator itself was terrible, obviously). 
            From 2016 to 2017 I was writing a Master thesis together with Kotlin team, which results were used later as foundation for a language feature known now as Kotlin Contracts. In Kotlin Team, my main field of interest is compiler's frontend: code analysis, type inference, etc. Currently I'm actively working on improving multiplatform projects support in the compiler and IDE.            
        """.trimIndent(),
        twitter = "dsavvinov"
    ),
    Speaker(
        id = "gaetan-zoritchak",
        name = "Gaetan Zoritchak",
        company = "Data2Viz",
        description = """
            Let's visualize the world.
            Gaetan is an enthusiastic father, developer, entrepreneur, paraglider pilot, …
            Having used lots of languages during its 20 years of IT experience, he believed very early in the promises of kotlin. He started in 2012 to code with it and in 2013 to promote it as a speaker.
        """.trimIndent(),
        webSite = "https://data2viz.io/"
    ),
    Speaker(
        id = "geoffrey-metais",
        name = "Geoffrey Métais",
        company = "VideoLAN",
        description = """
            Lead Android developer at VideoLAN and Videolabs.
        """.trimIndent(),
        twitter = "geoffreymetais",
        webSite = "https://geoffreymetais.github.io/"
    ),
    Speaker(
        id = "louis-cad",
        name = "Louis CAD",
        company = "Beepiz",
        description = """
            Android & Kotlin Dev. Efficiency before performance. Bike commuter, velomobile enthusiast.
        """.trimIndent(),
        twitter = "Louis_CAD"
    ),
    Speaker(
        id = "lucien-guimaraes",
        name = "Lucien Guimaraes",
        company = "Kapten",
        description = """
            Android Developer at Kapten. I’m currently improving our users’ life, working on the “Kapten Rider” application. I have been working as a mobile developer since 2013.
        """.trimIndent()
    ),
    Speaker(
        id = "martin-bonnin",
        name = "Martin Bonnin",
        company = "Dailymotion",
        description = """
            Martin est Engineering Manager chez Dailymotion. Baignant dans le monde Android depuis 2009, il est très heureux de pouvoir maintenant écrire du Kotlin et espère bientôt en écrire pour toutes les plateformes !
            En dehors du Kotlin, Martin aime les randonnées dans les Pyrénées et faire une petite partie de Hearthstone.
        """.trimIndent(),
        twitter = "martinbonnin",
        webSite = "https://mbonnin.net"
    ),
    Speaker(
        id = "mohamed-bennis",
        name = "Mohamed Bennis",
        company = "Octo Technology",
        description = """
            Développeur mobile chez Octo Technology, travail principalement sur des projets Android/Kotlin et s'intéresse de plus en plus sur le sujet du multiplateforme.
        """.trimIndent()
    ),
    Speaker(
        id = "remi-dormoy",
        name = "Rémi Dormoy",
        company = "Octo Technology",
        description = """
            Développeur mobile puis back-end chez Octo Technology, travail sur Kotlin et cherche à découvrir toutes les plateformes sur lesquelles il est possible de pousser ce langage.
        """.trimIndent()
    ),
    Speaker(
        id = "romain-boisselle",
        name = "Romain Boisselle",
        company = "Kodein Koders",
        description = """
            Je suis un développeur backend depuis 8 ans, principalement en Java + Spring et freelance depuis un an, centré sur les architectures backend.
            Je suis tombé amoureux de Kotlin il y a 4 ans, et l'utilise réellement en production depuis deux ans dans des projets backend. Java ne sera bientôt plus qu'un souvenir :)
            Je suis également un père comblé, et adepte du zéro gaspillage.
        """.trimIndent()
    ),
    Speaker(
        id = "riadh-mnasri",
        name = "Riadh Mnasri",
        company = "Enedis",
        description = """
            Passionate Developer, Clean Code Lover, Geek, Permanent Learner, Freelance, Happy Husband & Father #Java #Kotlin #CleanCode #FunctionalProgramming #TDD #BDD #DDD
        """.trimIndent(),
        twitter = "riadhmnasri",
        webSite = "https://www.linkedin.com/in/riadhmnasri/"
    ),
    Speaker(
        id = "salomon-brys",
        name = "Salomon Brys",
        company = "Kodein Koders",
        description = """
            Passionné de Kotlin depuis que Kotlin il y a, Salomon est le fondateur de Kodein Koders et du Kodein Framework. Fortement implanté dans la philosophie Open-Source, il se dédie à la création de librairie et d'outils pour rendre la programmation plus facile, sure, et fun.
            Il est aussi addict aux jeux de sociétés, et adore piloter des avions de loisir.
        """.trimIndent(),
        twitter = "salomonbrys",
        webSite = "https://kodein.net"
    ),
    Speaker(
        id = "sebastien-deleuze",
        name = "Sébastien Deleuze",
        company = "Pivotal",
        description = """
            Sébastien est committer Spring Framework chez Pivotal. Il travaille principalement sur le support de Kotlin des différents projets Spring, ainsi que sur les sujets Web et Reactive.
            Il a créé le project Spring Fu et est également membre de l'équipe qui organise la conférence MiXiT.
        """.trimIndent(),
        twitter = "sdeleuze",
        webSite = "https://spring.io/team/sdeleuze"
    ),
    Speaker(
        id = "yacine-rezgui",
        name = "Yacine Rezgui",
        company = "Google",
        description = """
            Yacine est \"Android Developer Advocate\" à Google, travaillant à faire d'Android la meilleure plateforme mobile pour les développeurs. Il se concentre sur l'expérience de développement à travers tout l'écosystème, de l'expert au débutant.
            Il a été \"Developer Advocate\" chez IBM et \"Full Stack Developer\" dans différentes startups. Il habite actuellement à Londres, Royaume Uni.
        """.trimIndent(),
        twitter = "yrezgui",
        webSite = "https://yrezgui.com"
    )
)

val talks = listOf(
    Talk(
        id = "androidx-coroutines",
        title = "AndroidX + coroutines = <3",
        description = """
            Le framework des coroutines est un outil révolutionnaire pour gérer l'asynchronisme et la concurrence.
            L'intégration avec le SDK d'Android n'est pas forcément évident mais se fait très bien et apporte de nombreux bénéfices.
            AndroidX apporte de nouveaux outils pour simplifier et améliorer cette intégration.
            Apprenez comment gérer plus facilement l'asynchronisme dans vos applications.
        """.trimIndent(),
        speaker = "geoffrey-metais"
    ),
    Talk(
        id = "codelab-arrow",
        title = "Programmation fonctionnelle avec Kotlin et Arrow-kt",
        description = """
            Connaître les facilités apportées par Arrow-kt qui permettent de faciliter l'écriture de programmes fonctionnelles avec Kotlin
        """.trimIndent(),
        type = "CODELAB",
        speaker = "riadh-mnasri"
    ),
    Talk(
        id = "codelab-spring",
        title = "Construire son back-end Kotlin/Spring Boot",
        description = """
            Depuis la version 5.0, Kotlin est officiellement supporté par Spring et nous pouvons donc profiter de tout cet univers et de cette communauté pour développer des back-ends robustes et performant dans notre langage préféré.  
            Dans ce codelab, nous verrons comment construire nos premiers endpoints en quelques minutes grâce à Spring Boot, puis nous découvrirons comment tester, documenter et dockerizer notre application.
        """.trimIndent(),
        type = "CODELAB",
        speaker = "remi-dormoy"
    ),
    Talk(
        id = "declarative-ui",
        title = "Be aware, Declarative UI are taking over!",
        description = """
            D'Android à iOS, en passant par le web, l'interface utilisateur s'écrit de plus en plus de manière déclarative à la place de fichiers XML ou de code impératif.
            Petit tour d'horizon sur cette nouvelle tendance sur toutes les plateformes de développement avec un focus sur Jetpack Compose.
        """.trimIndent(),
        speaker = "yacine-rezgui"
    ),
    Talk(
        id = "fullstack",
        title = "Kotlin Fullstack",
        description = """
            Dès le départ, Kotlin a été conçu pour être déployable dans divers contextes et plateformes: back et front, JVM, JS et natif.
            Dans un de nos derniers projets web, nous avons profité de cette caractéristique pour utiliser Kotlin au maximum, dans toutes les couches de notre application.
            Nous détaillerons l'architecture de ce projet lors de cette présentation, et comment nous avons utilisé des librairies multiplateformes pour partager du code entre le serveur et le navigateur.
            
            Les librairies et projets utilisés sont:
                - xodus-dnq, pour définir le modèle de données et accéder à la base xodus,
                - Ktor comme framework web,
                - Kotlinx.hmtl pour le templating html, serveur et client,
                - Kotlinx.serialization pour le partage d’état entre le serveur et le client,
                - Kotlin/JS et une implémentation interne de Redux pour le code client.
        """.trimIndent(),
        speaker = "gaetan-zoritchak"
    ),
    Talk(
        id = "gradle-dsl",
        title = "Gradle Kotlin DSL, une alternative comme outil de release ?",
        description = """
            Gradle 5.0 est sorti avec de nombreuses fonctionnalités et en particulier avec le support de Kotlin DSL en 1.0.
            Durant cette présentation, nous verrons les possibilités d'utiliser ce nouvel outil de scripting comme alternative à Fastlane, qui est actuellement utilisé chez Kapten.
        """.trimIndent(),
        speaker = "lucien-guimaraes"
    ),
    Talk(
        id = "multiplatform-kotlin13",
        title = "Multiplatform Programming in Kotlin 1.3",
        description = """
            Kotlin Multiplatform is a language feature which provides the ability to share and re-use common code across different platforms. The very first iteration was announced in Kotlin 1.2, and since then, multiplatform technology has greatly evolved.
            In this talk, we'll give a consistent, cumulative overview of the most recent features and changes in multiplatform projects support in Kotlin. Also, we'll explain why these changes were made and what new opportunities they unlock.
            The talk is well-suited both for beginners who want to get an introduction into technology, and for advanced users who want to hear latest news and insights about multiplatform programming in Kotlin.
        """.trimIndent(),
        speaker = "dmitry-savvinov"
    ),
    Talk(
        id = "native-lib",
        title = "Créer une bibliothèque pour Android et iOS avec Kotlin/Native",
        description = """
            Le partage de code entre différentes plateformes est devenu une pratique de plus en plus utilisée dans le monde du développement mobile.
            Grace à Kotlin/Native nous pouvons mutualiser notre code d'une manière différente et le réutiliser afin de gagner en temps de développement.
            A travers mon POC "Convertisseur de devise" et un mini live coding nous apprendrons ensemble :
                * comment configurer un projet avec Kotlin/Native
                * comment mutualiser les différentes parties d'une application mobile
                * comment organiser son code avec une variante de la clean architecture et le tester
        """.trimIndent(),
        speaker = "mohamed-bennis"
    ),
    Talk(
        id = "ouverture",
        title = "Ouverture",
        description = """
            Venez rencontrer le staff de la conférence et découvrir les dernières tendances Kotlin!
        """.trimIndent()
    ),
    Talk(
        id = "react",
        title = "Un site entièrement en Kotlin avec Kotlin-React",
        description = """
            Savez vous qu'il est possible d'écrire un site web entièrement en Kotlin ? Pas de HTML, pas de CSS, pas de JS. Que du Kotlin. Et en declarative UI, s'il vous plaît !
            Dans cette présentation, nous plongerons dans le code du site web de la conférence, site static hébergé sur Github.
            Nous verrons comment utiliser React en Kotlin, comment générer la page HTML hôte, comment intégrer du CSS directement dans les composants, et même comment accélérer le chargement en utilisant React-SSR (Server-Side Rendering).
        """.trimIndent(),
        speaker = "salomon-brys"
    ),
    Talk(
        id = "spring",
        title = "Quoi de neuf sur le support de Kotlin dans Spring ?",
        description = """
            La première partie de cette conférence donnera un aperçu de l'état de l'art du développement d'applications Spring Boot 2.2 avec Kotlin:
                - Data classes immutables avec @ConfigurationProperties
                - Tests avec JUnit 5 et Mockk
                - La nouvelle DSL “router” pour Spring MVC
                - Le support des Coroutines sur WebFlux, RSocket et Spring Data
                - Les exemples de code en Kotlin dans la documentation de référence
                - La DSL MockMvc
                - Un rappel des bonnes pratiques (extensions, injection de dépendances via constructeur)
            La seconde partie sera un live coding d'une application Spring Boot configurée avec Kofu, la DSL Kotlin actuellement développée dans l'incubateur Spring Fu que j'ai créé il y a quelques mois. Il s'agit d'une alternative à l'auto-configuration Spring Boot conçue pour configurer votre application de manière explicite en utilisant l'auto-complétion et des "slices" de configuration tout en supportant la plupart des fonctionnalités de Spring Boot.
        """.trimIndent(),
        speaker = "sebastien-deleuze"
    ),
    Talk(
        id = "study-lib-coroutines",
        title = "Étude d'une bibliothèque à base de coroutines",
        description = """
            Dans cette session, je vais vous montrer avec mon IDE comment j'ai pu faire une API super simple en partant d'une API type callback hell, et comment vous aussi vous pouvez vous libérer des complexités d'une API une bonne fois pour toutes grâce aux coroutines.
            
            Nous étudieront la bibliothèque BleGattCoroutines pour Android qui permet de se connecter à un appareil Bluetooth Low Energy tel qu'un beacon, et de communiquer avec.
            
            Petite histoire :
            Les beacons sont des balises de localisation d'intérieur utilisant le Bluetooth Low Energy.
            Il y a 2 ans, j'ai eu besoin d'en configurer par programmation afin de semi-automatiser leur réglage et enregistrement.
            Le fournisseur de beacons fournissait un SDK non open-source, qu'il était tout de même possible de décompiler facilement car fait en Java et non obfusqué. Cela ne fut cependant pas nécessaire, j'ai déchanté dès que j'ai vu le code du sample où il y avait littéralement un warning toutes les 2 lignes, et une API dont la conception me repoussait.
            J'ai alors fouillé dans la spécification open-source du protocole Eddystone utilisé par nos beacons, ai vu une lueur d'espoir, mais j'allais avoir besoin de l'API Bluetooth GATT d'Android, qui est un callback hell. C'était au moment où je débutais dans les coroutines. En une semaine, j'ai appris les Channel de kotlinx.coroutines et ai mis au point BleGattCoroutines, qui nous avons rendu open-source (Apache 2). La semaine d'après, j'ai programmé les beacons sur cette base et suis devenu fan des coroutines depuis.
        """.trimIndent(),
        speaker = "louis-cad"
    ),
    Talk(
        id = "workflows",
        title = "Automatisez vos workflows avec Kotlin",
        description = """
            Ce talk est un retour d'expérience sur la manière dont nous utilisons kotlin à toutes les étapes du développement de notre app Android chez Dailymotion:
            
            * sur les machines de dev, pour la gestion des pull requests, connection jira et déploiement avec un outil en ligne de commande utilisant Clikt.
            * sur les serveurs de CI avec un runner kotlin qui execute la compilation, tests et envoi des artifacts.
            * sur un servlet Google Cloud pour héberger nos artifacts et Kdoc.
            * sur un cron pour monitorer les commentaires utilisateurs du Google Play.
            * enfin, de manière générale, pour remplacer bash et perl par du kotlin partout grâce à kscript!
            
            Le but du talk n'est pas d'aller dans le détail de chaque technologie mais plus de montrer l'étendue des possibles. L'écosystème kotlin rend accessible un grand nombre de tâches.
        """.trimIndent(),
        speaker = "martin-bonnin"
    ),
    Talk(
        id = "workshop-multiplatform",
        title = "Kotlin multi platformes mobiles",
        description = """
            Grâce au langage Kotlin et à son outillage, nous pouvons créer des applications qui pour Android, iOS et le Web.
            Dans ce workshop nous verrons comment utiliser Kotlin pour réutiliser notre code métier à travers multiple platformes. Nous verrons comment définir l'architecture de notre applications, créer les abstractions nécéssaires pour obtenir un code réutilisables, comment tester ce code sur toutes ces platformes, et enfin comment le déployer.
            Grâce à une série d'exercices simples, nous créerons ensemble une application qui pourra être déployée sur chaque platforme, chacune conservant sa propre couche de présentation.
            Notez que bien qu'un MacBook est recommandé si vous souhaitez déployer sur iOS ; un PC sous linux ou windows vous permettra d'utiliser Kotlin/JVM, Kotlin/JS et Kotlin/Native.
        """.trimIndent(),
        type = "WORKSHOP",
        speaker = "salomon-brys"
    ),
    Talk(
        id = "workshop-cloud",
        title = "Cloud moderne en Kotlin",
        description = """
            Dans ce workshop, nous verrons une nouvelle manière de coder des serveurs en Kotlin, grâce à une librarie développée par Jetbrains : Ktor, un framework permettant de créer un serveur entièrement asynchrone grâce à la puissance du langage Kotlin et de ses coroutines.
            Nous commencerons par présenter Ktor et ses utilisations les plus simples pour créer, en quelques lignes, un serveur simple permettant de servir une API et du contenu statique. Nous verrons ensuite comment utiliser certaines des fonctionalités plus avancées, notemment liées à la sécurité et aux systèmes complexes.
            Enfin, nous verrons comment intégrer d'autres librairies utilisant Kotlin et permettant d'architecturer notre code et facilitant grandement la gestion de notre base de données. En 3h30, vous aurez un serveur léger, puissant, lisible et sécurisé !
        """.trimIndent(),
        type = "WORKSHOP",
        speaker = "romain-boisselle"
    )
)