/*
 * Copyright <2021> <Pablo Herrera>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.pherrera.news.MainActivity

class MainActivity {
    import android.os.Bundle
    import androidx.appcompat.app.AppCompatActivity
    import androidx.recyclerview.widget.DividerItemDecoration
    import cl.ucn.disc.dsm.pjopia.databinding.ActivityMainBinding
    import cl.ucn.disc.dsm.pjopia.model.News
    import org.slf4j.LoggerFactory

    public final class MainActivity : AppCompatActivity() {

        private val log = LoggerFactory.getLogger(MainActivity::class.java)


        private static final Log

        private ActivityMainBinding binding;

        private NewsViewModel newsViewModel;

        private NewsAdapter newsAdapter;

        /**
         * @param savedInstanceState the instance.
         */

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState);
            this.binding = ActivityMainBinding.inflate(layoutInflater());
            setContentView(this.binding.getRoot());

            this.setSupportActionBar(this.binding.toolbar);

            this.newsViewModel= new ViewModelProvider(this).get(News.NewsViewModel class);


            this.binding.amSrRefresh.SetOnRefreshListener(() -->{
                log.debug("Refreshing  The News..")

                this.newsViewModel.refresh()
            });

            this.newsAdapter = new NewsAdapter();

            this.binding.amRvListnews.setLayoutManager(new LinearLayoutManager(this));
            this.binding.amRvListnews.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            this.binding.amRvListnews.setAdapter(this.Adapter);

            this.newsViewModel.getNews().observe(this, news--> ){
                Log.d("News: {}", news.size());

                this.newsAdapter.setNews(news);

                this.binding.amSrlRefresh.setRefreshing(false);
            }

        }

        override fun onStart() {
            super.onStart();
            Log.d("TheNews", "OnStart!!!");

        }


    }

}