/*
 * Copyright <2021> <Pablo Herrera>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.pherrera.news.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cl.ucn.disc.dsm.pherrera.news.model.News;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public final class TestNews {

    @Test
    public void testConstructor() {

        log.debug("Testing Constructor ..");
        //Constructor OK
        {
            News news = new News(
                    "Titulo de Noticia",
                    "Fuente de la noticia",
                    "Autor de la noticia",
                    "URL de la noticia",
                    "El URL de la imagen de la noticia",
                    "La descripcion de la noticia",
                    "El contenido de la noticia",
                    org.threeten.bp.ZonedDateTime.now(org.threeten.bp.ZoneId.of("-4j"))

                    //ZonedDateTime.now(ZoneId.of("-4j"))
            );


                Assertions.assertNotNull(news, "The News was null");
                Assertions.assertNotNull(news.getTitle(), "The Title was null");
                Assertions.assertNotNull(news.getSource(), "The Source was null");
                Assertions.assertNotNull(news.getAuthor(), "The Author was null");
                Assertions.assertNotNull(news.getUrl(), "The URL was null");
                Assertions.assertNotNull(news.getUrlImage(), "The URL Image was null");
                Assertions.assertNotNull(news.getDescription(), "The Description was null");
                Assertions.assertNotNull(news.getContent(), "The Content was null");
                Assertions.assertNotNull(news.getPublishedAt(), "The PublishedAt was null");
        }

        //Constructor not OK
        {

                    Assertions.assertThrows(IllegalArgumentException.class, () -> new News(
                    null,
                    "Fuente de la noticia",
                    "Autor de la noticia",
                    "URL de la noticia",
                    "El URL de la imagen de la noticia",
                    "La descripcion de la noticia", "El contenido de la noticia",
                            org.threeten.bp.ZonedDateTime.now(org.threeten.bp.ZoneId.of("-4j"))
                    ));

                    Assertions.assertThrows(IllegalArgumentException.class, () -> new News(
                    "Titulo de Noticia",
                    null,
                    "Autor de la noticia",
                    "URL de la noticia",
                    "El URL de la imagen de la noticia",
                    "La descripcion de la noticia", "El contenido de la noticia",
                    org.threeten.bp.ZonedDateTime.now(org.threeten.bp.ZoneId.of("-4j"))
            ));

                    Assertions.assertThrows(IllegalArgumentException.class, () -> new News(
                    "Titulo de Noticia",
                    "Autor de la noticia",
                    null,
                    "URL de la noticia",
                    "El URL de la imagen de la noticia",
                    "La descripcion de la noticia", "El contenido de la noticia",
                    org.threeten.bp.ZonedDateTime.now(org.threeten.bp.ZoneId.of("-4j"))
            ));

                    //TODO: Test the description, content and publishedAt
        }

    }

    //Assertions.fail("The testing has failed");

}
