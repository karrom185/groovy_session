package services

import db.SqlConnectionFactory
import groovy.json.JsonOutput
import groovy.util.logging.Slf4j
import models.Category
import models.Picture

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Path('/pictures')
@Slf4j
class PicturesService {

    def pictureParser = {
        new Picture(id: it.id, name: it.name, author: it.author, category: it.category)
    }

    def pictureParserWith = {picture ->
        picture.with {
            new Picture(id: id, name: name, author: author, category: category)
        }
    }

    def categoryParser = {
        new Category(id: it.id, name: it.name)
    }

    @GET
    @Path('/pictures')
    def listAllPictures() {
        SqlConnectionFactory.withNewInstance {
            sql ->
                JsonOutput.toJson sql.rows('SELECT * FROM picture').collect(pictureParserWith)
        }
    }

    @GET
    @Path('/pictures/{category}')
    def listPicturesByCategory(@PathParam('category') String category) {
        log.info "Processing category $category"
        def categoryId = category.toInteger()
        SqlConnectionFactory.withNewInstance {
            sql ->
                JsonOutput.toJson sql.rows('SELECT * FROM picture WHERE category = :category', [category: categoryId]).collect(pictureParser)
        }
    }


    @GET
    @Path('/carousel')
    def getCarouselItems() {
        SqlConnectionFactory.withNewInstance {
            sql ->
                sql.rows("SELECT id FROM category").collect {
                    sql.firstRow("SELECT * FROM picture WHERE category = :category", [category: it.id]).with(pictureParser)
                }.asJson()
        }

    }

    @GET
    @Path('/categories')
    def getCategories() {
        SqlConnectionFactory.withNewInstance {
            sql ->
                sql.rows("SELECT * FROM category").collect(categoryParser).asJson()
        }
    }
}
