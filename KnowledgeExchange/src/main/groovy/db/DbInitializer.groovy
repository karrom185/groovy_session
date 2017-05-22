package db

class DbInitializer {

    def init() {

        SqlConnectionFactory.withNewInstance {
            sql ->
                sql.execute 'drop table if exists picture'
                sql.execute 'drop table if exists category'
                sql.execute 'create table category( id INT , name VARCHAR(100))'
                sql.execute 'create table picture( id INT , name VARCHAR(100), author VARCHAR(100), category int)'

                [
                        [id: 1, author: 'Unknown', category: 1, name: 'animal/duckling-birds-yellow-fluffy-162140.jpeg'],
                        [id: 2, author: 'Unknown', category: 1, name: 'animal/hedgehog-animal-baby-cute-50577.jpeg'],
                        [id: 3, author: 'Unknown', category: 1, name: 'animal/kittens-cat-cat-puppy-rush-45170.jpeg'],
                        [id: 4, author: 'Unknown', category: 1, name: 'animal/owl-glitter-stuffed-animal-cute.jpg'],
                        [id: 5, author: 'Unknown', category: 1, name: 'animal/pexels-photo-134058.jpeg'],
                        [id: 6, author: 'Unknown', category: 1, name: 'animal/pexels-photo-169727.jpeg'],
                        [id: 7, author: 'Unknown', category: 1, name: 'animal/pexels-photo-227691.jpeg'],

                        [id: 8, author: 'Unknown', category: 2, name: 'beer/food-night-drink-glass.jpg'],
                        [id: 8, author: 'Unknown', category: 2, name: 'beer/pexels-photo-105036.jpeg'],
                        [id: 8, author: 'Unknown', category: 2, name: 'beer/pexels-photo-209582.png'],
                        [id: 8, author: 'Unknown', category: 2, name: 'beer/snow-restaurant-mountains-sky.jpg'],

                        [id: 12, author: 'Unknown', category: 3, name: 'space/galaxy-ngc-4594-m104-h1-43-87442.jpeg'],
                        [id: 12, author: 'Unknown', category: 3, name: 'space/pexels-photo-24027.jpg'],
                        [id: 12, author: 'Unknown', category: 3, name: 'space/pexels-photo-42439.jpeg'],
                        [id: 12, author: 'Unknown', category: 3, name: 'space/pexels-photo-220201.jpeg'],
                        [id: 12, author: 'Unknown', category: 3, name: 'space/pexels-photo-286280.jpeg']
                ].each {
                    sql.execute("insert into picture values ($it.id, $it.name, $it.author, $it.category)")
                }


                [
                        [id: 1, name: 'Animal'],
                        [id: 2, name: 'Beer'],
                        [id: 3, name: 'Space']
                ].each {
                    sql.execute("insert into category values ($it.id, $it.name)")
                }
        }

    }


}
