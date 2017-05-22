package models

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode

@Canonical
@EqualsAndHashCode(includes = ['id'])
class Picture {
    String name
    String author
    Integer id
    Integer category
}


@Canonical
@EqualsAndHashCode(includes = ['id'])
class Category {
    Integer id
    String name
}





