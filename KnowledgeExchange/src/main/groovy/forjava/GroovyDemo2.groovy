package forjava
import models.Picture

def pictures = [
        new Picture(name: 'Bathing of a Red Horse', author: 'Kuzma Petrov-Vodkin'),
        new Picture(name: 'Black Sqare', author: 'Kazimir Malevich'),
        new Picture(name: 'A Rye Field', author: 'Ivan Shishkin'),
        new Picture(name: 'Red Sqare', author: 'Kazimir Malevich'),
        new Picture(name: 'Morning in a Pine Forest', author: 'Ivan Shishkin'),
]

pictures.sort { pic1, pic2 -> pic2.author <=> pic1.author ?: pic1.name <=> pic2.name }.each{println it}


println 1.123.equals(1.12300)
println 1.123 == 1.12300

